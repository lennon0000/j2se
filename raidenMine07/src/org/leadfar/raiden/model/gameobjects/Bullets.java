package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObjects;

public abstract class Bullets extends GameObjects {
	//private Hero hero;

	public Bullets(int x, int y, int wideth, int height, int speed,
			int lifeValue, Direction d,boolean good) {
		this.wideth = wideth;
		this.height = height;
		this.x = x - this.wideth / 2;
		this.lifeValue = lifeValue;
		this.y = y;
		this.speed = speed;
		this.d = d;
		this.good = good;
	}

	public Bullets(int x, int y, int wideth, int height, int speed,
			int lifeValue) {
		this(x, y, wideth, height, speed, lifeValue, Direction.U,true);
	}


	@Override
	public void move() {
		switch(d){
		case U:y-=speed;break;
		case D:y+=speed;break;
		case L:x-=speed;break;
		case R:x+=speed;break;
		case LU:y-=speed;x-=speed;break;
		case RU:x+=speed;y-=speed;break;
		case LD:x-=speed;y+=speed;break;
		case RD:x+=speed;y+=speed;break;
		
		}
	}

	protected void checkBounds() {
		if (x < 0 || y < 0 || x + this.wideth > Game.VIEW_WIDTH
				|| y + this.height > Game.VIEW_HEIGHT) {
			this.dead = true;
		}

	}

}
