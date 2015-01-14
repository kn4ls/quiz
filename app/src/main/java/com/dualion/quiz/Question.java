package com.dualion.quiz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Question extends Activity implements TextLinkClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);

		/*String text = "You have five servers that run Windows Server 2012 R2. The servers have the Failover Clustering feature installed. \n" +
				"You deploy a new cluster named Cluster1. Cluster1 is configured as shown in the following table. \n" +
				"http://www.itexamquiz.com/braindump2go/bdimages/f2cff29afa24_F393/wps5151.tmp_thumb.png \n" +
				"Server1, Server2, and Server3 are configured as the preferred owners of the cluster roles. Dynamic quorum management is disabled. \n" +
				"You plan to perform hardware maintenance on Server3. \n" +
				"You need to ensure that if the WAN link between Site1 and Site2 fails while you are performing maintenance on Servers, the cluster resource will remain available in Site1. \n" +
				"What should you do?";*/

		String text = "<p>QUESTION 168<br>You have five servers that run Windows Server 2012 R2. The servers have the Failover Clustering feature installed. <br>You deploy a new cluster named Cluster1. Cluster1 is configured as shown in the following table.</p><p>http://www.itexamquiz.com/braindump2go/bdimages/f2cff29afa24_F393/wps5151.tmp_thumb_thumb.png </p><p>Server1, Server2, and Server3 are configured as the preferred owners of the cluster roles. Dynamic quorum management is disabled. <br>You plan to perform hardware maintenance on Server3. <br>You need to ensure that if the WAN link between Site1 and Site2 fails while you are performing maintenance on Servers, the cluster resource will remain available in Site1. <br>What should you do?</p>";

		LinkEnabledTextView check = (LinkEnabledTextView) findViewById(R.id.question);
		check.setOnTextLinkClickListener(this);
		check.gatherLinksForText(text);

		MovementMethod m = check.getMovementMethod();
		if ((m == null) || !(m instanceof LinkMovementMethod)) {
			if (check.getLinksClickable()) {
				check.setMovementMethod(LinkMovementMethod.getInstance());
			}
		}

	}

	public void onTextLinkClick(View textView, String clickedString)
	{
		Intent intent = new Intent(this, WebViewActivity.class);
		intent.setData(Uri.parse(clickedString));
		startActivity(intent);
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_question, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
