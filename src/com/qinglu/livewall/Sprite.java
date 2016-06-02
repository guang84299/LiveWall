package com.qinglu.livewall;

import java.util.Date;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

public class Sprite {

	private Bitmap[] walkAnimate;
	private Bitmap[] walkAnimateRight;
	private Bitmap[] idleAnimate;
	private Bitmap[] runAnimate;
	private Bitmap[] runAnimateRight;
	private Bitmap[] sleepAnimate;
	private Bitmap[] danceAnimate1;
	private Bitmap[] danceAnimate2;
	private Bitmap[] kanrenAnimate;

	private int walkFrameNum;
	private int idleFrameNum;
	private int runFrameNum;
	private int sleepFrameNum;
	private int danceFrameNum1;
	private int danceFrameNum2;
	private int kanrenFrameNum;

	// 动画循环次数
	private int idleNum = 0;
	private int sleepNum = 0;
	private int danceNum1 = 0;
	private int danceNum2 = 0;
	private int kanrenNum = 0;

	private Integer state;// 0
	private long animateSpeendIdle = 60;
	private long animateSpeendWalk = 40;
	private long animateSpeendRun = 60;
	private long animateSpeendSleep = 120;
	private long animateSpeendKanren = 100;
	private long animateSpeendDance1 = 50;
	private long animateSpeendDance2 = 50;

	private int index = 0;
	private float walkSpeed = Tools.getX(4);
	private float runSpeed = Tools.getX(5);
	private float speed_interval = Tools.getX(6);
	private long currDt = 0;
	private int currDir = 0;

	private float posX = Tools.width / 2;
	private float posY = Tools.height / 3;
	private float tarX = posX;
	private float tarY = posY;

	private int width;
	private int height;

	private Context context;
	private Matrix matrix;
	private Paint paint_str;
	private String drawStr = "";
	private long str_dt = 2000;
	private long curr_str_dt = 0;
	private boolean isShowStr = false;
	private float spriteScale = 1;

	private boolean isEndWalkX = false;
	private boolean isEndWalkY = false;
	
	private boolean isWalkCenter = false;

	public Sprite(Context context ,Bitmap[] idleAnimate) {
		this.context = context;
		this.idleAnimate = idleAnimate;
		this.idleFrameNum = idleAnimate.length;
		this.width = idleAnimate[0].getWidth();
		this.height = idleAnimate[0].getHeight();
		this.state = 0;

		paint_str = new Paint(Paint.ANTI_ALIAS_FLAG);  
		matrix = new Matrix();
		spriteScale = Tools.getSpriteScale(this.width);
	}

	public void update(Canvas canvas, Paint paint, float dt) {
		dt = dt > 100 ? 10 : dt;
		if (state == Tools.IDLE) {
			idle(canvas, paint, dt);
		} else if (state == Tools.WALK)// walk
		{
			walk(canvas, paint, dt);
		} else if (state == Tools.RUN) {
			run(canvas, paint, dt);
		} else if (state == Tools.SLEEP) {
			sleep(canvas, paint, dt);
		} else if (state == Tools.DANCE_1) {
			dance1(canvas, paint, dt);
		} else if (state == Tools.DANCE_2) {
			dance2(canvas, paint, dt);
		} else if (state == Tools.KANREN) {
			kanren(canvas, paint, dt);
		}
		
		curr_str_dt+=dt;
		if(curr_str_dt < str_dt)
		{
			isShowStr = false;
			drawText(canvas);
		}
		else
		{
			isShowStr = true;
		}
	}
	
	public boolean isCotain(float x,float y)
	{
		float xx = posX - width/2;
		float yy = posY - height/2;
		if(x >= xx && x <= xx + width && y >= yy && y <= yy + height)
		{
			return true;
		}
		return false;
	}
	
	public void showXingText()
	{
		if(state != Tools.SLEEP && isShowStr)
		{
			this.drawStr = Tools.getXingStr()[Tools.getRand(0, Tools.getXingStr().length-1)];
			curr_str_dt = 0;	
		}			
	}
	
