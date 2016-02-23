package com.syl.sugar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by syl on 16/2/24.
 */
public class DatabaseFactory {

    private static DatabaseFactory mInstance;  // 单例

    private Context mContext;
    private SugarDbHelper mDbHelper;

    private DatabaseFactory(Context context) {
        this.mContext = context;
        this.mDbHelper = new SugarDbHelper(context);
    }

    public static DatabaseFactory getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new DatabaseFactory(context);
        }

        return mInstance;
    }

    /**
     * 插入数据
     *
     * @param id
     * @param title
     * @param content
     */
    public void insert(String id, String title, String content) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SugarContract.SugarEntry.COLUMN_NAME_ENTRY_ID, id);
        values.put(SugarContract.SugarEntry.COLUMN_NAME_TITLE, title);
        values.put(SugarContract.SugarEntry.COLUMN_NAME_CONTENT, content);

        long newRowId = database.insert(SugarContract.SugarEntry.TABLE_NAME, "null", values);
    }

    /**
     * 获取数据
     *
     * @param selection
     * @param selectionArgs
     */
    public void get(String selection, String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        String[] projection = {
                SugarContract.SugarEntry._ID,
                SugarContract.SugarEntry.COLUMN_NAME_TITLE,
                SugarContract.SugarEntry.COLUMN_NAME_CONTENT
        };

        String sortOrder = SugarContract.SugarEntry.COLUMN_NAME_ENTRY_ID + " DESC";

        Cursor cursor = database.query(
                SugarContract.SugarEntry.TABLE_NAME,  // The table to query
                projection,     // The columns to return
                selection,      // The columns for the WHERE clause
                selectionArgs,  // The values for the WHERE clause
                null,           // don't group the rows
                null,           // don't filter by row groups
                sortOrder       // The sort order
                );

        cursor.moveToFirst();
        cursor.getLong(cursor.getColumnIndexOrThrow(SugarContract.SugarEntry._ID));
        cursor.getString(cursor.getColumnIndexOrThrow(SugarContract.SugarEntry.COLUMN_NAME_TITLE));
        cursor.getString(cursor.getColumnIndexOrThrow(SugarContract.SugarEntry.COLUMN_NAME_CONTENT));
    }

    /**
     * 删除数据
     *
     * @param rowId
     */
    public void delete(int rowId) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // Define 'where' part of query.
        String selection = SugarContract.SugarEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(rowId) };

        database.delete(
                SugarContract.SugarEntry.TABLE_NAME,
                selection,
                selectionArgs
                );
    }
}
