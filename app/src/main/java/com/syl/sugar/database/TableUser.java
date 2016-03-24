package com.syl.sugar.database;

import android.provider.BaseColumns;

/**
 * Created by shenyunlong on 3/24/16.
 *
 * @see com.syl.sugar.model.User
 */
public class TableUser implements BaseColumns, BaseTable {
    // Table Names
    public static final String TABLE_NAME = "User";

    // User Table Columns
    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_PROFILE_PIC_URL = "profilePictureUrl";

    public static final String CREATE_TABLE_SQL =
            CREATE_TABLE + " " + TABLE_NAME +
            " (" +
                _ID + " " + INTEGER + " " + PRIMARY_KEY + COMMA +
                KEY_USER_NAME + " " + TEXT +COMMA +
                KEY_USER_PROFILE_PIC_URL + " " + TEXT +
            ")";

    public static final String DELETE_TABLE_SQL =
            DROP_TABLE + " " + TABLE_NAME;
}