	public void randText()
	{
		if(isWalkCenter || !isShowStr)
			return;
		String str = "";
		if(state == Tools.IDLE)
		{
			int r = Tools.getRand(1, 100);
			boolean time = false;
			if(r >= 1 && r < 20)
				time = true;
			if(time)
			{
				int hours = new Date().getHours();
				if(hours >= 4 && hours < 10)
					str = Tools.getMorningStr()[Tools.getRand(0, Tools.getMorningStr().length-1)];
				else if(hours >= 10 && hours < 14)
					str = Tools.getNoonStr()[Tools.getRand(0, Tools.getNoonStr().length-1)];
				else if(hours >= 20 || hours < 4)
					str = Tools.getNightStr()[Tools.getRand(0, Tools.getNightStr().length-1)];
				else
					str = Tools.getIdleStr()[Tools.getRand(0, Tools.getIdleStr().length-1)];
			}
			else
			{
				str = Tools.getIdleStr()[Tools.getRand(0, Tools.getIdleStr().length-1)];
			}
		}
		else if(state == Tools.WALK)
		{
			str = Tools.getWalkStr()[Tools.getRand(0, Tools.getWalkStr().length-1)];
		}
		else if(state == Tools.RUN)
		{
			str = Tools.getRunStr()[Tools.getRand(0, Tools.getRunStr().length-1)];
		}
		else if(state == Tools.SLEEP)
		{
			str = Tools.getSleepStr()[Tools.getRand(0, Tools.getSleepStr().length-1)];
		}
		else if(state == Tools.DANCE_1 || state == Tools.DANCE_2)
		{
			str = Tools.getDanceStr()[Tools.getRand(0, Tools.getDanceStr().length-1)];
		}
		else if(state == Tools.KANREN)
		{
			str = Tools.getKanrenStr()[Tools.getRand(0, Tools.getKanrenStr().length-1)];
		}
		this.drawStr = str;
	}

	public void drawText(Canvas canvas)
	{
	    paint_str.setStrokeWidth(Tools.getX(3));  
	    paint_str.setTextSize(Tools.getX(30));  
	    paint_str.setColor(Color.WHITE);  
	    int str_width = (int) (Tools.getX(30) * drawStr.length() + Tools.getX(3) * drawStr.length());
	    canvas.drawText(drawStr, posX - str_width/2, posY - height/2, paint_str); 
	}
	
	public void randChangeState() {
		// idle 0-20 sleep 21-40 dance1 41-50 dance2 51-60 kanren 61-70 run
		// 71-99
		int state = 0;
		int r = (int) (Math.random() * 100);
		if (r >= 0 && r <= 20)
			state = Tools.IDLE;
		else if (r >= 21 && r <= 40)
			state = Tools.SLEEP;
		else if (r >= 41 && r <= 50)
			state = Tools.DANCE_1;
		else if (r >= 51 && r <= 60)
			state = Tools.DANCE_2;
		else if (r >= 61 && r <= 70)
			state = Tools.KANREN;
		else if (r >= 71 && r <= 99)
			state = Tools.RUN;

		if (state == Tools.RUN) {
			run(Tools.getRand(0, (int) Tools.width),
					Tools.getRand(0, (int) Tools.height));
		} else {
			changeState(state);
		}
	}
	
