package com.example.testdata;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	private static final String MyPREFERENCE = "mypref";
	protected static final String ET = "et";
	Button bsave;
	//String data;
	EditText et;
	Button bn;
	TextView tv;
	
	SharedPreferences sp;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bsave=(Button) findViewById(R.id.bsave);
        et=(EditText) findViewById(R.id.editText1);
        bn=(Button) findViewById(R.id.button1);
        tv=(TextView) findViewById(R.id.textView1);
        
        sp=getSharedPreferences(MyPREFERENCE,MODE_PRIVATE);
        final DbHelper db=new DbHelper(this);
        
        if (sp.contains(ET))
        {
          
        et.setText(sp.getString(ET, ""));
        
        }
        
        
        bsave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String data=et.getText().toString();
				
		        Editor et=sp.edit();
		        et.putString(ET,data );
		        et.commit();
		        
		        db.filldb(data);
		        
				Intent in=new Intent(MainActivity.this,SecondAct.class);
				in.putExtra("DATA", data);
				//Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
				startActivityForResult(in, 0);
				 
				
				
			}
		});
        
        bn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String st=db.getdata();
				tv.setText(st);
				
			}
		});
    }
   @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(arg0, arg1, arg2);
    	if (arg1 == Activity.RESULT_OK) {
            // TODO Extract the data returned from the child Activity.
    		String st=arg2.getExtras().getString("BACKDATA").toString();
    		et.setText(st);
          }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
