package com.e_voting;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class MyDataBase2 {

	private Context mContext;
	private DbHelper mDBHELPER;
	private SQLiteDatabase mDB;
	

	public static final String DB_Name="CONG";
	public static final int DB_VERSION=1;
	public static final String DB_TB_Name="CONG2";
	public static final String SQL_CREATE_TABLE="CREATE TABLE CONG2(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT);";
		
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
			
			
			db.execSQL("DROP TABLE IF EXIST CONG2");
			onCreate(db);
		}
	}
	
	public MyDataBase2(Context context) {
		
		mContext=context;
	}
	
	public MyDataBase2 open()
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
	
	
	public void addNew(String name)
	{ 
			ContentValues cv=new ContentValues();
			cv.put("NAME", name);
			
		int	val=(int) mDB.insert(DB_TB_Name, null, cv);
		/*	if(val>=0)
			{
				Dialog d=new Dialog(mContext);
				d.setTitle("Message");
				TextView tv=new TextView(mContext);
				tv.setText("Data is successfully saved.");
				tv.setPadding(15, 5, 5, 5);
				d.setContentView(tv);
				d.show();
			}*/
			
	}
	
	
/*******************************************  SELECT ALL FROM DATABASE *************************************************/
	
	
	public String getData()
	{
		String col[]={"ID","NAME"};
		Cursor c=mDB.query(DB_TB_Name, col, null, null, null, null, null);
		String res="";
		if(c!=null){
		c.moveToLast();
		//while(!c.isAfterLast())
		{
			res=res+c.getString(0)+ " "+c.getString(1);
			c.moveToNext();
		}
		return res;
		}
		else
		{
			return "No Data";
		}
	}
	}
