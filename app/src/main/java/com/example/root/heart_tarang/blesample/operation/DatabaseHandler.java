package com.example.root.heart_tarang.blesample.operation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ecgbluetoothmanager.db";


    public static final String TABLE_values = "lead";

    //    public static Integer KEY_SERIAL_NO = 0;
    public static final String TIME_INTERVAL = "timeinterval";
    public static final String VOLTAGE1 = "voltage1";
    public static final String VOLTAGE2 = "voltage2";
    public static final String VOLTAGE3 = "voltage3";
    public static final String VOLTAGE4 = "voltage4";
    public static final String VOLTAGE5 = "voltage5";
    public static final String VOLTAGE6 = "voltage6";
    public static final String VOLTAGE7 = "voltage7";
    public static final String VOLTAGE8 = "voltage8";
    public static final String VOLTAGE9 = "voltage9";
    public static final String VOLTAGE10= "voltage10";
    public static final String VOLTAGE11= "voltage11";
    public static final String VOLTAGE12= "voltage12";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_values + "("
                + TIME_INTERVAL + " TEXT," +VOLTAGE1 + " TEXT,"+VOLTAGE2 + " TEXT,"+VOLTAGE3 + " TEXT,"+VOLTAGE4 +
                " TEXT,"+VOLTAGE5 + " TEXT,"+VOLTAGE6 + " TEXT,"+VOLTAGE7 + " TEXT,"+VOLTAGE8 + " TEXT,"
                +VOLTAGE9 + " TEXT,"+VOLTAGE10 + " TEXT,"+VOLTAGE11 + " TEXT,"+ VOLTAGE12 + " TEXT"
                + " )";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_values);
        onCreate(db);
    }
}





