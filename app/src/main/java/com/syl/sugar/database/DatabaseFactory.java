package com.syl.sugar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.syl.sugar.model.Post;
import com.syl.sugar.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syl on 16/2/24.
 */
public class DatabaseFactory {

    public static final String TAG = DatabaseFactory.class.getSimpleName();

    private static DatabaseFactory mInstance;  // 单例

    private Context mContext;
    private SugarDbHelper mDbHelper;

    private DatabaseFactory(Context context) {
        this.mContext = context;
        this.mDbHelper = new SugarDbHelper(context);
    }

    public static synchronized DatabaseFactory getInstance(Context context) {
        if(mInstance == null) {
            // Use the application context, which will ensure that you
            // don't accidentally leak an Activity's context.
            // See this article for more information: http://bit.ly/6LRzfx
            mInstance = new DatabaseFactory(context.getApplicationContext());
        }

        return mInstance;
    }

    /**
     * Inserting New Records
     *
     * @param post
     */
    public void addPost(Post post) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        database.beginTransaction();

        try {
            long userId = addOrUpdateUser(post.user);

            ContentValues values = new ContentValues();
            values.put(TablePost.KEY_POST_USER_ID_FK, userId);
            values.put(TablePost.KEY_POST_TEXT, post.text);

            database.insertOrThrow(TablePost.TABLE_NAME, null, values);
            database.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to add post to database");
        } finally {
            database.endTransaction();
        }
    }

    public long addOrUpdateUser(User user) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        long userId = -1;

        database.beginTransaction();

        try {
            ContentValues values = new ContentValues();
            values.put(TableUser.KEY_USER_NAME, user.userName);
            values.put(TableUser.KEY_USER_PROFILE_PIC_URL, user.profilePictureUrl);

            // First try to update the user in case the user already exists in the database
            // This assumes userNames are unique
            int row = database.update(TableUser.TABLE_NAME, values, TableUser.KEY_USER_NAME + " = ?", new String[]{user.userName});
            // Check if update succeeded
            if(row == 1) {
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?", TableUser._ID, TableUser.TABLE_NAME, TableUser.KEY_USER_NAME);

                Cursor cursor = database.rawQuery(usersSelectQuery, new String[]{user.userName});
                try {
                    if(cursor.moveToFirst()) {
                        userId = cursor.getInt(0);
                        database.setTransactionSuccessful();
                    }
                } finally {
                    if(cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                userId = database.insertOrThrow(TableUser.TABLE_NAME, null, values);
                database.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to add or update user");
        } finally {
            database.endTransaction();
        }

        return userId;
    }

    /**
     * Querying Records
     *
     * @return
     */
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String POSTS_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TablePost.TABLE_NAME,
                        TableUser.TABLE_NAME,
                        TablePost.TABLE_NAME, TablePost.KEY_POST_USER_ID_FK,
                        TableUser.TABLE_NAME, TableUser._ID);

        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(POSTS_SELECT_QUERY, null);

        try {
            if(cursor.moveToFirst()) {
                do {
                    User user = new User();
                    user.userName = cursor.getString(cursor.getColumnIndex(TableUser.KEY_USER_NAME));
                    user.profilePictureUrl = cursor.getString(cursor.getColumnIndex(TableUser.KEY_USER_PROFILE_PIC_URL));

                    Post post = new Post();
                    post.user = user;
                    post.text = cursor.getString(cursor.getColumnIndex(TablePost.KEY_POST_TEXT));

                    posts.add(post);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to get posts from database");
        } finally {
            if(cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return posts;
    }

    /**
     * Updating Records
     *
     * @param user
     * @return
     */
    public int updateUserProfilePicture(User user) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TableUser.KEY_USER_PROFILE_PIC_URL, user.profilePictureUrl);

        return database.update(TableUser.TABLE_NAME, values, TableUser.KEY_USER_NAME + " = ?", new String[]{user.userName});
    }

    /**
     * Deleting Records
     */
    public void deleteAllPostsAndUsers() {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        database.beginTransaction();

        try {
            // Order of deletions is important when foreign key relationships exist.
            database.delete(TablePost.TABLE_NAME, null, null);
            database.delete(TableUser.TABLE_NAME, null, null);
            database.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Error while trying to delete all posts and users");
        } finally {
            database.endTransaction();
        }
    }
}