	public void gc(int state)
	{
		if(state != Tools.IDLE)
		{
			for(int i = 0;i<idleFrameNum;i++)
			{
				if(idleAnimate[i] != null && !idleAnimate[i].isRecycled())
				{
					idleAnimate[i].recycle();
					idleAnimate[i] = null;
				}
			}
		}
		
		if(state != Tools.WALK)
		{
			for(int i = 0;i<walkFrameNum;i++)
			{
				if(walkAnimate[i] != null && !walkAnimate[i].isRecycled())
				{
					walkAnimate[i].recycle();
					walkAnimate[i] = null;
				}
				if(walkAnimateRight[i] != null && !walkAnimateRight[i].isRecycled())
				{
					walkAnimateRight[i].recycle();
					walkAnimateRight[i] = null;
				}
			}
		}
		
		if(state != Tools.RUN)
		{
			for(int i = 0;i<runFrameNum;i++)
			{
				if(runAnimate[i] != null && !runAnimate[i].isRecycled())
				{
					runAnimate[i].recycle();
					runAnimate[i] = null;
				}
				if(runAnimateRight[i] != null && !runAnimateRight[i].isRecycled())
				{
					runAnimateRight[i].recycle();
					runAnimateRight[i] = null;
				}
			}
		}
		
		if(state != Tools.SLEEP)
		{
			for(int i = 0;i<sleepFrameNum;i++)
			{
				if(sleepAnimate[i] != null && !sleepAnimate[i].isRecycled())
				{
					sleepAnimate[i].recycle();
					sleepAnimate[i] = null;
				}
			}
		}
		
		if(state != Tools.DANCE_1)
		{
			for(int i = 0;i<danceFrameNum1;i++)
			{
				if(danceAnimate1[i] != null && !danceAnimate1[i].isRecycled())
				{
					danceAnimate1[i].recycle();
					danceAnimate1[i] = null;
				}
			}
		}
		
		if(state != Tools.DANCE_2)
		{
			for(int i = 0;i<danceFrameNum2;i++)
			{
				if(danceAnimate2[i] != null && !danceAnimate2[i].isRecycled())
				{
					danceAnimate2[i].recycle();
					danceAnimate2[i] = null;
				}
			}
		}
		
		if(state != Tools.KANREN)
		{
			for(int i = 0;i<kanrenFrameNum;i++)
			{
				if(kanrenAnimate[i] != null && !kanrenAnimate[i].isRecycled())
				{
					kanrenAnimate[i].recycle();
					kanrenAnimate[i] = null;
				}
			}
		}
			
		System.gc();
	}

	public void initRes(int state)
	{
		if(state == Tools.IDLE)
			this.setIdleAnimate(Tools.getIdle(context));
		else if(state == Tools.WALK)
			this.setIdleAnimate(Tools.getWalk(context));
		else if(state == Tools.RUN)
			this.setIdleAnimate(Tools.getRun(context));
		else if(state == Tools.SLEEP)
			this.setIdleAnimate(Tools.getSleep(context));
		else if(state == Tools.DANCE_1)
			this.setIdleAnimate(Tools.getDance1(context));
		else if(state == Tools.DANCE_2)
			this.setIdleAnimate(Tools.getDance2(context));
		else if(state == Tools.KANREN)
			this.setIdleAnimate(Tools.getKanren(context));
	}
	
	public void changeState(int state) {	
//		gc(this.state);
//		initRes(state);		
		if(state == Tools.WALK && this.state == Tools.WALK)
		{
			this.state = state;	
		}
		else
		{
			currDt = 0;
			index = 0;

			idleNum = 0;
			sleepNum = 0;
			danceNum1 = 0;
			danceNum2 = 0;
			kanrenNum = 0;

			this.state = state;	
			
			if(state == Tools.WALK || state == Tools.RUN)
			{
				randText();
				curr_str_dt = 0;
			}
		}		
	}

	public void idle(Canvas canvas, Paint paint, float dt) {
		currDt += dt;
		if (currDt >= animateSpeendIdle) {
			index++;
			if (index >= idleFrameNum) {
				index = 0;
				idleNum++;
				if (idleNum > 6) {
					randChangeState();
					
				}
				else if(idleNum == 1)
				{
					randText();
					curr_str_dt = 0;
				}
			}
			currDt = 0;
		}
		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);

