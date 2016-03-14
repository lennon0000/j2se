package org.leadfar.raiden.model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Background {

	private Image img = null;
	public int oy;

	public Background() {

		try {

			img = ImageIO.read(Background.class.getClassLoader()
					.getResourceAsStream("images/bg.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Background(String pic) {

		try {

			img = ImageIO.read(Background.class.getClassLoader()
					.getResourceAsStream("images/"+pic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		if (oy > Game.VIEW_HEIGHT) {
			oy = 0;
		}
		oy++;
		oy = oy + 3;
		g.drawImage(img, 0, -(Game.VIEW_HEIGHT - oy), Game.VIEW_WIDTH,
				Game.VIEW_HEIGHT, null);
		g.drawImage(img, 0, oy, Game.VIEW_WIDTH, Game.VIEW_HEIGHT, null);

	}
}
