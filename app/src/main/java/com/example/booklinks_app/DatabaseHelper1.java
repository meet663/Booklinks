package com.example.booklinks_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper1 extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "test.db";
    public static final String TABLE_NAME = "book_data_table";
    private SQLiteDatabase db;

    public static final String COL_2 = "RANDOM_NUMBER";
    public static final String COL_3 = "BOOK_NAME";
    public static final String COL_4 = "AUTHOR_NAME";
    public static final String COL_5 = "PUBLISHER_NAME";
    public static final String COL_6 = "PUBLISHER_YEAR";
    public static final String COL_7 = "BOOK_QUALITY";

    public DatabaseHelper1(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY,RANDOM_NUMBER INTEGER PRIMARY KEY,BOOK_NAME TEXT,AUTHOR_NAME TEXT,PUBLISHER_NAME TEXT,PUBLISHER_YEAR INTEGER,BOOK_QUALITY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_data(String r, String book_name, String author_name, String publish_name, String publish_year, String spinner_value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, r);
        contentValues.put(COL_3, book_name);
        contentValues.put(COL_4, author_name);
        contentValues.put(COL_5, publish_name);
        contentValues.put(COL_6, publish_year);
        contentValues.put(COL_7, spinner_value);

        //insert the data into table
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;

    }
}
