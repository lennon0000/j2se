package org.leadfar.raiden.model.firestrategy;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.gameobjects.bullets.LaserBullets;
import org.leadfar.raiden.model.gameobjects.bullets.LittleBullets;
import org.leadfar.raiden.model.gameobjects.bullets.SilverBullets;

public class ShotgunStrategy implements FireStrategy {
	
	@Override
	public void fire(int x ,int y) {
		new LaserBullets(x, y,Direction.U);
		new LaserBullets(x, y,Direction.LU);
		new LaserBullets(x, y,Direction.RU);

	}

}
