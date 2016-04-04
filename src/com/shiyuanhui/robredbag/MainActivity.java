package com.shiyuanhui.robredbag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button zhuce;
	private Button exitrob;
	private Intent accessibleIntent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		zhuce = (Button)findViewById(R.id.zhuce);
		exitrob = (Button)findViewById(R.id.exitrob);
		zhuce.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(accessibleIntent);
			}
		});
		exitrob.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(accessibleIntent);
			}
		});
	}

}
