package com.syl.sugar.database;

import android.provider.BaseColumns;

/**
 * Created by shenyunlong on 3/24/16.
 *
 * @see com.syl.sugar.model.Post
 */
public class TablePost implements BaseColumns, BaseTable {
    // Table Names
    public static final String TABLE_NAME = "Post";

    // Post Table Columns
    public static final String KEY_POST_USER_ID_FK = "userId";
    public static final String KEY_POST_TEXT = "text";

    public static final String CREATE_TABLE_SQL =
            CREATE_TABLE + " " + TABLE_NAME +
            " (" +
                _ID + " " + INTEGER + " " + PRIMARY_KEY + COMMA +
                KEY_POST_USER_ID_FK + " " + INTEGER + " " + REFERENCES + " " + TableUser.TABLE_NAME + COMMA +
                KEY_POST_TEXT + " " + TEXT +
            ")";

    public static final String DELETE_TABLE_SQL =
            DROP_TABLE + " " + TABLE_NAME;
}
