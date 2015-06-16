package com.e_voting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Lists extends Activity {
	Admindata admindata;
	EditText e1,e2;
	Button b;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.lists);

        admindata=new Admindata(this);
        
        e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		
		
/*************************************** SAVE BUTTON *******************************************/
		
         b=(Button)findViewById(R.id.button1);
         b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name=e1.getText().toString();
				String voterid=e2.getText().toString();
					admindata.open();
					admindata.addNew(name,voterid);
					admindata.close();

				
			}
		});
       
	}
	}

