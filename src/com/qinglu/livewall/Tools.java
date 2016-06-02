package com.qinglu.livewall;

import com.qinglu.livewall.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Tools {

	public static final float des_width = 1152;
	public static final float des_height = 1920;
	public static float width = 0;
	public static float height = 0;
	
	public static final int IDLE = 0;
	public static final int WALK = 1;
	public static final int RUN = 2;
	public static final int DANCE_1 = 3;
	public static final int DANCE_2 = 4;
	public static final int SLEEP = 5;
	public static final int KANREN = 6;
	
	public static final int inSampleSize = 1;
	
	public static float getScaleX()
	{
		return width / des_width;
	}
	
	public static float getScaleY()
	{
		return height / des_height;
	}
	
	public static float getX(float x)
	{
		return getScaleX() * x;
	}
	
	public static float getY(float y)
	{
		return getScaleY() * y;
	}
	
	public static float getSpriteScale(float s)
	{
		return width / 5 / s;
	}
	
	public static int getRand(int start, int end) {
		int num = (int) (Math.random() * end);
		if (num < start)
			num = start;
		else if (num >= start && num <= end)
			return num;
		else {
			num = num + start;
			if (num > end)
				num = end;
		}
		return num;
	}
	
		
	public static Bitmap[] getIdle(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] animate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_9,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_10,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.daiji_11,opts)				
				
		};
		
		return animate;
	}
	
	public static Bitmap[] getWalk(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] walkAnimate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_9,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_10,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_11,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_12,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_13,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_14,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao_15,opts)			
		};
		
		return walkAnimate;
	}
	
	public static Bitmap[] getRun(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] aimate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.pao2_9,opts)
		};
		return aimate;
	}
	
	public static Bitmap[] getKanren(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] animate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_9,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_10,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_11,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_12,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_13,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_14,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_15,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_16,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_17,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_18,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_19,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_20,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_21,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_22,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_23,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_24,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_25,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_26,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_27,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_28,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_29,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_30,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_31,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_32,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_33,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_34,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_35,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.kanren_36,opts)
				
		};
		return animate;
	}

	public static Bitmap[] getDance1(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] animate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_9,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_10,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_11,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_12,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu_13,opts)
		};
		return animate;
	}
	
	public static Bitmap[] getDance2(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] animate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_9,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_10,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_11,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_12,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_13,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_14,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_15,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_16,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_17,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_18,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_19,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_20,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_21,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_22,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_23,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_24,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.tiapwu2_25,opts)
		};
		return animate;
	}
		
	public static Bitmap[] getSleep(Context context)
	{
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inSampleSize = inSampleSize;
		Bitmap[] animate = {
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_0,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_1,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_2,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_3,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_4,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_5,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_6,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_7,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_8,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_9,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_10,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_11,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_12,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_13,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_14,opts),
				BitmapFactory.decodeResource(context.getResources(),R.drawable.sleep_15,opts)
		};
		return animate;
	}

	public static String[] getMorningStr()
	{
		String[] morning = new String[]{
				"���ˣ���������磡",
				"���ˣ��ó��緹���أ�",
				"���ˣ��緹����ʲôѽ��",
				"С�������ڵ�����г�ԣ�������ֻ����",
				"С������Ҫ���ձ�������",
				"С�����һ�Ҫ�������֥ʿ",
				"С�����緹û�Ծͳ����˰ɣ�������",
				"���ӣ�����Ĺ�������",
				"���ˣ������и�SB�۸����ˣ��ҽ��绹������",
				"���棺���������˸�ʪʪ��X��",
				"���ˣ�������һ������ǵ������Ұ�"

		};				
		return morning;
	}
	
	public static String[] getNoonStr()
	{		
		String[] noon = new String[]{
				"���ˣ���Ҫ��Ҫ˯������أ�",
				"���ˣ��ó��緹���أ�",
				"���ˣ��������ɶѽ��",
				"��˵���������˯����Ŷ",
				"�������緹���������������",
				"�쵼������ͱ��������˰�",
				"���ˣ�������һ������ǵ������Ұ�"
		};		
		return noon;
	}
	public static String[] getNightStr()
	{				
		String[] night = new String[]{
				"���ˣ���Ҫ��˯���𰡣�",
				"���ˣ�����ҹ�ģ���Լ�ܣ�",
				"���ˣ���Ҫ���ǳ�������",				
				"���ˣ����Ե�ɶ����",
				"���ˣ����ٳԵ������Ŷ",
				"�ߣ�ɢ��ȥ",
				"����ˣ���Լ��",
				"���ˣ���ڵ�Ϲ��ģ���Ҫ��ɶ",
				"С��������������",
				"����һ���ˣ�����������",
				"���ˣ������и������۸��ң���Ҫ������",
				"���ˣ�������һ������ǵ������Ұ�"
		};
		
		return night;
	}
	
	public static String[] getIdleStr()
	{
		return new String[]{
				"������Ŷ�����ˣ��������һ��ɣ�",
				"�Ǻǣ����ھ����ó��氡�������������أ�",
				"�ۣ����Ǻ���������",
				"���ˣ����������Ұɣ�",
				"С�������������ǡ����� ",
				"���ˣ����������ң�������",
				"�ٲ������ҾͶ�������Ŷ",
				"�ٲ�������������Ŷ������",
				"���ˣ�������һ������ǵ������Ұ�"
	
		};
	}
	
	public static String[] getWalkStr()
	{
		return new String[]{
				"Ŭ���ܲ�����Ҫ��ø��죡",
				"����һֻ�Ȱ��˶����Ȱ������Сè����",
				"���ˣ������������ܰɣ�",				
				"���ܣ����ܣ��������ܣ�",
				"����һֻ׷���ǵ�è��",
				"������֮���ǵ���è",
				"��׷�����ǣ�׷��ʫ��Զ��",
				"���ˣ�������һ������ǵ������Ұ�"
		};
	}
	
	public static String[] getRunStr()
	{
		return new String[]{
				"���ģ�ȥ�Ǳ߿�����",
				"��һȦ������ɶ����Ĳ���",
				"���ˣ��Ҷ����ĵ�Ϲ���ΰ����ˡ���",
				"���ˣ��Ҷ�Ϲ���ΰ����ˡ�",			
				"���ˣ��ð�Ъ���",
				"С�������ܵĶ�ʪ�ˣ���ʪ��",
				"��ү��С��ʵ���ܲ�����",
				"�쵼��������Ҫ�����Ұ�",
				"��ʦ�������巣��������",
				"�ϴ�������������ץ�����",
				"���ҵ��ٶȣ���ʵ����ĸ�ϻ�",
				"��˵�����������죬�ҵ����͸��Ը�",
				"���ˣ�������һ������ǵ������Ұ�"

		};
	}
	
	public static String[] getSleepStr()
	{
		return new String[]{
				"��������Ҫ˯���������ľ�����Ҫ�����Ұ�����",
				"��������",
				"���ˣ��Һ����ˣ�����˯�ᡣ����",
				"���ۣ�����˯������",
				"�Һ����μ�TA��Ŷ������",
				"�������﷦���������",
				"��˵��˯�����죬�ҵ������ͱ�����",
				"���ˣ�������һ������ǵ������Ұ�"

		};
	}

	public static String[] getDanceStr()
	{
		return new String[]{
				"���ˣ��ҵ������ð���������",
				"���ˣ�����Ϊ����ֻ��ɣ�",
				"���ˣ����ҵ���Ư�������ҿɰ�����",
				"���������˲Ż�������Ŷ",
				"����������",
				"�����˻�������",
				"��Ҫ���裬˭��PK?",
				"��˵��������Ҿ���ѧ��ֹ���Ŷ",
				"���ˣ�������һ������ǵ������Ұ�"

		};
	}
	
	public static String[] getKanrenStr()
	{
		return new String[]{
				"��Ҫ�����ˣ��˼Ҷ������ˡ�����",
				"���ˣ��㿴�ҿɰ�����",
				"�ÿ��İ���",
				"���Ҹ�ʲô",
				"���ң��ٿ����Ҿͷ����Ŷ",
				"�˼���ĸ�ģ��᲻����˼��",
				"���ˣ��Һܿ�ͻ����±�����Ŷ",
				"��˵��������ҵ���Ļ����Ŷ",
				"���ˣ�������һ������ǵ������Ұ�"

		};
	}
	
	public static String[] getXingStr()
	{
		return new String[]{
				"��ѽ����һ���������ң�",
				"����������һ�����Ǵ�����ǰ�ɹ���",
				"���ǣ��㲻Ҫ�ܣ�",
				"���Ǳ���������ͷ���Ѿ���������",
				"�仨������������",
				"�ֱ��������ˣ����Ʊȥ",
				"�����㣬���������еĸ����Ƕ���",
				"�����ң�Ϊʲô��ù��������"

		};
	}
	
	public static String[] getCenterStr()
	{
		return new String[]{
				"���ˣ��������������ˡ�",
				"���ˣ�����������",
				"������ඣ�",
				"���ֻ����������Ұ����ú���",
				"����Ļ���ˣ����������ˣ�",
				"���ڿ����ˣ�����������",
				"С�����Ҹ��㽲��������",
				"�쵼��Ҫ����ɶ��"
		};
	}
}
