package com.e_voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin extends Activity{

	EditText e,e1;
    Button b,b1;
    TextView t,t1;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
	         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.admin);
			e=(EditText)findViewById(R.id.editText1);
			e1=(EditText)findViewById(R.id.editText2);
			b=(Button)findViewById(R.id.button1);
			b1=(Button)findViewById(R.id.button2);
			t=(TextView)findViewById(R.id.textView1);
			t1=(TextView)findViewById(R.id.textView2);
			b.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
				String s1=e.getText().toString();
				String s2=e1.getText().toString();
				if((s1.equals("admin"))&&(s2.equals("admin")))
				{
					Toast.makeText(getBaseContext(), "Successfully Login",Toast.LENGTH_SHORT).show();
					Intent i=new Intent(Admin.this,Enroll.class);
					startActivity(i);
				}
				else
				{
					Toast.makeText(getBaseContext(), "Username or password not match",Toast.LENGTH_SHORT).show();
				}
					
					
					
					
				}
			});
			b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent i=new Intent(Admin.this,MainActivity.class);
					startActivity(i);
					// TODO Auto-generated method stub
					
				}
			});
		}
}
		
	

