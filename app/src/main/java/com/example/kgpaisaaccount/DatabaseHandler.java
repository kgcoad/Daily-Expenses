package com.example.kgpaisaaccount;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private final int DATABASE_VERSION = 1;
    private final String DATABASE_NAME = "kumarpaisa";
    private final String TABLE_NAME = "money";
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "amount";
    private final String COLUMN_REASON = "reason";
    private final String COLUMN_DATE = "date";




    public DatabaseHandler(Context context)
    {
        super(context, "kumarpaisa" , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_ITEM_TABLE = " CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + "  INTEGER PRIMARY KEY, "  + COLUMN_NAME + " Text, "  + COLUMN_REASON + " Text, " + COLUMN_DATE + " Text)";

        db.execSQL(CREATE_ITEM_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertLabel(String amount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, amount);


        db.insert(TABLE_NAME, null, values);
        db.close();



    }

    public List<String> getAllLabels()
    {
        List<String> list = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM  " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
    }
}


