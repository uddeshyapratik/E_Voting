package com.e_voting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPActivity extends Activity {

	 EditText editTextUserName,editTextPassword,editTextConfirmPassword,e;
	    Button btnCreateAccount;
	 
	    MyDataBase myDataBase;
	    MyDataBase1 myDataBase1;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	        setContentView(R.layout.signup);

	        // get Instance  of Database Adapter
	        myDataBase=new MyDataBase(this);
	        myDataBase1=new MyDataBase1(this);
	        myDataBase=myDataBase.open();
	        myDataBase1=myDataBase1.open();
	 
	        // Get Refferences of Views
	        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
	        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
	        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
	        e=(EditText)findViewById(R.id.editTextAge);
	        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
	    
	        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
	            // TODO Auto-generated method stub
	        	myDataBase1.open();
	        	 String name=editTextUserName.getText().toString();
	        	 String storedPassword=myDataBase1.getSinlgeeEntry(name);
	        	 if(name.equals(storedPassword))
	             {
	                 Toast.makeText(SignUPActivity.this, "YOU  VOTED ALREADY!!!", Toast.LENGTH_LONG).show();
	                 //myDataBase.deleteEntry(name);
	  				
	  				//Toast.makeText(getApplicationContext(),"data deleteed",Toast.LENGTH_LONG).show();
	             Intent i=new Intent(SignUPActivity.this,MainActivity.class);
	             startActivity(i);
	             }
	        	
	        	 else{
	            String username=editTextUserName.getText().toString();
	            String password=editTextPassword.getText().toString();
	            String confirmPassword=editTextConfirmPassword.getText().toString();
	            
	            String age=e.getText().toString();
	            //int s=Integer.parseInt(age);
	            // check if any of the fields are vaccant
	            if(username.equals("")||password.equals("")||confirmPassword.equals("")||age.equals(""))
	            {
	                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
	                    return;
	            }
	            // check if both password matches
	            if(!password.equals(confirmPassword))
	            {
	                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
	                return;
	            }
	            int s=Integer.parseInt(age);
	            if(s<18)
	            {
	            	 Toast.makeText(getApplicationContext(), "Age must be equal or greater than 18 ", Toast.LENGTH_LONG).show();
	            }
	           else
	            {
	                // Save the Data in Database
	                myDataBase.addNew(username, password,age);
	                myDataBase1.addNew(username,password,age);
	                Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
	               Intent i=new Intent(SignUPActivity.this,MainActivity.class);
	               startActivity(i);
	            }
	           
	        }myDataBase1.close();
	        }
	    });
	}
	    @Override
	    protected void onDestroy() {
	        // TODO Auto-generated method stub
	        super.onDestroy();
	        myDataBase1.close();
	        myDataBase.close();
	        
	    }
	}

/*****************/

  