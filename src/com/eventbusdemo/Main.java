package com.eventbusdemo;

import de.greenrobot.event.EventBus;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends FragmentActivity implements OnClickListener {

	Button bt;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main);

		bt = (Button) findViewById(R.id.main_sent_bt);
		bt.setOnClickListener(this);

		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.main_fragment1, new Fragment1());
		ft.add(R.id.main_fragment2, new Fragment2()).commit();

	}

	@Override
	public void onClick(View arg0) {
		String str = "======消息=====";
		EventBus.getDefault().post(str);

	}

}
