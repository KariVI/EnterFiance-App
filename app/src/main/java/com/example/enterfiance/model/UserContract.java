package com.example.enterfiance.model;

import android.provider.BaseColumns;

public class UserContract {
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "User";

    }
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "fullname TEXT NOT NULL," +
                    "username TEXT NOT NULL," +
                    "phonenumber TEXT,"+
                     "date TEXT," +
                     "sex TEXT NOT NULL," +
                     "levelstudies TEXT NOT NULL," +
                    "job TEXT NOT NULL)";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;



}
