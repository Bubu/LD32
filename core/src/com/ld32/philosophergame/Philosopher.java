package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Philosopher {
	int maxhp;
	int currenthp;
	int sanity;
	Image sprite;
	Attack[] attacks;
	String name;

	public Philosopher(String name, int maxhp, int sanity, Texture texture, boolean isOpponent) {
		this.name = name;
		this.maxhp = maxhp;
		this.currenthp = maxhp;
		this.sanity = sanity;
		Sprite s =new Sprite(texture);
		if (!isOpponent) s.flip(true, false);
		sprite = new Image(new TextureRegionDrawable(s));
		if(isOpponent) sprite.setColor(Color.RED);
		sprite.setScaling(Scaling.fill);
		if(!isOpponent || true) {
			sprite.setHeight(150);
			sprite.setWidth(sprite.getWidth() * 150/texture.getHeight());
		}
		this.attacks = new Attack[4];
		this.attacks[0] = Attack.Confuse();
		this.attacks[1] = Attack.SelPerption();
	}

	public void doAttack(Attack attack) {
		Gdx.app.log("Attack", attack.name);
		
	}

}