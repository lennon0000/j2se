package org.leadfar.raiden.model.colliders;

import org.leadfar.raiden.model.Collider;
import org.leadfar.raiden.model.ColliderChain;
import org.leadfar.raiden.model.GameObjects;
import org.leadfar.raiden.model.gameobjects.BloodUpObject;
import org.leadfar.raiden.model.gameobjects.Enemies;
import org.leadfar.raiden.model.gameobjects.FireStrategyChangeObject;
import org.leadfar.raiden.model.gameobjects.Hero;
import org.leadfar.raiden.model.gameobjects.enemies.SmallEnemies;

import com.sun.net.httpserver.Filter.Chain;

public class HeroEnemiesCollider implements Collider {

	@Override
	public void collide(GameObjects go, GameObjects go2, ColliderChain chain) {
		if (go instanceof Hero && go2 instanceof Enemies
				&& !go.isDead() && !go2.isDead()) {
			if (!go.getBounds().intersection(go2.getBounds()).isEmpty()) {
				//go2.died();
				// ((Hero)go).changeFireStrategy();
				go.addLifeValue(-20);
			} else {
				chain.doCollide(go, go2);
			}

		} else if (go2 instanceof Hero
				&& go instanceof Enemies && !go.isDead()
				&& !go2.isDead()) {
			collide(go2, go, chain);
		} else {
			chain.doCollide(go, go2);
		}

	}

}
