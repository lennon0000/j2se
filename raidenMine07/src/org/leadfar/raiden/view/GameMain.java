package org.leadfar.raiden.view;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import org.leadfar.raiden.model.gameobjects.Hero;
import org.leadfar.raiden.model.Game;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class GameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				GameMain thisClass = new GameMain();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				center(thisClass); // ע��д��thisClass

			}
			
		});
	}

	/**
	 * This is the default constructor
	 */
	public GameMain() {
		super();
		initialize();
	}

	public static void center(JFrame frame) {
		double wideth = Toolkit.getDefaultToolkit().getScreenSize().getWidth(); // ��ȡ��Ļ�Ĵ�С
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight(); // ��ȡ��Ļ�Ĵ�С
		frame.setLocation((int) (wideth - frame.getWidth()) / 2,
				(int) (height - frame.getHeight()) / 2);// ���¶�frame��λ��
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 600);
		this.setBackground(Color.lightGray);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("�׵�һ��");
		Game.GetInstance().init();
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent e) {
				Game.GetInstance().notifyHeroKeyReleased(e.getKeyCode());
			}

			public void keyPressed(java.awt.event.KeyEvent e) {

				GamePanel gp = (GamePanel) GameMain.this.getJContentPane();

				Game.GetInstance().notifyHeroKeyPressed(e.getKeyCode());
			}
		});
		new Thread() {
			public void run() {
				while (true) {
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new GamePanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setName("");

		}
		return jContentPane;
	}

}
