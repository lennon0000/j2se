package org.leadfar.raiden.model.gameobjects.bullets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.gameobjects.Bullets;

public class SilverBullets extends Bullets {
	private static Image img = null;
	static{
		try {
			img = ImageIO.read(Background.class.getClassLoader().getResourceAsStream("images/daodan.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SilverBullets(int x, int y,Direction d) {
		super(x, y,15,30,15,120,d,true);
		
		// TODO Auto-generated constructor stub
	}
	public SilverBullets(int x, int y,Direction d,Boolean good) {
		super(x, y,15,30,15,120,d,good);
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, wideth, height, null);
		
		checkBounds();
	}
}
