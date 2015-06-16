package com.e_voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity{
	Button b,b1,b2,b3,b6;
	Bjp bjp;
	MyDataBase2 myDataBase2;
	MyDataBase3 myDataBase3;
	MyDataBase4 myDataBase4;
	TextView t,t1,t2,t3;
	//int x,y,z;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.result);
		bjp=new Bjp(this);
		myDataBase2=new MyDataBase2(this);
		myDataBase3=new MyDataBase3(this);
		myDataBase4=new MyDataBase4(this);
		b=(Button)findViewById(R.id.button1);
		b1=(Button)findViewById(R.id.button2);
		b2=(Button)findViewById(R.id.button3);
		b3=(Button)findViewById(R.id.button4);
		b6=(Button)findViewById(R.id.button6);
		
		t=(TextView)findViewById(R.id.textView2);
		t1=(TextView)findViewById(R.id.textView3);
		t2=(TextView)findViewById(R.id.textView4);
		t3=(TextView)findViewById(R.id.textView5);
		 b.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					bjp.open();
					//Toast.makeText(getBaseContext(),bjp.getData(), Toast.LENGTH_LONG).show();
					t.setText(bjp.getData());
					bjp.close();
				}	
			});
		 b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					myDataBase2.open();
				//	Toast.makeText(getBaseContext(),myDataBase2.getData(), Toast.LENGTH_LONG).show();
					t1.setText(myDataBase2.getData());
					myDataBase2.close();
				}	
			});
		 b2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					myDataBase3.open();
				//	Toast.makeText(getBaseContext(),myDataBase3.getData(), Toast.LENGTH_LONG).show();
					t2.setText(myDataBase3.getData());
					myDataBase3.close();
				}	
			});
		 b3.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					myDataBase4.open();
					//Toast.makeText(getBaseContext(),myDataBase4.getData(), Toast.LENGTH_LONG).show();
					t3.setText(myDataBase4.getData());
					myDataBase4.close();
				}	
			});
		 b6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Result.this,Admin.class);
				startActivity(i);
				
			}
		});
		
}
}
