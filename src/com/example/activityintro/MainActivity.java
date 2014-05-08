package com.example.activityintro;

import com.example.activityintro.fragment.MyFragment1;
import com.example.activityintro.fragment.PlaceholderFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private static final int REQUEST_CODE_ACT1 = 1;
	private static final int REQUEST_CODE_ACT2 = 2;
	private static final int REQUEST_CODE_ACT3 = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
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
	
	public void goToActivity(View view) {
		Intent intent = new Intent();
		
		switch (view.getId()) {
		case R.id.button1:
			intent.setClass(this, Activity1.class);
			intent.putExtra("message", "hi act1");
			startActivityForResult(intent, REQUEST_CODE_ACT1);
			break;
			
		case R.id.button2:
			intent.setClass(this, Activity2.class);
			intent.putExtra("message", "hi act2");
			startActivityForResult(intent, REQUEST_CODE_ACT2);
			break;
			
		case R.id.button3:
			intent.setClass(this, Activity3.class);
			intent.putExtra("message", "hi act3");
			startActivityForResult(intent, REQUEST_CODE_ACT3);
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, intent);
		Log.d("debug", "requestCode=" + requestCode + ", resultCode=" + resultCode);
		if (intent != null) 
			Log.d("debug", "intent (who) = " + intent.getStringExtra("who"));
		
		switch (requestCode) {
		case REQUEST_CODE_ACT1:
			Toast.makeText(this, "Activity1 back", Toast.LENGTH_SHORT).show();
			break;
			
		case REQUEST_CODE_ACT2:
			Toast.makeText(this, "Activity2 back", Toast.LENGTH_SHORT).show();
			break;
			
		case REQUEST_CODE_ACT3:
			Toast.makeText(this, "Activity3 back", Toast.LENGTH_SHORT).show();
			break;
		}
	}
	
	public void replaceFragment(View view) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		
		switch (view.getId()) {
		case R.id.PlaceholderFragmentBtn:
			transaction.replace(R.id.container, new MyFragment1());
			break;
		case R.id.Fragment1Btn:
			transaction.replace(R.id.container, new PlaceholderFragment());
			break;
		}
		
		transaction.commit();
	}

}
