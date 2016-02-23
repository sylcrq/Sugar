package com.syl.sugar.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Saving Data in SQL Databases
 *
 * Created by syl on 16/2/23.
 */
public class SugarDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Sugar.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SugarContract.SugarEntry.TABLE_NAME + " (" +
                    SugarContract.SugarEntry._ID + "INTEGER PRIMARY KEY," +
                    SugarContract.SugarEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    SugarContract.SugarEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    SugarContract.SugarEntry.COLUMN_NAME_CONTENT + TEXT_TYPE + COMMA_SEP +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SugarContract.SugarEntry.TABLE_NAME;

    public SugarDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}
