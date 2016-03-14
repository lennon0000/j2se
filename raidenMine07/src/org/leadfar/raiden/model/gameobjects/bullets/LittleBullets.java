package org.leadfar.raiden.model.gameobjects.bullets;

import java.awt.Color;
import java.awt.Graphics;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.gameobjects.Bullets;

public class LittleBullets extends Bullets {

	public LittleBullets(int x, int y,Direction d) {
		super(x, y,10,10,20,40,d,true);
		// TODO Auto-generated constructor stub
	}
	public LittleBullets(int x, int y,Direction d,boolean good) {
		super(x, y,10,10,20,40,d,good);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		Color old=g.getColor();
		g.setColor(Color.yellow);
		g.fillOval(x, y, wideth, height);
		g.setColor(old);
		checkBounds();
	}
}
