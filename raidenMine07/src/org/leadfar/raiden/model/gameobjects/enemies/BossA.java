package org.leadfar.raiden.model.gameobjects.enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.Game;
import org.leadfar.raiden.model.gameobjects.Enemies;
import org.leadfar.raiden.model.gameobjects.Exploder;
import org.leadfar.raiden.model.gameobjects.bullets.LittleBullets;
import org.leadfar.raiden.model.gameobjects.bullets.SilverBullets;

public class BossA extends Enemies {
	private Image img;
	private int fireTime;
	private int max;
	public BossA(){
		super(300,170,7,20000);
		try {
			img = ImageIO.read(Background.class.getClassLoader()
					.getResourceAsStream("images/bossA.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		max = this.lifeValue;
		this.x = Game.VIEW_WIDTH/2-this.wideth/2;
		this.y = 100;
		
		
	}
	@Override
	protected void draw(Graphics g) {
		
		
		g.drawImage(img, x, y, wideth, height, null);
		
		Color old = g.getColor();

		g.setColor(Color.white);
		g.draw3DRect(x, y-20,75,15, true);
		
		int w = (int) ((this.getLifeValue() / (max * 1.0)) * 75);
		
		g.setColor(Color.yellow);
		g.fill3DRect(x, y-20, w, 15, true);
		
		g.setColor(Color.GREEN);
		g.drawString("Power£º" + this.getLifeValue(), x-90 , y-8);
		g.setColor(old);

	}

	@Override
	protected void fire() {
		fireTime++;
		if(this.fireTime == 5){
			
			new SilverBullets(x+wideth/2, y+this.height/2,Direction.LD,false);
			new SilverBullets(x+wideth/2, y+this.height/2,Direction.D,false);
			new SilverBullets(x+wideth/2, y+this.height/2,Direction.RD,false);
			fireTime = 0;
			return;
		}
		new LittleBullets(x+wideth/2, y+this.height/2,Direction.LD,false);
		new LittleBullets(x+wideth/2, y+this.height/2,Direction.D,false);
		new LittleBullets(x+wideth/2, y+this.height/2,Direction.RD,false);



	}
	@Override
	public void move() {
		if(this.x+this.wideth>=Game.VIEW_WIDTH){
			this.d=Direction.L;
		}
		if(x<=0){
			this.d=Direction.R;
		}
		switch (d) {
		
		case L:
			x -= speed;
			break;
		case R:
			x += speed;
			break;
		
		}

		if (new Random().nextInt(40) > 30) {
			this.fire();
		}

	}
	
	
	@Override
	
		protected void explode() {
			Random r=new Random();
			
//			
//			for(int i=0;i<7;i++){
//				for(int j=0;j<7;j++){
//					new Exploder(x+j*32,y+i*32);
//				}
//				
//			}
			for(int i = 0;i<18;i++){
				
				new Exploder(r.nextInt(300)+x,r.nextInt(177)+y );
			}
			
		}
	@Override
	public void died() {
		this.dead = true;
		Game.GetInstance().success();
	}
	
	}



