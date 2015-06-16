package com.e_voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Menu extends Activity {
	Button b,b1,b2,b3;
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	     setContentView(R.layout.menu);
	     b=(Button)findViewById(R.id.button1);
	     b1=(Button)findViewById(R.id.button2);
	     b2=(Button)findViewById(R.id.button3);
	     b3=(Button)findViewById(R.id.button4);
	     
	     
	     b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(Menu.this,Secure.class);
				startActivity(i);
				// TODO Auto-generated method stub
				
			}
		});
	     b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Menu.this,Contact.class);
				startActivity(i);
				
			}
		});
	     b3.setOnClickListener(new View.OnClickListener() {
				
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Menu.this,MainActivity.class);
				startActivity(i);
				
			}
		});
	     b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(Menu.this,Details.class);
					startActivity(i);
					
				}
			});
	     
//finish();
}}
