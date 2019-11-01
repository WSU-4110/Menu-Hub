package com.example.menu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AppCompatActivity {
	void onCreate(Bundle savedInstanceState){
	
	}

	public boolean onCreateOptionsMenu(Menu menu){
		return true;
	}

	public boolean onOptionsItemSelected( MenuItem item) {
		return true;
	}

}

public class menuBuilder extends AppCompatActivity {

	@Override
    	protected void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.activity_main);
    	}

    	//inflating the menu option ot the main activity
    	@Override
    	public boolean onCreateOptionsMenu(Menu menu) {
       		getMenuInflater().inflate(R.menu.menu, menu);
        	return super.onCreateOptionsMenu(menu);
   	}

    	//open activity from menu click
    	@Override
    	public boolean onOptionsItemSelected(MenuItem item) {
        	int id = item.getItemId();
        	//add homeClass
        	if (id == R.id.home) {
            		Intent intent = new Intent(MainActivity.this, homeClass.class);
            		this.startActivity(intent);
            		return true;
        	}
        //add searchClass
        	if (id == R.id.search) {
            		Intent intent = new Intent(MainActivity.this, searchClass.class);
            		this.startActivity(intent);
            		return true;
        	}
        // add settingActivityClass
        	if (id == R.id.setting) {
            		Intent intent = new Intent(MainActivity.this, settingActivity.class);
            		this.startActivity(intent);
           		return true;
        	}
        	//add uploadClass
        	if (id == R.id.upload) {
            		Intent intent = new Intent(MainActivity.this, uploadClass.class);
            		this.startActivity(intent);
            		return true;
        	}
        return super.onOptionsItemSelected(item);
    }
}

public class constructMenuActivity {
	Bundle savedInstanceState;
	Menu menu;
	MenuItem item;
	
	public AppCompatActivity menuConstruct ( menuBuilder construct){
		construct.onCreate(savedInstanceState);
		construct.onCreateOptionsMenu(menu)
		construct.onOptionsItemSelected(item)	
	}
}













