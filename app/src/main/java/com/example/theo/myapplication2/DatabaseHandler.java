package com.example.theo.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Gradi";
    private static final String TABLE_CHILDREN = "copil";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nume";
    private static final String KEY_Date_B = "data_nasterii";
    public static final String KEY_TYPE = "sex";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHILDREN_TABLE = "CREATE TABLE " + TABLE_CHILDREN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_Date_B + " TEXT," + KEY_TYPE + " TEXT"+")";
        db.execSQL(CREATE_CHILDREN_TABLE);
    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHILDREN);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new child
    void addChild(Child child) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, child.getName());
        values.put(KEY_Date_B, child.getDateOfBirth());
        values.put(KEY_TYPE, child.getType());
        db.insert(TABLE_CHILDREN, null, values);
        db.close();
    }

    // Getting single child
    Child getChild(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CHILDREN, new String[] { KEY_ID, KEY_NAME, KEY_Date_B,KEY_TYPE}, KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            return new Child(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3));
        }
        return null;
    }

    // Getting All Children
    public List<Child> getAllChildren() {
        List<Child> childrenList = new ArrayList<Child>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CHILDREN;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Child child = new Child();
                child.setID(Integer.parseInt(cursor.getString(0)));
                child.setName(cursor.getString(1));
                child.setDateOfBirth(cursor.getString(2));
                child.setType(cursor.getString(3));
                childrenList.add(child);
            } while (cursor.moveToNext());
        }
        return childrenList;
    }

    // Updating single child
    public int updateChild(Child child) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, child.getName());
        values.put(KEY_Date_B, child.getDateOfBirth());
        values.put(KEY_TYPE, child.getType());
        return db.update(TABLE_CHILDREN, values, KEY_ID + " = ?", new String[] { String.valueOf(child.getID()) });
    }

    // Deleting single child
    public void deleteChild(Child child) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CHILDREN, KEY_ID + " = ?", new String[] { String.valueOf(child.getID()) });
        db.close();
    }

    // Getting children Count
    public int getChildrenCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CHILDREN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

}