package com.qinglu.livewall;

import com.qinglu.livewall.R;

import android.app.Activity;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.preference.PreferenceActivity;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ComponentName componentName = new ComponentName(this.getPackageName(),  
				"com.qinglu.livewall.LiveWallpaperService");  
	
		
		Button btn = (Button) findViewById(R.id.button1);	
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {							
				Intent intents = new Intent();  
				intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   
				intents.setAction(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER );   
				intents.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,  
		                componentName);  
				startActivity(intents);
			}
		});

		
	}

}
