package org.leadfar.raiden.model.gameobjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.GameObjects;

public class Power extends GameObjects {
	private GameObjects go;
	private int maxLife;
	public Power(int x,int y,int wideth,int height,GameObjects go){
		
		this.x = x;
		this.y = y;
		this.wideth = wideth;
		this.height = height;
		this.go = go;
		maxLife = go.getLifeValue();
	}
	@Override
	protected void checkBounds() {
		// TODO Auto-generated method stub

	}

	private static Image img = null;

	static{

		try {

			img = ImageIO.read(Background.class.getClassLoader()
					.getResourceAsStream("images/ren.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void draw(Graphics g) {
		if(go.getLifeValue()>0){
			Color old = g.getColor();
			
			g.setColor(Color.white);
			
			g.draw3DRect(x, y, this.wideth, this.height, true);
			int w = (int) (go.getLifeValue()/(maxLife*1.0) *this.wideth);
			g.setColor(Color.yellow);
			g.fill3DRect(x, y, w, this.height, true);
			
			g.setColor(Color.GREEN);
			Font f = g.getFont();
			g.setFont(new Font("ËÎÌå", Font.BOLD, 13));
			g.drawString("Power£º"+ go.getLifeValue(),x-85, y+12);
			
			g.setColor(Color.red);
			g.drawString("¡Á"+Game.HERO_LIFE,x-110,  y+12);
			
			g.drawImage(img, x-150, y-6, 34, 25, null);
			
			
//			g.setColor(old);
//			if(go.isDead()){
//				this.died();
//			}
		}
		
		

	}

}
