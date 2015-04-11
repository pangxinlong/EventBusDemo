package com.eventbusdemo.example2;

import com.eventbusdemo.R;
import com.eventbusdemo.R.id;
import com.eventbusdemo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import de.greenrobot.event.EventBus;

public class RecevierActivity extends Activity implements OnClickListener {

	TextView recevier_tv;

	Button recevier_bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recevier);

		recevier_tv = (TextView) findViewById(R.id.recevier_tv);
		recevier_bt = (Button) findViewById(R.id.recevier_bt);

		EventBus.getDefault().register(this);

		recevier_bt.setOnClickListener(this);
	}

	public void onEventMainThread(String str) {
		Toast.makeText(this, "接受到了消息" + "[" + str + "]", Toast.LENGTH_SHORT)
				.show();
		;
		recevier_tv.setText(str);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}

	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent();
		intent.setClass(this, SentActivity.class);
		startActivity(intent);

	}

}
