package com.ld32.philosophergame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Philosopher {
	int maxhp;
	int currenthp;
	int sanity;
	Image sprite;
	Attack[] attacks;

	public Philosopher(int maxhp, int sanity, Texture texture) {
		this.maxhp = maxhp;
		this.currenthp = maxhp;
		this.sanity = sanity;
		this.sprite = new Image(texture);
		this.attacks = new Attack[4];
		this.attacks[0] = Attack.Confuse();
	}

}
