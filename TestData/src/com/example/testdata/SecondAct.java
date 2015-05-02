package com.example.testdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondAct extends Activity{
	
	Button bedit;
	TextView tv;
	String st;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondact);
		
		bedit=(Button) findViewById(R.id.bedit);
		tv=(TextView) findViewById(R.id.textView1);
		
		st=getIntent().getExtras().getString("DATA").toString();
		tv.setText(st);
		
		bedit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent ri = new Intent();
				// TODO Add extras or a data URI to this intent as appropriate.
				ri.putExtra("BACKDATA",st );
				setResult(Activity.RESULT_OK, ri);
				finish();
				
			}
		});
	}

}
