package org.leadfar.raiden.model;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Properties;

import org.leadfar.raiden.model.gameobjects.BloodUpObject;
import org.leadfar.raiden.model.gameobjects.Enemies;
import org.leadfar.raiden.model.gameobjects.FireStrategyChangeObject;
import org.leadfar.raiden.model.gameobjects.Power;
import org.leadfar.raiden.model.gameobjects.enemies.BossA;
import org.leadfar.raiden.model.gameobjects.enemies.EnemiesB;
import org.leadfar.raiden.model.gameobjects.enemies.EnemiesC;
import org.leadfar.raiden.model.gameobjects.enemies.SmallEnemies;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

public class GameObjectDispatcherThread extends Thread {
	private int time;
	private Properties props = new Properties();
	private boolean flag;

	public GameObjectDispatcherThread(int step) {

		try {
			props.load(GameObjectDispatcherThread.class.getClassLoader()
							.getResourceAsStream(
									"config/step_" + step + ".properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String pic = (String) props.get("bg");
		if(pic!=null){
			Game.GetInstance().changeGround(pic);
		}
	}


	

	@Override
	public void interrupt() {
		flag = true;
	}



	public void run() {
		while (!flag) {
			time++;

			String desc = (String) props.get("S" + time);
			if (desc != null) {
				String className = "";
				int count = 1;
				if (desc.indexOf("-") > -1) {
					className = desc.split("-")[0];
					count = Integer.parseInt(desc.split("-")[1]);
				} else {
					className = desc;
				}
				for (int i = 0; i < count; i++) {
					try {
						Class.forName(className).newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
}
