package org.leadfar.raiden.model.gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.leadfar.raiden.model.Background;
import org.leadfar.raiden.model.GameObjects;

public class  Exploder extends GameObjects {


	public Exploder(int x, int y) {
		this.x = x;
		this.y = y;
		this.wideth = 32;
		this.height = 32;
	}

	@Override
	protected void checkBounds() {
		// TODO Auto-generated method stub

	}
	private static Image[] imgs = new Image[10] ; 
	private int index;
	static{
		for(int i = 0;i < imgs.length;i++){
			try {
				imgs[i] = ImageIO.read(Background.class.getClassLoader()
						.getResourceAsStream("images/burst"+i+".gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
//	public void Exploder(int x,int y){
//		this.x = x;
//		this.y = y;
//		this.wideth = 32;
//		this.height = 32;
//	}
	
	@Override
	protected void draw(Graphics g) {
		if(index<imgs.length){
			g.drawImage(imgs[index++], x, y, wideth, height,null);
		}else {
			this.died();
		}
		
		
	}

}
