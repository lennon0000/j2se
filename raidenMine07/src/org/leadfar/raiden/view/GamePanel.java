package org.leadfar.raiden.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.leadfar.raiden.model.Game;

public class GamePanel extends JPanel {
	public GamePanel() {
		
	}

	@Override
	public void paint(Graphics g) {// ע�⣺��д�˸����paint�������±߾���дʱʱ��Դ���������в�������g��g.ʲô
		
		Game.GetInstance().paint(g);
		
	}

}
