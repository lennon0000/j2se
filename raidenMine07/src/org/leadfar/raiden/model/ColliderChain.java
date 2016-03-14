package org.leadfar.raiden.model;

import org.leadfar.raiden.model.colliders.BulletsBulletsCollider;
import org.leadfar.raiden.model.colliders.EnemisBulletsCollider;
import org.leadfar.raiden.model.colliders.HeroBloodUpObjectCollider;
import org.leadfar.raiden.model.colliders.HeroBulletsCollider;
import org.leadfar.raiden.model.colliders.HeroEnemiesCollider;
import org.leadfar.raiden.model.colliders.HeroFireStrategyChangeObjectCollider;

public class ColliderChain {

	private static class Node {
		Collider c;
		Node next;

		public Node(Collider c) {
			this.c = c;
		}
	}

	private static Node head = new Node(null);
	private static Node current = head;
	static {
		head.next = new Node(new HeroFireStrategyChangeObjectCollider());

		head.next.next = new Node(new HeroBloodUpObjectCollider());
		
		head.next.next.next = new Node(new EnemisBulletsCollider());
		
		head.next.next.next.next = new Node(new HeroBulletsCollider());
		
		head.next.next.next.next.next = new Node(new HeroEnemiesCollider());
		
		head.next.next.next.next.next.next = new Node(new BulletsBulletsCollider());
	}

	public ColliderChain() {
		current = head;
	}

	public void doCollide(GameObjects go, GameObjects go2) {
		current = current.next;
		if (current != null) {
			current.c.collide(go, go2, this);
		}
	}
}
