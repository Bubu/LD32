package com.ld32.philosophergame;

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

	public Philosopher(int maxhp, int sanity, Texture texture) {
		this.maxhp = maxhp;
		this.currenthp = maxhp;
		this.sanity = sanity;
		Sprite s =new Sprite(texture);
		s.flip(true, false);
		sprite = new Image(new TextureRegionDrawable(s));
		//sprite.setColor(Color.RED);
		sprite.setScaling(Scaling.fill);
		sprite.setHeight(150);
		sprite.setWidth(sprite.getWidth() * 150/texture.getHeight());
		this.attacks = new Attack[4];
		this.attacks[0] = Attack.Confuse();
		this.attacks[1] = Attack.SelPerption();
	}

}
