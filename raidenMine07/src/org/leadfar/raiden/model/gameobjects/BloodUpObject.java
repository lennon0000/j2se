package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObjects;

public class BloodUpObject extends GameObjects {
	private Color color = Color.RED;
	private Direction d;

	public BloodUpObject() {

		Random r = new Random();
		this.wideth = 40;
		this.height = 40;
		this.x = r.nextInt(Game.VIEW_WIDTH - this.wideth);
		this.y = r.nextInt(Game.VIEW_HEIGHT - this.height);
		this.speed = 1;
		this.d = Direction.U;
		this.lifeValue = r.nextInt(2000) + 500;
	}

	@Override
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
		if (y + this.height > Game.VIEW_HEIGHT) {
			y = Game.VIEW_HEIGHT - this.height;
		}

	}

	@Override
	protected void draw(Graphics g) {

		Color old = g.getColor();
		if (color == Color.RED) {
			color = Color.GREEN;
		} else {
			color = Color.RED;
		}
		g.setColor(color);
		g.fillOval(x, y, wideth, height);
		g.setColor(Color.white);
		g.drawString("+" + this.lifeValue, x + 30, y + 30);
		g.setColor(old);

	}

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

	}
}