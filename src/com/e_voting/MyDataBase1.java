package com.e_voting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase1 {

	private Context mContext;
	private DbHelper mDBHELPER;
	private SQLiteDatabase mDB;
	

	public static final String DB_Name="VOTE2";
	public static final int DB_VERSION=1;
	public static final String DB_TB_Name="VOTER2";
	public static final String SQL_CREATE_TABLE="CREATE TABLE VOTER2(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT,AGE TEXT);";
		
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
			
			
			db.execSQL("DROP TABLE IF EXIST VOTER2");
			onCreate(db);
		}
	}
	
	public MyDataBase1(Context context) {
		
		mContext=context;
	}
	
	

	public MyDataBase1 open()
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
	
	
	public void addNew(String username,String password,String age)
	{ 
			ContentValues cv=new ContentValues();
			cv.put("USERNAME", username);
			cv.put("PASSWORD",password);
			cv.put("AGE", age);
		int	val=(int) mDB.insert(DB_TB_Name, null, cv);
			/*if(val>=0)
			{
				Dialog d=new Dialog(mContext);
				d.setTitle("Message");
				TextView tv=new TextView(mContext);
				tv.setText("Data is successfully saved on database2.");
				tv.setPadding(15, 5, 5, 5);
				d.setContentView(tv);
				d.show();
			}*/
			
	}
	/*************/
	public String getData()
	{
		String col[]={"ID","USERNAME","PASSWORD","AGE"};
		Cursor c=mDB.query(DB_TB_Name, col, null, null, null, null, null);
		String res="";
		if(c!=null){
		c.moveToFirst();
			//c.moveToLast();
		while(!c.isAfterLast())
		{
			res=res+c.getString(0)+ " "+c.getString(1)+ " "+c.getString(2)+ " "+c.getString(3);
			c.moveToNext();
		}
		return res;
		}
		else
		{
			return "No Data";
		}
		
		}
	 public String getSinlgeeEntry(String name)
     {
         Cursor cursor=mDB.query("VOTER2", null, " USERNAME=?", new String[]{name}, null, null, null);
         if(cursor.getCount()<1) // UserName Not Exist
         {
             cursor.close();
             return "NOT EXIST";
         }
         cursor.moveToFirst();
         String password= cursor.getString(cursor.getColumnIndex("USERNAME"));
         cursor.close();
         return password;                
     }

}

