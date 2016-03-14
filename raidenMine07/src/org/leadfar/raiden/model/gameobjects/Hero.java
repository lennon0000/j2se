package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObjects;
import org.leadfar.raiden.model.firestrategy.DoubleGunStrategy;
import org.leadfar.raiden.model.firestrategy.SingleGunStrategy;
import org.leadfar.raiden.model.gameobjects.bullets.LaserBullets;
import org.leadfar.raiden.model.gameobjects.bullets.LittleBullets;
import org.leadfar.raiden.model.gameobjects.bullets.SilverBullets;

public class Hero extends GameObjects {
	//private Score score;
	private int step = 0;
	private Image img;
	private static FireStrategy fs;
	private static Properties props = new Properties();
	static {
		try {
			props.load(Hero.class.getClassLoader().getResourceAsStream(
					"config/fire_strategy.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hero() {
		
		this.wideth = 80;
		this.height = 100;
		this.x = (Game.VIEW_WIDTH - this.wideth) / 2;
		this.y = (Game.VIEW_HEIGHT - this.height) / 2 + 150;
		this.speed = 25;
		this.lifeValue = 5000;
		//fs = new SingleGunStrategy();
		this.changeFireStrategy();
		
		//new Power(Game.VIEW_WIDTH - 260, Game.VIEW_HEIGHT - 30, 250, 15, this);
		
		try {
			img = ImageIO.read(Background.class.getClassLoader()
					.getResourceAsStream("images/2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int Width() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void checkBounds() {
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

	public void left() {
		x -= speed;
	}

	public void right() {
		x += speed;
	}

	public void forward() {
		y -= speed;
	}

	public void backward() {
		y += speed;
	}

	@Override
	protected void draw(Graphics g) {// 注意：重写了父类的paint方法，下边具体写时时针对传入参数进行操作，即g，g.什么
		checkBounds();
		Color old = g.getColor();
		g.setColor(Color.red);
		g.drawImage(img, x, y, wideth, height, null);
		g.setColor(old);
		new Power(Game.VIEW_WIDTH - 260, Game.VIEW_HEIGHT - 30, 250, 15, this);
		//score = new Score();
	}

	public void fire() {
		fs.fire(x + wideth / 2, y);

	}

	public void addLifeValue(int inc) {
		this.lifeValue += inc;
		if (this.lifeValue > 5000) {
			this.lifeValue = 5000;
		}
		if (this.lifeValue < 0) {
			this.died();
			Game.GetInstance().reborn();
		}
		// System.out.println(this.lifeValue);

	}

	public void changeFireStrategy() {
		String className = (String) props.get("S" + step);
		if(className==null)return;
		try {
			fs = (FireStrategy) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		step++;
	}


}
