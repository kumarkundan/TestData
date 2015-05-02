package com.example.testdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
	
	

	private static final String DB_NAME ="MYdb";
	private static final int VERSION = 1;
	

	public DbHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(
			      "create table contacts " +
			      "(id integer primary key, name text)"
			      );
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void filldb(String data) {
		// TODO Auto-generated method stub
		
		SQLiteDatabase sdb=this.getReadableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("name", data);
        sdb.insert("contacts", null, cv);
        sdb.close();
		
	}
	public String getdata() {
		// TODO Auto-generated method stub
		SQLiteDatabase sdb=this.getReadableDatabase();
		String[] columns=new String[]{"name"};
		Cursor cursor=sdb.query("contacts", columns, null, null, null, null, null);
		
		cursor.moveToFirst();
		
			return(cursor.getString(cursor.getColumnIndex("name")));
		           
	}

}
