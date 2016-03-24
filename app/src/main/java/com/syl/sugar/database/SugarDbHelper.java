package com.syl.sugar.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

/**
 * Saving Data in SQL Databases
 *
 * Created by syl on 16/2/23.
 */
public class SugarDbHelper extends SQLiteOpenHelper {

    public static final String TAG = SugarDbHelper.class.getSimpleName();

    // Database Info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Sugar.db";

    public SugarDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");

        db.execSQL(TablePost.CREATE_TABLE_SQL);
        db.execSQL(TableUser.CREATE_TABLE_SQL);
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade # oldVersion=" + oldVersion + ", newVersion=" + newVersion);

        if(oldVersion != newVersion) {
            db.execSQL(TablePost.DELETE_TABLE_SQL);
            db.execSQL(TableUser.DELETE_TABLE_SQL);

            onCreate(db);
        }
    }
}
