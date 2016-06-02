package com.qinglu.livewall;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;

public class Particle {
	private Bitmap bitmap;
	private float posX = 0;
	private float posY = 0;
	private float posToX = 0;
	private float posToY = 0;
	private float scaleFromX = 1;
	private float scaleFromY = 1;
	private float scaleToX = 1;
	private float scaleToY = 1;
	private float rotationFrom = 0;
	private float rotationTo = 0;
	private float rotationSpeed = 0;
	public float speedX = 0f;
	public float speedY = 0f;
	private int r = 255;
	private int g = 255;
	private int b = 255;
	private int a = 255;
	private float alphaSpeed = 255;
	private long liveTime = 3000;
	private long currliveTime = 0;
	private boolean isLive = true;

	private int width, height;
	private Paint paint;
	private Matrix matrix;
	
	private boolean isPosX = false;
	private boolean isPosY = false;
	private boolean isScale = false;
	private boolean isRotation = false;
	private boolean isAlpha = false;
	
	private boolean isRotationForever = false;
	
	private boolean isBox = false;
	private int type = 0;//type 0 ÐÇÐÇ 1£ºµã»÷
	public Particle(Bitmap bitmap) {
		super();
		this.bitmap = bitmap;

		width = bitmap.getWidth();
		height = bitmap.getHeight();

		paint = new Paint();
		paint.setAntiAlias(true); // Ïû³ý¾â³Ý
		matrix = new Matrix();
	}

	public void update(Canvas canvas, float dt) {
		currliveTime+=dt;
		if(currliveTime > liveTime || isAlpha)
		{
			isLive = false;
			return;
		}
		float disX = Math.abs(posToX - posX);
		float disY = Math.abs(posToY - posY);
		float dis = (float) Math.sqrt(disX*disX + disY*disY);
		
		float pixX = speedX *  (disX/dis);
		float pixY = speedY * (disY/dis);
		

		if (posToX > posX && disX > speedX)
			posX += pixX;
		else if (posToX < posX && disX > speedX)
			posX -= pixX;
		else {
			isPosX = true;
		}

		if (posToY > posY && disY > speedY)
			posY += pixY;
		else if (posToY < posY && disY > speedY)
			posY -= pixY;
		else {
			isPosY = true;
		}

		float roa =  rotationSpeed;
		float disRota = Math.abs(rotationTo - rotationFrom);
		if (rotationFrom > rotationTo && disRota > 5)
			rotationFrom -= roa;
		else if (rotationFrom < rotationTo && disRota > 5)
			rotationFrom += roa;
		else {
			if(isRotationForever)
				rotationFrom = 0;
			else
				isRotation = true;
		}
		
		if(isPosX && isPosY)
		{
			a-=alphaSpeed;
			if(a <= 0)
			{
				a = 0;
				isAlpha = true;
			}
		}
		
		
		matrix.reset();
		matrix.postRotate(rotationFrom, (float) width / 2, (float) height / 2);
		matrix.postScale(scaleFromX, scaleFromY, (float) width / 2,
		 (float) height / 2);
		matrix.postTranslate(posX, posY);

		paint.setAlpha(a);
		canvas.drawBitmap(bitmap, matrix, paint);
		
		if(isLive &&  type == 0 && !isBox && LiveWallpaperPainting.sprite.isCotain(posX, posY))
		{
			isBox = true;			
			LiveWallpaperPainting.sprite.showXingText();
		}
//		paint.setColor(Color.RED);
//		canvas.drawLine(posX, posY, posToX, posToY, paint);
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
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

	public float getPosToX() {
		return posToX;
	}

	public void setPosToX(float posToX) {
		this.posToX = posToX;
	}

	public float getPosToY() {
		return posToY;
	}

	public void setPosToY(float posToY) {
		this.posToY = posToY;
	}

	public float getScaleFromX() {
		return scaleFromX;
	}

	public void setScaleFromX(float scaleFromX) {
		this.scaleFromX = scaleFromX;
	}

	public float getScaleFromY() {
		return scaleFromY;
	}

	public void setScaleFromY(float scaleFromY) {
		this.scaleFromY = scaleFromY;
	}

	public float getScaleToX() {
		return scaleToX;
	}

	public void setScaleToX(float scaleToX) {
		this.scaleToX = scaleToX;
	}

	public float getScaleToY() {
		return scaleToY;
	}

	public void setScaleToY(float scaleToY) {
		this.scaleToY = scaleToY;
	}

	public float getRotationFrom() {
		return rotationFrom;
	}

	public void setRotationFrom(float rotationFrom) {
		this.rotationFrom = rotationFrom;
	}

	public float getRotationTo() {
		return rotationTo;
	}

	public void setRotationTo(float rotationTo) {
		this.rotationTo = rotationTo;
	}

	public float getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(float rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
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

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	public long getLiveTime() {
		return liveTime;
	}

	public void setLiveTime(long liveTime) {
		this.liveTime = liveTime;
	}

	public long getCurrliveTime() {
		return currliveTime;
	}

	public void setCurrliveTime(long currliveTime) {
		this.currliveTime = currliveTime;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public boolean isRotationForever() {
		return isRotationForever;
	}

	public void setRotationForever(boolean isRotationForever) {
		this.isRotationForever = isRotationForever;
	}

	public float getAlphaSpeed() {
		return alphaSpeed;
	}

	public void setAlphaSpeed(float alphaSpeed) {
		this.alphaSpeed = alphaSpeed;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
