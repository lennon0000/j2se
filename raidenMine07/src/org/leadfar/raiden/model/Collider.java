package org.leadfar.raiden.model;

public interface Collider {
	public void collide(GameObjects go,GameObjects go2,ColliderChain chain);
}
