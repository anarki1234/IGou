package com.xiter.igou.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.xiter.igou.R;

/**
 * Description:配置
 * 
 * @author liufeihua
 * @date 2014-11-17下午2:18:35
 * @version 1.0
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
