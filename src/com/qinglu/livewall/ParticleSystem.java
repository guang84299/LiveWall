package com.qinglu.livewall;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;

public class ParticleSystem {

	private List<Particle> list_click;
	private List<Particle> list_snow;
	private List<Particle> list_line;
	private Bitmap bitmap;
	private int width;
	private int height;

	private long sonw_dt = 0;

	public ParticleSystem(Bitmap bitmap, int width, int height) {
		this.bitmap = bitmap;
		this.width = width;
		this.height = height;
		list_click = new ArrayList<Particle>();
		list_snow = new ArrayList<Particle>();
		list_line = new ArrayList<Particle>();
	}

	public void snow() {
		int num = 60;
		if (list_snow.size() > num)
			return;
		synchronized (list_snow) {
			Particle particle = new Particle(bitmap);
			particle.setType(0);
			particle.setRotationForever(true);
			particle.setPosX(getRand(0, width));
			particle.setPosY(getRand(0, (int) Tools.getX(30)));
			particle.setPosToX(getRand(0, width));
			particle.setPosToY(getRand((int) (height * 0.85), height));
			particle.setRotationFrom(0);
			particle.setRotationTo(360);
			particle.setScaleFromX(getRand(80, 120) / 100f);
			particle.setScaleFromY(particle.getScaleFromX());
			particle.setSpeedX(getRand((int) Tools.getX(5),
					(int) Tools.getX(20)));
			particle.setSpeedY(getRand((int) Tools.getX(5),
					(int) Tools.getX(20)));
			particle.setRotationSpeed(getRand(10, 20));
			particle.setAlphaSpeed(20);

			particle.setLiveTime(getRand(6000, 12000));

			list_snow.add(particle);

		}
	}

	public void click(float x, float y) {
		if (list_click.size() > 50)
			return;
		int num = 18;
		Vec2 tov = new Vec2(x + Tools.getX(60), y + Tools.getX(60));
		synchronized (list_click) {
			for (int i = 0; i < num; i++) {
				Particle particle = new Particle(bitmap);
				particle.setType(1);
				particle.setPosX(x);
				particle.setPosY(y);
				particle.setPosToX(tov.x);
				particle.setPosToY(tov.y);
				particle.setRotationFrom(0);
				particle.setRotationTo(180);
				particle.setScaleFromX(60 / 100f);
				particle.setScaleFromY(particle.getScaleFromX());
				particle.setSpeedX(Tools.getX(10));
				particle.setSpeedY(Tools.getX(10));
				particle.setRotationSpeed(getRand(50, 80));
				particle.setAlphaSpeed(20);

				particle.setLiveTime(1000);

				tov.rotate(new Vec2(x, y), 20);

				list_click.add(particle);
			}
		}
	}

	public void line(float x, float y) {
		if (list_line.size() > 300)
			return;
		synchronized (list_line) {
			Particle particle = new Particle(bitmap);
			particle.setType(2);
			particle.setPosX(x);
			particle.setPosY(y);
			particle.setPosToX(x);
			particle.setPosToY(y);
			particle.setRotationFrom(0);
			particle.setRotationTo(180);
			particle.setScaleFromX(getRand(80, 120) / 100f);
			particle.setScaleFromY(particle.getScaleFromX());
			particle.setSpeedX(Tools.getX(10));
			particle.setSpeedY(Tools.getX(10));
			particle.setRotationSpeed(getRand(50, 80));
			particle.setAlphaSpeed(15);

			particle.setLiveTime(1000);

			list_line.add(particle);

		}
	}

	public int getRand(int start, int end) {
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

	public void update(Canvas canvas, long dt) {
		synchronized (list_click) {
			for (Particle par : list_click) {
				par.update(canvas, dt);
			}
			for (Particle par : list_click) {
				if (!par.isLive()) {
					list_click.remove(par);
					break;
				}
			}
		}

		synchronized (list_snow) {
			for (Particle par : list_snow) {
				par.update(canvas, dt);
			}
			for (Particle par : list_snow) {
				if (!par.isLive()) {
					list_snow.remove(par);
					break;
				}
			}
		}

		synchronized (list_line) {
			for (Particle par : list_line) {
				par.update(canvas, dt);
			}
			for (Particle par : list_line) {
				if (!par.isLive()) {
					list_line.remove(par);
					break;
				}
			}
		}

		sonw_dt += dt;
		if (sonw_dt > 900) {
			sonw_dt = 0;
			snow();
		}
	}
}
