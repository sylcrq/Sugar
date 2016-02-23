package com.syl.sugar.database;

import android.provider.BaseColumns;

/**
 * database
 *
 * Created by syl on 16/2/23.
 */
public final class SugarContract {

    public SugarContract() {
    }

    /**
     * table entry
     */
    public static abstract class SugarEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENT = "content";
    }

}
