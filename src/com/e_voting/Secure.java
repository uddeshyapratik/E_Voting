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

public class Secure extends Activity{
	EditText e;
	Button b,b1,b2;
	TextView t,t1;
	String UserName;
	MyDataBase myDataBase;
	MyDataBase1 myDataBase1;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
         requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	     setContentView(R.layout.secure);
	     myDataBase=new MyDataBase(this);
	     myDataBase1=new MyDataBase1(this);
	     b=(Button)findViewById(R.id.button1);
	     b1=(Button)findViewById(R.id.button2);
	     b2=(Button)findViewById(R.id.button3);
	     t=(TextView)findViewById(R.id.textView1);
	     t1=(TextView)findViewById(R.id.textView2);
	     e=(EditText)findViewById(R.id.editText1);
	    
	 
	   b.setOnClickListener(new View.OnClickListener() {
      	 
           public void onClick(View v) {
           	myDataBase.open();
               // get The User name and Password
               String name=e.getText().toString();
             

               // fetch the Password form database for respective user name
               String storedPassword=myDataBase.getSinlgeeEntry(name);

               // check if the Stored password matches with  Password entered by user
               if(name.equals(storedPassword))
               {
                   Toast.makeText(Secure.this, "YOU ARE AUTHORIZED TO VOTE ONLY ONCE!!!", Toast.LENGTH_LONG).show();
                   myDataBase.deleteEntry(name);
   				
   				
               Intent i=new Intent(Secure.this,vote.class);
               startActivity(i);
               }
               else
               {
                   Toast.makeText(Secure.this, "User Name does not match", Toast.LENGTH_LONG).show();
               }
               myDataBase.close();
           }
           
       });
	
	   
		
}
	    
	     
	}

