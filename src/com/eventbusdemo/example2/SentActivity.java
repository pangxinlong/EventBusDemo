package com.eventbusdemo.example2;

import com.eventbusdemo.R;
import com.eventbusdemo.R.id;
import com.eventbusdemo.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.greenrobot.event.EventBus;

public class SentActivity extends Activity implements OnClickListener{

	Button sent_bt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_sent);
				
				sent_bt=(Button) findViewById(R.id.sent_bt);
				sent_bt.setOnClickListener(this);
				
	}

	
	
	@Override
	public void onClick(View arg0) {
		String s="=====消息===";

		EventBus.getDefault().post(s);

//		Intent intent=new Intent();
//		intent.setClass(this, RecevierActivity.class);
//		startActivity(intent);
		
	}
	
	
	
}
