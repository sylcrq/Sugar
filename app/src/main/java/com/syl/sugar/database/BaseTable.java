package com.syl.sugar.database;


/**
 * Created by shenyunlong on 3/24/16.
 */
public interface BaseTable {
    String CREATE_TABLE = "CREATE TABLE";
    String DROP_TABLE = "DROP TABLE IF EXISTS";

    String INTEGER = "INTEGER";
    String TEXT = "TEXT";
    String PRIMARY_KEY = "PRIMARY KEY";
    String REFERENCES = "REFERENCES";
    String COMMA = ",";
    String SPACE = " ";
}
