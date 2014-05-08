package com.example.activityintro;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Activity3 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String message = getIntent().getStringExtra("message");
		Log.d("debug", "onCreate, message=" + message);
	}
}
