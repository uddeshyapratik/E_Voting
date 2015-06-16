package com.e_voting;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	
		Button btnSignIn,btnSignUp,b,b1;
		MyDataBase myDataBase;

		@Override
		protected void onCreate(Bundle savedInstanceState) 
		{
		     super.onCreate(savedInstanceState);
		     requestWindowFeature(Window.FEATURE_NO_TITLE);
	         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		     setContentView(R.layout.activity_main);
             b=(Button)findViewById(R.id.button2);
             b1=(Button)findViewById(R.id.button1);
             b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(MainActivity.this,Admin.class);
					startActivity(i);
				}
			});
             b.setOnClickListener(new View.OnClickListener() {
 				
 				@Override
 				public void onClick(View arg0) {
 					// TODO Auto-generated method stub
 					Intent i=new Intent(Intent.ACTION_MAIN);
 	 				i.addCategory(Intent.CATEGORY_HOME);
 	 				startActivity(i);
 					
 				}
 			});
		     // create a instance of SQLite Database
		     myDataBase=new MyDataBase(this);
		     myDataBase=myDataBase.open();

		     // Get The Refference Of Buttons
		     btnSignIn=(Button)findViewById(R.id.buttonSignIN);
		     btnSignUp=(Button)findViewById(R.id.buttonSignUP);

		    // Set OnClick Listener on SignUp button 
		    btnSignUp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/// Create Intent for SignUpActivity  abd Start The Activity
				Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
				startActivity(intentSignUP);
				}
			});
		    
		}
		// Methos to handleClick Event of Sign In Button
		public void signIn(View V)
		   {
				final Dialog dialog = new Dialog(MainActivity.this);
				dialog.setContentView(R.layout.login);
			    dialog.setTitle("Login");

			    // get the Refferences of views
			    final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
			    final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

				Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

				// Set On ClickListener
				btnSignIn.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// get The User name and Password
						String username=editTextUserName.getText().toString();
						String password=editTextPassword.getText().toString();

						// fetch the Password form database for respective user name
						String storedPassword=myDataBase.getSinlgeEntry(username);

						// check if the Stored password matches with  Password entered by user
						if(password.equals(storedPassword))
						{
							Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
							
							dialog.dismiss();
							//Intent i=new Intent(MainActivity.this,Menu.class);
							//startActivity(i);
							Intent i=new Intent(getApplicationContext(),Menu.class);
	                        startActivity(i);
						}
						else
						{
							Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
						}
					}
				});

				dialog.show();
		}
		

		@Override
		protected void onDestroy() {
			super.onDestroy();
		    // Close The Database
			myDataBase.close();
		}
		
	}

		
