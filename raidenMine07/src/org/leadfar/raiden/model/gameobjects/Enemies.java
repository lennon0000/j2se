package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.util.Random;
import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObjects;

public abstract class Enemies extends GameObjects {
	// private Hero hero;
	//private Power power = new Power(x, y, wideth, HEIGHT, this);
	public static int score;

	public Enemies(int wideth, int height, int speed,
			int lifeValue) {
		Random r = new Random();
		
		this.x = r.nextInt(Game.VIEW_WIDTH);
		this.y = r.nextInt(Game.VIEW_HEIGHT);
		this.lifeValue = lifeValue;
		this.wideth = wideth;
		this.height = height;
		this.speed = speed;
		this.d = Direction.L;
		
	}

//	public Enemies(int x, int y, int wideth, int height, int speed,
//			int lifeValue) {
//		this(x, y, wideth, height, speed, lifeValue, Direction.D);
//	}

	public static int getScore() {
		return score;
	}

//	public void setScore(int score) {
//		this.score = score;
//	}

	@Override
	public void move() {
		Direction[] ds = Direction.values();
		if (new Random().nextInt(40) > 35) {

			this.d = ds[new Random().nextInt(ds.length)];
			
		}
		switch (d) {
		case U:
			y -= speed;
			break;
		case D:
			y += speed;
			break;
		case L:
			x -= speed;
			break;
		case R:
			x += speed;
			break;
		case LU:
			y -= speed;
			x -= speed;
			break;
		case RU:
			x += speed;
			y -= speed;
			break;
		case LD:
			x -= speed;
			y += speed;
			break;
		case RD:
			x += speed;
			y += speed;
			break;

		}
		if(new Random().nextInt(40) > 35){
			this.fire();
		}
		checkBounds();
		//checkPower();
	}
	protected void explode(){
		new Exploder(x,y);
	}
	protected void checkBounds() {
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		if (x + this.wideth > Game.VIEW_WIDTH) {
			x = Game.VIEW_WIDTH - this.wideth;
		}
		if (y + this.height > Game.VIEW_HEIGHT-200) {
			y = Game.VIEW_HEIGHT - this.height-200;
		}

	}



	@Override
	protected abstract void draw(Graphics g);

//	protected void checkPower() {
//		if (this.lifeValue < 0) {
//			this.dead = true;
//		}
//
//	}
	
	public Enemies() {

	}

	@Override
	public void addLifeValue(int inc) {
		this.lifeValue+=inc;
		if (this.lifeValue < 0) {
		this.died();
		explode();
		}
	}

	protected abstract void fire();

}
