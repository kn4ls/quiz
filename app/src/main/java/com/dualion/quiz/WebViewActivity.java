package com.dualion.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.Menu;
import android.view.MenuItem;
import com.squareup.picasso.Picasso;

public class WebViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		try {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		} catch (NullPointerException e){ }

		setTitle( getResources().getString(R.string.question));

		if( savedInstanceState == null ) {
			String urlData = getIntent().getDataString();

			TouchImageView imageUrl = (TouchImageView) findViewById(R.id.image_url);
			Picasso.with(this).load(urlData).into(imageUrl);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			// Respond to the action bar's Up/Home button
			case android.R.id.home:
				Intent upIntent = NavUtils.getParentActivityIntent(this);
				if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
					// This activity is NOT part of this app's task, so create a new task
					// when navigating up, with a synthesized back stack.
					TaskStackBuilder.create(this)
							// Add all of this activity's parents to the back stack
							.addNextIntentWithParentStack(upIntent)
									// Navigate up to the closest parent
							.startActivities();
				} else {
					// This activity is part of this app's task, so simply
					// navigate up to the logical parent activity.
					NavUtils.navigateUpTo(this, upIntent);
				}
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
