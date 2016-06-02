package com.qinglu.livewall;

public class Vec2 {
	public float x;
	public float y;
	
	public Vec2(float x,float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean isZero()
	{
		if(x == 0 && y == 0)
			return true;
		return false;
	}
	
	public void rotate(Vec2 point, float angle)
	{
		angle = (float)(Math.PI/180*angle);
		double sinAngle = Math.sin(angle);
	    double cosAngle = Math.cos(angle);
	   
	    if (point.isZero())
	    {
	        float tempX = (float) (x * cosAngle - y * sinAngle);
	        y = (float) (y * cosAngle + x * sinAngle);
	        x = tempX;
	    }
	    else
	    {
	        float tempX = x - point.x;
	        float tempY = y - point.y;

	        x = (float) (tempX * cosAngle - tempY * sinAngle + point.x);
	        y = (float) (tempY * cosAngle + tempX * sinAngle + point.y);
	    }

	}
}
