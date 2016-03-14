package org.leadfar.raiden.model.colliders;

import org.leadfar.raiden.model.Collider;
import org.leadfar.raiden.model.ColliderChain;
import org.leadfar.raiden.model.GameObjects;
import org.leadfar.raiden.model.gameobjects.BloodUpObject;
import org.leadfar.raiden.model.gameobjects.Bullets;
import org.leadfar.raiden.model.gameobjects.Enemies;
import org.leadfar.raiden.model.gameobjects.FireStrategyChangeObject;
import org.leadfar.raiden.model.gameobjects.Hero;
import org.leadfar.raiden.model.gameobjects.enemies.SmallEnemies;

import com.sun.net.httpserver.Filter.Chain;

public class BulletsBulletsCollider implements Collider {

	@Override
	public void collide(GameObjects go, GameObjects go2, ColliderChain chain) {
		if (go instanceof Bullets && go2 instanceof Bullets&& !go.isDead() && !go2.isDead()
				&& go.isGood()&& !go2.isGood()) {
			if (!go.getBounds().intersection(go2.getBounds()).isEmpty()) {
				
				go.died();
				
				go2.died();
			} 

		}else {
			chain.doCollide(go, go2);
		}

	}

}
