package com.example.root.heart_tarang.blesample.operation;//package com.example.root.ecgble.blesample.operation;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//
//import java.util.ArrayList;
//
//public class PhoneBookHandler  {
//    private DatabaseHandler dbHelper;
//    public static ArrayList<String> test = new ArrayList<String>();
//
//    public PhoneBookHandler(Context context) {
//
//        dbHelper = new DatabaseHandler(context);
//
//    }
//    void addContact(PhoneBook phoneBook) {
//        Log.i("inserted", "inserted");
//        SQLiteDatabase db = dbHelper.getWritableDatabase(); //3
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHandler.TIME_INTERVAL, phoneBook.getTimeinterval());
//        values.put(DatabaseHandler.VOLTAGE1, phoneBook.getVoltage1());
//        values.put(DatabaseHandler.VOLTAGE2, phoneBook.getVoltage2());
//        values.put(DatabaseHandler.VOLTAGE3, phoneBook.getVoltage3());
//        values.put(DatabaseHandler.VOLTAGE4, phoneBook.getVoltage4());
//        values.put(DatabaseHandler.VOLTAGE5, phoneBook.getVoltage5());
//        values.put(DatabaseHandler.VOLTAGE6, phoneBook.getVoltage6());
//        values.put(DatabaseHandler.VOLTAGE7, phoneBook.getVoltage7());
//        values.put(DatabaseHandler.VOLTAGE8, phoneBook.getVoltage8());
//        values.put(DatabaseHandler.VOLTAGE9, phoneBook.getVoltage9());
//        values.put(DatabaseHandler.VOLTAGE10, phoneBook.getVoltage10());
//        values.put(DatabaseHandler.VOLTAGE11, phoneBook.getVoltage11());
//        values.put(DatabaseHandler.VOLTAGE12, phoneBook.getVoltage12());
//
//
//        Log.i("inserted", "inserted" + phoneBook.getVoltage());
//        db.insert(DatabaseHandler.TABLE_values, null, values);
//
//        Log.d("insertion performed","insertion performed");
//        db.close();
//    }
//
//    PhoneBook getContact(String name) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();//readableDatatbase();
//
//        Cursor cursor = db.query(DatabaseHandler.TABLE_values,
//                new String[]{DatabaseHandler.TIME_INTERVAL, DatabaseHandler.VOLTAGE1,DatabaseHandler.VOLTAGE2,DatabaseHandler.VOLTAGE3
//                        ,DatabaseHandler.VOLTAGE4, DatabaseHandler.VOLTAGE5,DatabaseHandler.VOLTAGE6,DatabaseHandler.VOLTAGE7
//                        ,DatabaseHandler.VOLTAGE8, DatabaseHandler.VOLTAGE9,DatabaseHandler.VOLTAGE10,DatabaseHandler.VOLTAGE11
//                        ,DatabaseHandler.VOLTAGE12
//                },
//                DatabaseHandler.TIME_INTERVAL + "=?", new String[]{String.valueOf(name)}, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        PhoneBook phoneBook = new PhoneBook(cursor.getString(0), cursor.getString(1)
//        );
//
//        return phoneBook;
//    }
//
//    public ArrayList<PhoneBook> getAllContacts() {
//        //test.clear();
//        //test.add(0, null)
//        Log.d("Checking","Inside121212");
//
//        ArrayList<PhoneBook> p = new ArrayList<PhoneBook>();
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        String selectQuery = "SELECT  * FROM " + DatabaseHandler.TABLE_values;
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Log.i("value", "value" + cursor.getString(1));
//                Log.i("value", "value" + cursor.getString(2));
//                Log.i("value", "value" + cursor.getString(0));
//                PhoneBook phoneBook = new PhoneBook(cursor.getString(0), cursor.getString(1));
//                phoneBook.setTimeinterval(cursor.getString(0));
//                phoneBook.setVoltage(cursor.getString(1));
////                phoneBook.setVoltage1((cursor.getString(2)));
//
//
//                Log.i("test", "msg");
//                test.add(cursor.getString(1));
//                p.add(phoneBook);
//            } while (cursor.moveToNext());
//        }
//        return p;
//    }
//
//
//    public void deleteContact(PhoneBook phoneBook) {
//        Log.i("aaaaaaaaaaaaaaaaaa", "id"+phoneBook.getTimeinterval());
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.delete(dbHelper.TABLE_values, dbHelper.TIME_INTERVAL + " = ?",
//                new String[] { String.valueOf(phoneBook.getTimeinterval()) });
//        db.close();
//    }
//
//
//    public int updateContact(PhoneBook phoneBook) {
//
//        Log.i("id", "id"+phoneBook.getTimeinterval()+phoneBook.getVoltage1()+phoneBook.getVoltage1());
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHandler.TIME_INTERVAL, phoneBook.getTimeinterval());
//        values.put(DatabaseHandler.VOLTAGE, phoneBook.getVoltage());
////        values.put(DatabaseHandler.VOLTAGE_1, phoneBook.getVoltage1());
//
//
//        Log.i("check", "check"+phoneBook.getTimeinterval());
//        return db.update(dbHelper.TABLE_values, values,dbHelper.TIME_INTERVAL +"=?",
//                new String[]{ String.valueOf(phoneBook.getTimeinterval())});
//    }
//}