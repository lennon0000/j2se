package org.leadfar.raiden.model.gameobjects.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.firestrategy.SingleGunStrategy;
import org.leadfar.raiden.model.gameobjects.Enemies;
import org.leadfar.raiden.model.gameobjects.Hero;
import org.leadfar.raiden.model.gameobjects.Power;
import org.leadfar.raiden.model.gameobjects.bullets.LaserBullets;
import org.leadfar.raiden.model.gameobjects.bullets.LittleBullets;

public class EnemiesC extends Enemies {
	private int max;
	private static Image img = null;
	static {
		try {
			img = ImageIO.read(Background.class.getClassLoader()
					.getResourceAsStream("images/enemyC.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public EnemiesC() {
		
		super(30, 30, 14, 2500);

		// TODO Auto-generated constructor stub
		max = this.lifeValue;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, wideth, height, null);
	
//		super.checkBounds();
//		checkPower();
		
		Color old = g.getColor();

		g.setColor(Color.white);
		g.draw3DRect(x, y-20,25, 5, true);
		int w = (int) (this.getLifeValue() / (max * 1.0) * 25);
		g.setColor(Color.yellow);
		g.fill3DRect(x, y-20, w, 5, true);
		g.setColor(Color.GREEN);
		g.drawString("" + this.getLifeValue(), x-40, y-12);
		g.setColor(old);
	}
	
//	private void SmallEnemies() {
//		new Power(100, 100 , 250, 15, this);
//	}

	public void getRandomDirection(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Override
//	public void move() {
//		Direction[] ds = Direction.values();
//		if (new Random().nextInt(40) > 35) {
//			
//			this.d = ds[new Random().nextInt(ds.length)];
//			
//		}
//		super.move();
//	}

	@Override
	protected void fire() {
		if(x<200){
			new LaserBullets(x+wideth/2, y,Direction.RD,false);
		}
		if(x>400){
			new LaserBullets(x+wideth/2, y,Direction.LD,false);
		}
		if(x>200&&x<400){
			new LaserBullets(x+wideth/2, y,Direction.D,false);
		}
		
	}

//	@Override
//	protected void checkBounds() {
//		if (x < 0) {
//			x = 0;
//		}
//		if (y < 0) {
//			y = 0;
//		}
//		if (x + this.wideth > Game.VIEW_WIDTH) {
//			x = Game.VIEW_WIDTH - this.wideth;
//		}
//		if (y + this.height > Game.VIEW_HEIGHT) {
//			y = Game.VIEW_HEIGHT - this.height;
//		}
//	}
	
}
