package com.e_voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class vote extends Activity {
	TextView t,t1,t2;
	Button b1,b2,b3,b4;
	Bjp bjp;
	MyDataBase2 myDataBase2;
	MyDataBase3 myDataBase3;
	MyDataBase4 myDataBase4;
	MainData md;
	Integer ct;
	int c=0;
	protected void onCreate(Bundle savedInstanceState) 
	{
	 super.onCreate(savedInstanceState);
     requestWindowFeature(Window.FEATURE_NO_TITLE);
     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
     setContentView(R.layout.vote);
     bjp=new Bjp(this);
     md=new MainData(this);
     myDataBase2=new MyDataBase2(this);
     myDataBase3=new MyDataBase3(this);
     myDataBase4=new MyDataBase4(this);
     t=(TextView)findViewById(R.id.textView1);
     t1=(TextView)findViewById(R.id.textView2);
     t2=(TextView)findViewById(R.id.textView3);
     b1=(Button)findViewById(R.id.button1);
     b2=(Button)findViewById(R.id.button2);
     b3=(Button)findViewById(R.id.button3);
     b4=(Button)findViewById(R.id.button4);
     /*************************************** SAVE BUTTON *******************************************/
		
     
     b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			String name=t2.getText().toString();
			//String email=editText3.getText().toString();
				bjp.open();
				bjp.addNew(name);
				bjp.close();
				Intent i=new Intent(vote.this,Congrats.class);
				startActivity(i);
				finish();
				
				
			}
		});
     b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			String name=t2.getText().toString();
			//String email=editText3.getText().toString();
				myDataBase2.open();
				myDataBase2.addNew(name);
				myDataBase2.close();
				Intent i=new Intent(vote.this,Congrats.class);
				startActivity(i);
				finish();
				
			}
		});
     b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			String name=t2.getText().toString();
			//String email=editText3.getText().toString();
				myDataBase3.open();
				myDataBase3.addNew(name);
				myDataBase3.close();
				Intent i=new Intent(vote.this,Congrats.class);
				startActivity(i);
				finish();
			}
		});
     b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			String name=t2.getText().toString();
			//String email=editText3.getText().toString();
				myDataBase4.open();
				myDataBase4.addNew(name);
				myDataBase4.close();
				
				
				Intent i=new Intent(vote.this,Congrats.class);
				startActivity(i);
				
				finish();
			}
		});
    
     
     
     
     
     
     
     
     
     
}
}
