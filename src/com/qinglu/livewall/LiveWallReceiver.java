package com.qinglu.livewall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LiveWallReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		 String action = intent.getAction();
         if (Intent.ACTION_USER_PRESENT.equals(action)) { // ����
           LiveWallpaperPainting.sprite.walkCenter();
         } 
	}

}
