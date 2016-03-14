package org.leadfar.raiden.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.leadfar.raiden.model.gameobjects.Hero;
import org.leadfar.raiden.model.gameobjects.Score;

public class Game {
	public static final int VIEW_WIDTH = 794;
	public static final int VIEW_HEIGHT = 568;
	private Hero hero;
	private Background bg;
	private boolean left, right, forward, backward, fired;
	private List<GameObjects> gameObjects = new ArrayList<GameObjects>();
	private GameStatus status = GameStatus.WAITTING;
	private static final Game game = new Game();
	private int step;
	public static int HERO_LIFE = 3;
	private Score score;

	private GameObjectDispatcherThread gdt;

	private Game() {

	}

	public void init() {
		hero = new Hero();
		score = new Score();
		bg = new Background();

	}

	public void addGameObjects(GameObjects go) {
		this.gameObjects.add(go);
	}

	public static Game GetInstance() {
		return game;
	}

	public void notifyHeroKeyPressed(int keyCode) {

		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			forward = true;
			break;
		case KeyEvent.VK_DOWN:
			backward = true;
			break;
		case KeyEvent.VK_CONTROL:
			fired = true;
			break;
		case KeyEvent.VK_ENTER:

			start();
			break;
		}

	}

	private void start() {
		if (status == GameStatus.WAITTING || status == GameStatus.SUCCESS) {
			status = GameStatus.RUNNUNG;
			step++;
			gdt = new GameObjectDispatcherThread(step);
			gdt.start();
		}

	}

	public void notifyHeroKeyReleased(int keyCode) {

		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			forward = false;
			break;
		case KeyEvent.VK_DOWN:
			backward = false;
			break;
		case KeyEvent.VK_CONTROL:
			fired = false;
			break;
		}
	}

	public void heroMove() {
		if (status == GameStatus.RUNNUNG) {
			if (left) {
				hero.left();
			}
			if (right) {
				hero.right();
			}
			if (forward) {
				hero.forward();
			}
			if (backward) {
				hero.backward();
			}
			if (fired) {
				hero.fire();
			}
		}

	}

	public void paint(Graphics g) {

		bg.paint(g);

		for (int i = 0; i < gameObjects.size(); i++) {
			GameObjects go = gameObjects.get(i);
			go.paint(g);

			for (int j = 0; j < gameObjects.size(); j++) {
				GameObjects go2 = gameObjects.get(j);
				new ColliderChain().doCollide(go, go2);

			}

			if (go.isDead()) {
				gameObjects.remove(go);
			}
		}
		heroMove();
		infor(g);
	}

	public void infor(Graphics g) {

		Color old = g.getColor();
		Font f = g.getFont();
		g.setFont(new Font("宋体", Font.BOLD, 50));
		g.setColor(Color.white);

		if (status == GameStatus.WAITTING) {

			g.drawString("请按下[ENTER]开始游戏", 120, 200);

		}
		if (status == GameStatus.SUCCESS) {

			g.drawString("闯关成功，按下【ENTER】继续", 120, 200);

		}
		if (status == GameStatus.FAIL) {

			g.drawString("GAME OVER", 150, 200);

		}
		g.setFont(f);
		g.setColor(old);
		

	}

	public void success() {
		status = GameStatus.SUCCESS;
		gdt.interrupt();
		//start();
		this.gameObjects.clear();
		this.gameObjects.add(hero);

	}

	public void reborn() {
		if (status == GameStatus.RUNNUNG) {
			hero = new Hero();
			Game.HERO_LIFE--;
			if (Game.HERO_LIFE == 0) {
				fail();
			}
		}

	}

	private void fail() {
		status = GameStatus.FAIL;

	}

	public void changeGround(String pic) {
		bg = new Background(pic);

	}

	public void setScore(int lifeValue) {
		score.addScore(lifeValue);
	}
}