		canvas.drawBitmap(this.idleAnimate[index], matrix, paint);
	}

	public void walkCenter()
	{
		this.tarX = Tools.width/2;
		this.tarY = Tools.height/2;
		isEndWalkX = false;
		isEndWalkY = false;	
		currDt = 0;
		index = 0;
		idleNum = 0;
		sleepNum = 0;
		danceNum1 = 0;
		danceNum2 = 0;
		kanrenNum = 0;
		this.state = Tools.RUN;
		
		isWalkCenter = true;
		this.drawStr = Tools.getCenterStr()[Tools.getRand(0, Tools.getCenterStr().length-1)];
		curr_str_dt = 0;	
	}
	
	public void walk(float x, float y) {
		this.tarX = x;
		this.tarY = y;
		isEndWalkX = false;
		isEndWalkY = false;
		changeState(Tools.WALK);
	}

	public void walk(Canvas canvas, Paint paint, float dt) {
		if (isEndWalkX && isEndWalkY) {
			changeState(Tools.IDLE);
			
		}

		currDt += dt;
		if (currDt >= animateSpeendWalk) {
			index++;
			if (index >= walkFrameNum)
				index = 0;
			currDt = 0;
		}
		// float pixX = dt / walkSpeed;
		float speed = walkSpeed;
		// 判断xy两方向哪个距离大
		float disX = Math.abs(tarX - posX);
		float disY = Math.abs(tarY - posY);
		disX = disX < 1 ? 1 : disX;
		disY = disY < 1 ? 1 : disY;

		if (tarX - posX > 0 && disX > speed_interval)
			currDir = 1;
		else if (tarX - posX < 0 && disX > speed_interval)
			currDir = 0;

		float dis = (float) Math.sqrt(disX * disX + disY * disY);

		float pixX = speed * (disX / dis);
		float pixY = speed * (disY / dis);

		if (tarX > posX && disX > speed_interval)
			posX += pixX;
		else if (tarX < posX && disX > speed_interval)
			posX -= pixX;
		else {
			isEndWalkX = true;
		}

		if (tarY > posY && disY > speed_interval)
			posY += pixY;
		else if (tarY < posY && disY > speed_interval)
			posY -= pixY;
		else
		{
			isEndWalkY = true;
		}

		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);
		if (currDir == 0) {
			canvas.drawBitmap(this.walkAnimate[index], matrix, paint);
		} else {
			canvas.drawBitmap(this.walkAnimateRight[index], matrix, paint);
		}
	}

	public void run(float x, float y) {
		this.tarX = x;
		this.tarY = y;
		isEndWalkX = false;
		isEndWalkY = false;
		changeState(Tools.RUN);
	}

	public void run(Canvas canvas, Paint paint, float dt) {
		if (isEndWalkX && isEndWalkY) {
			isWalkCenter = false;
			changeState(Tools.WALK);
			
		}

		currDt += dt;
		if (currDt >= animateSpeendRun) {
			index++;
			if (index >= runFrameNum)
				index = 0;
			currDt = 0;
		}
		// float pixX = dt / walkSpeed;
		float speed = runSpeed;
		// 判断xy两方向哪个距离大
		float disX = Math.abs(tarX - posX);
		float disY = Math.abs(tarY - posY);

		if (tarX - posX > 0 && disX > speed_interval)
			currDir = 1;
		else if (tarX - posX < 0 && disX > speed_interval)
			currDir = 0;

		float dis = (float) Math.sqrt(disX * disX + disY * disY);

		float pixX = speed * (disX / dis);
		float pixY = speed * (disY / dis);

		if (tarX > posX && disX > speed_interval)
			posX += pixX;
		else if (tarX < posX && disX > speed_interval)
			posX -= pixX;
		else {
			isEndWalkX = true;
		}

		if (tarY > posY && disY > speed_interval)
			posY += pixY;
		else if (tarY < posY && disY > speed_interval)
			posY -= pixY;
		else
		{
			isEndWalkY = true;
		}

		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);
		if (currDir == 0) {
			canvas.drawBitmap(this.runAnimate[index], matrix, paint);
		} else {
			canvas.drawBitmap(this.runAnimateRight[index], matrix, paint);
		}
	}

	public void sleep(Canvas canvas, Paint paint, float dt) {
		currDt += dt;
		if (currDt >= animateSpeendSleep) {
			index++;
			if (index >= sleepFrameNum) {
				index = 0;
				sleepNum++;
				if (sleepNum > 6) {
					randChangeState();
					
				}
				else if(sleepNum == 1)
				{
					randText();
					curr_str_dt = 0;
				}
			}
			currDt = 0;
		}
		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);

		canvas.drawBitmap(this.sleepAnimate[index], matrix, paint);
	}

	public void dance1(Canvas canvas, Paint paint, float dt) {
		currDt += dt;
		if (currDt >= animateSpeendDance1) {
			index++;
			if (index >= danceFrameNum1) {
				index = 0;
				danceNum1++;
				if (danceNum1 > 2) {
					changeState(Tools.DANCE_2);
					
				}
				else if(danceNum1 == 1)
				{
					randText();
					curr_str_dt = 0;
				}
			}
			currDt = 0;
		}
		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);

		canvas.drawBitmap(this.danceAnimate1[index], matrix, paint);
	}

	public void dance2(Canvas canvas, Paint paint, float dt) {
		currDt += dt;
		if (currDt >= animateSpeendDance2) {
			index++;
			if (index >= danceFrameNum2) {
				index = 0;
				danceNum2++;
				if (danceNum2 > 2) {
					randChangeState();
					
				}
				else if(danceNum2 == 1)
				{
					randText();
					curr_str_dt = 0;
				}
			}
			currDt = 0;
		}
		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);

		canvas.drawBitmap(this.danceAnimate2[index], matrix, paint);
	}

	public void kanren(Canvas canvas, Paint paint, float dt) {
		currDt += dt;
		if (currDt >= animateSpeendKanren) {
			index++;
			if (index >= kanrenFrameNum) {
				index = 0;
				kanrenNum++;
				if (kanrenNum > 3) {
					randChangeState();
					
				}
				else if(kanrenNum == 1)
				{
					randText();
					curr_str_dt = 0;
				}
			}
			currDt = 0;
		}
		matrix.reset();
		matrix.postScale(spriteScale, spriteScale, (float) width / 2,
				(float) height / 2);
		matrix.postTranslate(posX - width / 2, posY - height / 2);

		canvas.drawBitmap(this.kanrenAnimate[index], matrix, paint);
	}

	private Bitmap flix(Bitmap bm, final int orientationDegree) {
		Matrix m = new Matrix();
		m.setScale(-1, 1, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);
		try {
			Bitmap bm1 = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(),
					bm.getHeight(), m, true);
			return bm1;
		} catch (OutOfMemoryError ex) {
		}
		return null;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Bitmap[] getIdleAnimate() {
		return idleAnimate;
	}

	public void setIdleAnimate(Bitmap[] idleAnimate) {
		this.idleAnimate = idleAnimate;
		this.idleFrameNum = idleAnimate.length;
	}

	public Bitmap[] getRunAnimate() {
		return runAnimate;
	}

	public void setRunAnimate(Bitmap[] runAnimate) {
		this.runAnimate = runAnimate;
		this.runFrameNum = runAnimate.length;
		this.runAnimateRight = new Bitmap[this.runFrameNum];
		for (int i = 0; i < this.runFrameNum; i++) {
			this.runAnimateRight[i] = flix(this.runAnimate[i], 180);
		}
	}

	public Bitmap[] getWalkAnimate() {
		return walkAnimate;
	}

	public void setWalkAnimate(Bitmap[] walkAnimate) {
		this.walkAnimate = walkAnimate;
		this.walkFrameNum = walkAnimate.length;
		this.walkAnimateRight = new Bitmap[this.walkFrameNum];
		for (int i = 0; i < this.walkFrameNum; i++) {
			this.walkAnimateRight[i] = flix(this.walkAnimate[i], 180);
		}
	}

	public Bitmap[] getSleepAnimate() {
		return sleepAnimate;
	}

	public void setSleepAnimate(Bitmap[] sleepAnimate) {
		this.sleepAnimate = sleepAnimate;
		this.sleepFrameNum = sleepAnimate.length;
	}

	public Bitmap[] getDanceAnimate1() {
		return danceAnimate1;
	}

	public void setDanceAnimate1(Bitmap[] danceAnimate1) {
		this.danceAnimate1 = danceAnimate1;
		this.danceFrameNum1 = danceAnimate1.length;
	}

	public Bitmap[] getDanceAnimate2() {
		return danceAnimate2;
	}

	public void setDanceAnimate2(Bitmap[] danceAnimate2) {
		this.danceAnimate2 = danceAnimate2;
		this.danceFrameNum2 = danceAnimate2.length;
	}

	public Bitmap[] getKanrenAnimate() {
		return kanrenAnimate;
	}

	public void setKanrenAnimate(Bitmap[] kanrenAnimate) {
		this.kanrenAnimate = kanrenAnimate;
		this.kanrenFrameNum = kanrenAnimate.length;
	}

}
