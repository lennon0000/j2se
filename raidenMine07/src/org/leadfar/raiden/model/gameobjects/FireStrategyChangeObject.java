package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObjects;

public class FireStrategyChangeObject extends GameObjects {
	
	private Color color = Color.RED;

	private static Image img = null;
	static{
		try {
			img = ImageIO.read(Background.class.getClassLoader().getResourceAsStream("images/touxiang.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FireStrategyChangeObject() {
		Random r = new Random();
		this.wideth = 40;
		this.height = 40;
		this.x = r.nextInt(Game.VIEW_WIDTH - this.wideth);
		this.y = r.nextInt(Game.VIEW_HEIGHT - this.height);

	}

	@Override
	protected void checkBounds() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void draw(Graphics g) {
		Color old = g.getColor();
		if (color == Color.RED) {
			color = Color.GREEN;
		}
		else {
			color = Color.RED;
		}
		g.setColor(color);
		//g.fillOval(x, y, wideth, height);
		g.drawImage(img, x-10, y, wideth, height, null);
		g.setColor(old);
		
		
		checkBounds();

	}

}
