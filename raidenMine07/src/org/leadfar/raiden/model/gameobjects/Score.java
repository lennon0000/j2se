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

public class Score extends GameObjects {
	private GameObjects go;
	private int score;
	// private int maxLife;
	
	public Score() {
		this.wideth = 100;
		this.height = 100;
		this.x = 30;
		this.y = 30;
		
		// maxLife = go.getLifeValue();
	}

	// private static Image img = null;

	// static{
	//
	// try {
	//
	// img = ImageIO.read(Background.class.getClassLoader()
	// .getResourceAsStream("images/ren.png"));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	@Override
	protected void draw(Graphics g) {

		Color old = g.getColor();
		Font f = g.getFont();
		g.setColor(Color.blue);
		//g.draw3DRect(x, y, this.wideth, this.height, true);
		g.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		g.setColor(Color.yellow);
		g.drawString("Score:"+score, x, y);
		g.setColor(old);
		g.setFont(f);

	//	g.drawImage(img, x - 150, y - 6, 34, 25, null);

		// g.setColor(old);
		// if(go.isDead()){
		// this.died();
		// }

	}
	public void getScore(){
		Enemies.getScore();
	
	}

	@Override
	protected void checkBounds() {
		// TODO Auto-generated method stub
		
	}

	public void addScore(int lifeValue) {
		score+=lifeValue;
	}

}
