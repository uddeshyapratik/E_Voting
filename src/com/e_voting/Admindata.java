package com.e_voting;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class Admindata {
	private Context mContext;
	private DbHelper mDBHELPER;
	private SQLiteDatabase mDB;
	

	public static final String DB_Name="ADMIN";
	public static final int DB_VERSION=1;
	public static final String DB_TB_Name="ENROLL";
	public static final String SQL_CREATE_TABLE="CREATE TABLE ENROLL(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, VOTERID TEXT);";
		
	private static final class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DB_Name, null, DB_VERSION);
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SQL_CREATE_TABLE);		
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			
			db.execSQL("DROP TABLE IF EXIST ENROLL");
			onCreate(db);
		}
	}
	
	public Admindata(Context context) {
		
		mContext=context;
	}
	
	

	public Admindata open()
	{
		mDBHELPER=new DbHelper(mContext);
		mDB=mDBHELPER.getWritableDatabase();
		return this;
	}
	
	public void close()
	{
		mDBHELPER.close();
	}
	

/******************************* INSERT DATA INTO DATABASE ********************************************/	
	
	
	public void addNew(String username,String voterid)
	{ 
			ContentValues cv=new ContentValues();
			cv.put("USERNAME", username);
			cv.put("VOTERID",voterid);
			
		int	val=(int) mDB.insert(DB_TB_Name, null, cv);
			if(val>=0)
			{
				Dialog d=new Dialog(mContext);
				d.setTitle("Message");
				TextView tv=new TextView(mContext);
				tv.setText("Data is successfully saved.");
				tv.setPadding(15, 5, 5, 5);
				d.setContentView(tv);
				d.show();
			}
	}}


