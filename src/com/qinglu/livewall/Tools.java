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
				"主人，你起的真早！",
				"主人，该吃早饭了呢？",
				"主人，早饭吃了什么呀？",
				"小主，早期的鸟儿有虫吃，你是那只鸟吗？",
				"小主，我要吃烧饼、油条",
				"小主，我还要吃面包加芝士",
				"小主，早饭没吃就出门了吧，好辛苦",
				"孩子，今天的工作多吗？",
				"主人，昨天有个SB欺负我了，我今早还难受呢",
				"报告：昨晚我做了个湿湿的X梦",
				"主人，三天后我会大变身，记得升级我啊"

		};				
		return morning;
	}
	
	public static String[] getNoonStr()
	{		
		String[] noon = new String[]{
				"主人，你要不要睡个午觉呢！",
				"主人，该吃午饭了呢？",
				"主人，中午吃了啥呀？",
				"听说，中午和午睡最配哦",
				"看，你午饭的米粒还在嘴边呢",
				"领导，中午就别让我跑了吧",
				"主人，三天后我会大变身，记得升级我啊"
		};		
		return noon;
	}
	public static String[] getNightStr()
	{				
		String[] night = new String[]{
				"主人，你要早睡早起啊！",
				"主人，大深夜的，你约跑？",
				"主人，不要忘记吃晚饭啊！",				
				"主人，晚饭吃的啥啊？",
				"主人，晚饭少吃点更健康哦",
				"走，散步去",
				"天黑了，该约啦",
				"主人，这黑灯瞎火的，你要干啥",
				"小主，看，有流星",
				"工作一天了，和我玩玩呗",
				"主人，今天有个二逼欺负我，你要做主啊",
				"主人，三天后我会大变身，记得升级我啊"
		};
		
		return night;
	}
	
	public static String[] getIdleStr()
	{
		return new String[]{
				"好无聊哦！主人，带我溜达一会吧？",
				"呵呵，现在精力好充沛啊，好想跳个舞呢！",
				"哇！星星好美丽啊！",
				"主人，快来看看我吧！",
				"小主，看，有星星。。。 ",
				"主人，快来挠挠我，我痒！",
				"再不来，我就躲起来了哦",
				"再不来，我真走了哦。。。",
				"主人，三天后我会大变身，记得升级我啊"
	
		};
	}
	
	public static String[] getWalkStr()
	{
		return new String[]{
				"努力跑步，我要变得更快！",
				"我是一只热爱运动，热爱生活的小猫。。",
				"主人，快来跟着我跑吧！",				
				"我跑，我跑，我跑跑跑！",
				"我是一只追星星的猫。",
				"我是来之星星的萌猫",
				"我追着星星，追着诗和远方",
				"主人，三天后我会大变身，记得升级我啊"
		};
	}
	
	public static String[] getRunStr()
	{
		return new String[]{
				"无聊，去那边看看！",
				"走一圈看看有啥好玩的不？",
				"主人，我都无聊的瞎逛游半天了。。",
				"主人，我都瞎逛游半天了。",			
				"大人，让俺歇会吧",
				"小主，我跑的都湿了，我湿了",
				"军爷，小的实在跑不动了",
				"领导，你这是要累死我啊",
				"老师，这样体罚我至于嘛",
				"老大，留点力气让我抓老鼠吧",
				"看我的速度，其实我是母老虎",
				"听说，这样跑三天，我的体型更性感",
				"主人，三天后我会大变身，记得升级我啊"

		};
	}
	
	public static String[] getSleepStr()
	{
		return new String[]{
				"哈哈，我要睡个香碰碰的觉，不要打扰我啊。。",
				"好困啊！",
				"主人，我好累了，让我睡会。。。",
				"好累，让我睡死算了",
				"我好像梦见TA了哦。。。",
				"春困，秋乏，夏盹，冬眠",
				"听说，睡足三天，我的体力就爆表了",
				"主人，三天后我会大变身，记得升级我啊"

		};
	}

	public static String[] getDanceStr()
	{
		return new String[]{
				"主人，我的舞跳得棒不棒啊？",
				"主人，让我为你跳只舞吧！",
				"主人，看我的舞漂亮不？我可爱不？",
				"这是喵星人才会跳的舞哦",
				"我是喵星人",
				"汪星人会跳舞吗？",
				"我要跳舞，谁来PK?",
				"听说，三天后我就能学会钢管舞哦",
				"主人，三天后我会大变身，记得升级我啊"

		};
	}
	
	public static String[] getKanrenStr()
	{
		return new String[]{
				"不要看我了，人家都害羞了。。。",
				"主人，你看我可爱不？",
				"好开心啊！",
				"看我干什么",
				"看我？再看，我就发飙了哦",
				"人家是母的，会不好意思滴",
				"主人，我很快就会有新本领了哦",
				"听说，三天后我的身材会更好哦",
				"主人，三天后我会大变身，记得升级我啊"

		};
	}
	
	public static String[] getXingStr()
	{
		return new String[]{
				"哎呀！又一颗星星砸我！",
				"好美丽啊，一颗流星从我眼前飞过！",
				"星星，你不要跑！",
				"星星别砸我啦，头上已经三个包啦",
				"翠花，看，有星星",
				"又被星星砸了，买彩票去",
				"我算算，被星星砸中的概率是多少",
				"又砸我？为什么倒霉的总是我"

		};
	}
	
	public static String[] getCenterStr()
	{
		return new String[]{
				"主人，你终于来看我了。",
				"主人，想死你啦！",
				"主人来喽！",
				"玩手机，还是玩我啊，好害羞",
				"是屏幕亮了，还是天亮了？",
				"终于开门了，憋闷死我了",
				"小主，我给你讲个段子呗",
				"领导，要来点啥？"
		};
	}
}
