package com.example.enterfiance.model;

import android.provider.BaseColumns;

public class UserContract {
    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "User";
        public static final String FULLNAME = "fullname";
        public static final String USERNAME = "username";
        public static final String DATE = "date";
        public static final String PHONENUMBER = "phonenumber";
        public static final String SEX = "sex";
        public static final String LEVELSTUDIES = "levelstudies";
        public static final String JOB = "job";
    }
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                    UserEntry._ID + " INTEGER PRIMARY KEY," +
                    UserEntry.FULLNAME + " TEXT," +
                    UserEntry.USERNAME + " TEXT," +
                    UserEntry.DATE + " TEXT," +
                    UserEntry.SEX + " TEXT," +
                    UserEntry.LEVELSTUDIES + " TEXT," +
                    UserEntry.JOB + " TEXT)";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;



}
