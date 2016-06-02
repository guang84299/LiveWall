package com.qinglu.livewall;



import com.qinglu.livewall.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class LiveWallpaperPainting extends Thread {

	/** Reference to the View and the context */
	private SurfaceHolder surfaceHolder;
	private Context context;
	
	/** State */
	private boolean wait;
	private boolean run;

	/** Dimensions */
	private int width;
	private int height;

	/** Time tracking */
	private long previousTime;
	private long currentTime;
	private long dt;

	private Paint paint;
	private Bitmap bitmap;
	private Bitmap icon;

	private Shader mBitmapShader = null;
	private Bitmap mBitmapPn = null;
	private Shader mRadialGradient = null;  
	private ShapeDrawable mShapeDrawable = null;  

	private int icon_w, icon_h;
	private int x = 0, y = 0;
	private int t_x = 0,t_y = 0;
	
	private long d_time = 0;
	
	public static Sprite sprite;	
	private ParticleSystem particleSystem;
	private boolean isClick;
	private boolean isUpdateClick = false;

	public LiveWallpaperPainting(SurfaceHolder surfaceHolder, Context context) {
		this.surfaceHolder = surfaceHolder;
		this.context = context;
		paint = new Paint();		
		paint.setAntiAlias(true); // 消除锯齿

		this.bitmap = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.bg);
		this.icon = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.star_white);
		this.icon_w = this.icon.getWidth();
		this.icon_h = this.icon.getHeight();

		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		Tools.width = dm.widthPixels;
		Tools.height = dm.heightPixels;
		// 创建与当前使用的设备窗口大小一致的图片
		mBitmapPn = Bitmap.createScaledBitmap(bitmap, dm.widthPixels,
				dm.heightPixels, true);
		// 创建BitmapShader object
		mBitmapShader = new BitmapShader(mBitmapPn, Shader.TileMode.REPEAT,
				Shader.TileMode.MIRROR);
		// don't animate until surface is created and displayed
		
		this.wait = true;
			
		sprite = new Sprite(context,Tools.getIdle(context));
		sprite.setWalkAnimate(Tools.getWalk(context));
		sprite.setRunAnimate(Tools.getRun(context));
		sprite.setSleepAnimate(Tools.getSleep(context));
		sprite.setDanceAnimate1(Tools.getDance1(context));
		sprite.setDanceAnimate2(Tools.getDance2(context));
		sprite.setKanrenAnimate(Tools.getKanren(context));
		
		particleSystem = new ParticleSystem(this.icon,dm.widthPixels,dm.heightPixels);
	}

	/**
	 * Pauses the live wallpaper animation
	 */
	public void pausePainting() {
		this.wait = true;
		synchronized (this) {
			this.notify();
		}
	}

	/**
	 * Resume the live wallpaper animation
	 */
	public void resumePainting() {
		this.wait = false;		
		synchronized (this) {
			this.notify();
		}
	}

	/**
	 * Stop the live wallpaper animation
	 */
	public void stopPainting() {
		this.run = false;
		synchronized (this) {
			this.notify();
		}
	}

	@Override
	public void run() {
		this.run = true;
		Canvas c = null;
		while (run) {
			try {
				c = this.surfaceHolder.lockCanvas(null);
				synchronized (this.surfaceHolder) {
					currentTime = System.currentTimeMillis();
					dt = currentTime - previousTime;
					updatePhysics();
					doDraw(c);
					previousTime = currentTime;					
				}
			} finally {
				if (c != null) {
					this.surfaceHolder.unlockCanvasAndPost(c);
				}
			}
			// pause if no need to animate
			synchronized (this) {
				if (wait) {
					try {
						wait();
					} catch (Exception e) {
					}
				}
			}
		}
	}

	/**
	 * Invoke when the surface dimension change
	 */
	public void setSurfaceSize(int width, int height) {
		this.width = width;
		this.height = height;
		synchronized (this) {
			this.notify();
		}
	}

	/**
	 * Invoke while the screen is touched
	 */
	public void doTouchEvent(MotionEvent event) {
		// handle the event here
		// if there is something to animate
		// then wake up
		 // @设置alpha通道（透明度）  
		
		if(event.getAction() == MotionEvent.ACTION_DOWN)
		{
			t_x = (int) event.getRawX();
			t_y = (int) event.getRawY();
			isClick = true;
		}
		else if(event.getAction() == MotionEvent.ACTION_MOVE)
		{
			if(Math.abs(event.getRawX() - t_x) > 10 || Math.abs(event.getRawY() - t_y) > 10)
				isClick = false;
			if(!isClick)
			{
				particleSystem.line(event.getRawX(), event.getRawY());
			}
		}
		else if(event.getAction() == MotionEvent.ACTION_UP)
		{
			t_x = (int) event.getRawX();
			t_y = (int) event.getRawY();	
			if(isClick)
			{
				isUpdateClick = true;
			}
		}
//		paint.setAlpha(400);  
//        mRadialGradient = new RadialGradient(t_x, t_y, 50,  
//                new int[] { Color.WHITE, Color.TRANSPARENT },new float[]{20,20}, Shader.TileMode.REPEAT);  
        // @重绘  
       // postInvalidate();  
        
		this.wait = false;
		synchronized (this) {
			notify();
		}
	}

	/**
	 * Do the actual drawing stuff
	 */
	private void doDraw(Canvas canvas) {

		canvas.drawBitmap(this.bitmap, null, new Rect(0, 0, this.width,
				this.height), paint);
		sprite.update(canvas, paint, dt);
		particleSystem.update(canvas, dt);
		if(isClick && isUpdateClick)
		{			
			isUpdateClick = false;
			sprite.walk(t_x, t_y);
			particleSystem.click(t_x, t_y);
		}
		//Tools.drawText(canvas,paint_str, "我们是中国人，abcdef，123456", t_x, t_y);
//
//		canvas.drawBitmap(this.icon, x, y, paint);
		
		// 将图片裁剪为椭圆型  
        // 创建ShapeDrawable object，并定义形状为椭圆  
//        mShapeDrawable = new ShapeDrawable(new OvalShape());// OvalShape:椭圆  
//        // 设置要绘制的椭圆形的东西为ShapeDrawable图片  
//        mShapeDrawable.getPaint().setShader(mBitmapShader);  
//        // 设置显示区域  
//        mShapeDrawable.setBounds(0, 0, mBitmapPn.getWidth(),  
//                mBitmapPn.getHeight());  
//        // 绘制ShapeDrawable  
//        mShapeDrawable.draw(canvas);  
//        if (mRadialGradient != null) {  
//        	paint.setShader(mRadialGradient);  
//            canvas.drawCircle(t_x,t_y, 400, paint);  
//        }  
	}

	/**
	 * Update the animation, sprites or whatever. If there is nothing to animate
	 * set the wait attribute of the thread to true
	 */
	private void updatePhysics() {
		// if nothing was updated :
		// this.wait = true;
		d_time += dt;
		if(d_time > 500)
		{
			mRadialGradient = null;
			d_time = 0;
		}
		// this.wait = false;
	}

}
