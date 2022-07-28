package com.example.booklinks_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "test.db";

    public static final String TABLE_NAME = "testing";
    public static final String TABLE_NAME2 = "book_data";


    public static final String COL_2 = "NAME";
    public static final String COL_3 = "LAST_NAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "USERNAME";

    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "PHONE";
    public static final String COL_8 = "GENDER";

    public static final String B_2 = "RANDOM_NUMBER";
    public static final String B_3 = "BOOK_NAME";
    public static final String B_4 = "AUTHOR_NAME";
    public static final String B_5 = "PUBLISHER_NAME";
    public static final String B_6 = "PUBLISHER_YEAR";
    public static final String B_7 = "BOOK_QUALITY";



    private Context context;
    private SQLiteDatabase database;

    public static final String CREATE_BOOK_TABLE = "create table "+ TABLE_NAME2 + "(RANDOM_NUMBER INTEGER PRIMARY KEY,BOOK_NAME TEXT,AUTHOR_NAME TEXT,PUBLISHER_NAME TEXT,PUBLISHER_YEAR INTEGER,BOOK_QUALITY TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(" create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY,NAME TEXT,LAST_NAME TEXT,EMAIL TEXT,USERNAME TEXT,PASSWORD TEXT,PHONE NUMBER,GENDER TEXT)");
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        onCreate(db);

    }


    public boolean insertData(String f1, String l1, String e, String un, String m) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, f1);
        contentValues.put(COL_3, l1);
        contentValues.put(COL_4, e);
        contentValues.put(COL_5, un);
        contentValues.put(COL_8, m);

        //insert the data into table
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;

    }


    public boolean insertData2(String un, String pass, String p)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_6, pass);
        contentValues.put(COL_7, p);


        //update the table data by the username
        long result = db.update(TABLE_NAME, contentValues, "USERNAME=?", new String[]{un});
        return result != -1;
    }


    public boolean insert_data_into_book_table(String r, String book_name, String author_name, String publish_name, String publish_year, String spinner_value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(B_2,r);
        contentValues.put(B_3,book_name);
        contentValues.put(B_4,author_name);
        contentValues.put(B_5,publish_name);
        contentValues.put(B_6,publish_year);
        contentValues.put(B_7,spinner_value);

        //insert the data into table
        long result = db.insert(TABLE_NAME2, null, contentValues);
        return result != -1;

    }
}