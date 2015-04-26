package com.eventbusdemo;

import de.greenrobot.event.EventBus;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment{

	
	TextView text;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment2, container,false);
		
		text=(TextView) view.findViewById(R.id.fragment2_tv);
		EventBus.getDefault().register(this);
				return view;
	}
	
	public void onEvent(String str){
		text.setText(str);
	}
	
	@Override
	 protected void onDestroy() {
	    super.onDestroy();
	    EventBus.getDefault().unregister(this);
	 }
	
}
