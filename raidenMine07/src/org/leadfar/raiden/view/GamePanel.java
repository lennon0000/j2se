package org.leadfar.raiden.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.leadfar.raiden.model.Game;

public class GamePanel extends JPanel {
	public GamePanel() {
		
	}

	@Override
	public void paint(Graphics g) {// 注意：重写了父类的paint方法，下边具体写时时针对传入参数进行操作，即g，g.什么
		
		Game.GetInstance().paint(g);
		
	}

}
