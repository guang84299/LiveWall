package com.qinglu.livewall;


import com.guang.guangclient.MainActivity;
import com.qinglu.ad.QLAdController;
import com.qinglu.livewall.R;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Toast;

public class LiveWallpaperService extends WallpaperService {
private static int i = 0;
private LiveWallReceiver receiver;
	@Override
	public Engine onCreateEngine() {
		
		return new SampleEngine();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		QLAdController.getInstance().init(this, R.drawable.ic_launcher, true);
		registerListener();
//		final Handler handler = new Handler() {
//
//			@Override
//			public void handleMessage(Message msg) {
//				if (msg.what == 100) {
//					Toast.makeText(LiveWallpaperService.this, "Count is " + i, 0).show();
//				}
//				super.handleMessage(msg);
//			}
//
//		};
//		Log.e("---------------", "onCreate");
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while (i <= 1000) {
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//					}
//					i++;
//					Log.e("CountService", "Count is " + i);
//					Message message = new Message();
//					message.what = 100;
//					handler.sendMessage(message);
//				}
//			}
//		}).start();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterListener();
	}
	
	private void registerListener() {
		receiver = new LiveWallReceiver();
		Log.e("-------------", "receiver");
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        this.registerReceiver(receiver, filter);
    }
 
    private void unregisterListener() {
           this.unregisterReceiver(receiver);
    }

	public class SampleEngine extends Engine {

		private LiveWallpaperPainting painting;

		SampleEngine() {
			SurfaceHolder holder = getSurfaceHolder();
			painting = new LiveWallpaperPainting(holder,
					getApplicationContext());
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			// register listeners and callbacks here
			setTouchEventsEnabled(true);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
			// remove listeners and callbacks here
			painting.stopPainting();
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			if (visible) {
				// register listeners and callbacks here
				painting.resumePainting();
			} else {
				// remove listeners and callbacks here
				painting.pausePainting();
			}
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
			painting.setSurfaceSize(width, height);
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
			// start painting
			painting.start();
			
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			boolean retry = true;
			painting.stopPainting();
			while (retry) {
				try {
					painting.join();
					retry = false;
				} catch (InterruptedException e) {
				}
			}
		}

		@Override
		public void onOffsetsChanged(float xOffset, float yOffset, float xStep,
				float yStep, int xPixels, int yPixels) {
		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);
			painting.doTouchEvent(event);
		}

	}
}
