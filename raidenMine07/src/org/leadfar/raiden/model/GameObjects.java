package org.leadfar.raiden.model;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public abstract class GameObjects extends JPanel {

	protected int x;
	protected int y;
	protected int wideth;
	protected int height;
	protected int speed;
	protected boolean dead;
	protected int lifeValue;
	protected Direction d;
	protected boolean good;
	public GameObjects() {
		Game.GetInstance().addGameObjects(this);
	}

	public boolean isDead() {
		return dead;
	}

	public void paint(Graphics g) {
		this.move();
		this.checkBounds();
		this.draw(g);
	}

	public void move() {
		
	}
	public void died(){
		this.dead = true;
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,wideth,height);
	}
	public int getLifeValue(){
		return this.lifeValue;
	}
	public void addLifeValue(int inc) {
		this.lifeValue+=inc;
	}
	protected abstract void draw(Graphics g);

	protected abstract void checkBounds();
//	protected  void checkPower() {
//	}

	public boolean isGood() {
		return good;
	}

//	public void addLifeValue(int inc, int score) {
//		this.lifeValue+=inc;
//	this.score +=score;
//		
//	}
	
}
