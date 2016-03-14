package org.leadfar.raiden.model.firestrategy;

import org.leadfar.raiden.model.Direction;
import org.leadfar.raiden.model.FireStrategy;
import org.leadfar.raiden.model.gameobjects.bullets.LittleBullets;
import org.leadfar.raiden.model.gameobjects.bullets.SilverBullets;

public class SingleGunStrategy implements FireStrategy {
	@Override
	public void fire(int x ,int y) {
		new LittleBullets(x, y,Direction.U);

	}

}
