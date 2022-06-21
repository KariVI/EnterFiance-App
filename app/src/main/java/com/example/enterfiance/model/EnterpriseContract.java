package com.example.enterfiance.model;

import android.provider.BaseColumns;

public class EnterpriseContract {
    public static class EnterpriseEntry implements BaseColumns {
        public static final String TABLE_NAME = "Enterprise";
        public static final String NAME = "name";
        public static final String BUSINESSLINE = "businessLine";
        public static final String ACTIVETIME = "activeTime";
        public static final String TYPE = "type";
        public static final String TYPEOWNER = "typeOwner";
        public static final String OWNER = "owner";

    }
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EnterpriseContract.EnterpriseEntry.TABLE_NAME + " (" +
                    EnterpriseContract.EnterpriseEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
                    EnterpriseEntry.NAME + " TEXT," +
                    EnterpriseEntry.BUSINESSLINE + " TEXT," +
                    EnterpriseEntry.ACTIVETIME + " integer," +
                    EnterpriseEntry.TYPE + " TEXT," +
                    EnterpriseEntry.TYPEOWNER +  " TEXT" +
                    EnterpriseEntry.OWNER+ " integer,"
                    + " FOREIGN KEY ("+EnterpriseEntry.OWNER+") REFERENCES "+"User"+"("+UserContract.UserEntry._ID+"));";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EnterpriseContract.EnterpriseEntry.TABLE_NAME;
}
