package com.e_voting;



import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

public class MainData {

	private Context mContext;
	private DbHelper mDBHELPER;
	private SQLiteDatabase mDB;
	

	public static final String DB_Name="PARTY";
	public static final int DB_VERSION=1;
	public static final String DB_TB_Name="PARTY1";
	public static final String SQL_CREATE_TABLE="CREATE TABLE PARTY1(ID INTEGER PRIMARY KEY AUTOINCREMENT, PNAME TEXT,VOTE INTEGER );";
		
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
			
			
			db.execSQL("DROP TABLE IF EXIST EMP1");
			onCreate(db);
		}
	}
	
	public MainData(Context context) {
		
		mContext=context;
	}
	
	public MainData open()
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
	
	
	public void addNew(String pname,int vote)
	{ 
			ContentValues cv=new ContentValues();
			cv.put("PNAME", pname);
			
			cv.put("VOTE", vote);
		int	val=(int) mDB.insert(DB_TB_Name, null, cv);
			if(val>=0)
			{
				Dialog d=new Dialog(mContext);
				d.setTitle("Message");
				TextView tv=new TextView(mContext);
				tv.setText("You are Registered.");
				tv.setPadding(15, 5, 5, 5);
				d.setContentView(tv);
				d.show();
			}
			
	}
	
	
/*******************************************  SELECT ALL FROM DATABASE *************************************************/
	
	
	public String getdata(int a)
	{
		String col[]={"ID","PNAME","VOTE"};
		Cursor c=mDB.query(DB_TB_Name, col, "ID="+a, null, null, null, null);
		String res="";
		if(c!=null){
	c.moveToFirst();
	
		
		while(!c.isAfterLast())
		{
		
			res=res+c.getString(2);
			c.moveToNext();
		}
		return res;
		}
		else
	{
			
		return "No Data";
		}
	}

	
	public String getpass(int a) {
		String col[]={"ID","VOTE"};
		Cursor c=mDB.query(DB_TB_Name, col, "ID="+a, null, null, null, null);
		String res="";
		if(c!=null){
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			res=res+c.getString(1);
			c.moveToNext();
		}
		return res;
		}
		else
		{
			return "No Data";
		
	}
}
	public String geten(int a) {
		String col[]={"ID","PASS","EN"};
		Cursor c=mDB.query(DB_TB_Name, col, "ID="+a, null, null, null, null);
		String res="";
		if(c!=null){
		c.moveToFirst();
		while(!c.isAfterLast())
		{
			res=res+c.getString(2);
			c.moveToNext();
		}
		return res;
		}
		else
		{
			return "No Data";
		
	}
	}




/*************************************** UPDATE TABLE USING PRIMARY KEY *****************************************************/
	
	
	public void updateData( int a, int vote) {
		
		try{
		ContentValues cv= new ContentValues();
		
		cv.put("VOTE", vote);
		
				
		int val=mDB.update("PARTY1", cv, "ID="+a, null);
				
		if(val>=0)
		{
			Dialog d=new Dialog(mContext);
			d.setTitle("Message");
			TextView tv=new TextView(mContext);
			tv.setText("voting is success.");
			tv.setPadding(15, 5, 5, 5);
			d.setContentView(tv);
			d.show();
		}
		}
		catch(Exception e)
		{
			Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}


}



