package com.ld32.philosophergame;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
	private static ArrayList<Philosopher> philosphers;
	
	public static ArrayList<Philosopher> getList(){
		if (philosphers == null){
			
		}
		return philosphers;
	}
	
	public static Philosopher Nietzsche(boolean isOpponent){	
		Philosopher p = new Philosopher("Nietzsche", 100,20,Ressources.Nietzsche(),isOpponent);
		p.attacks[3] = Attack.EternalReturn();
		p.attacks[4] = Attack.WilltoPower();
		p.attacks[5] = Attack.Summon‹bermensch();
		return p;
	}
	public static Philosopher Descartes(boolean isOpponent){
		
		Philosopher p = new Philosopher("Descartes", 100,20,Ressources.Descartes(),isOpponent);
		p.attacks[3] = Attack.EternalReturn();
		p.attacks[4] = Attack.WilltoPower();
		p.attacks[5] = Attack.Summon‹bermensch();
		return p;
	}
	

	public Philosopher(String name, int maxhp, int sanity, TextureRegion texture, boolean isOpponent) {
		this.name = name;
		this.maxhp = maxhp;
		this.currenthp = maxhp;
		this.sanity = sanity;
		Sprite s =new Sprite(texture);
		if (!isOpponent) s.flip(true, false);
		sprite = new Image(new TextureRegionDrawable(s));
		//if(isOpponent) sprite.setColor(Color.RED);
		sprite.setScaling(Scaling.fill);
		sprite.setHeight(150);
		sprite.setWidth(sprite.getWidth() * 150/texture.getRegionHeight());
		this.attacks = new Attack[6];
		this.attacks[0] = Attack.AdHominem();
		this.attacks[1] = Attack.Paradox();
		this.attacks[2] = Attack.SelPerption();
	}

	public void doAttack(Attack attack, Philosopher opp) {
		Gdx.app.log("TODO!", "Handle Attack: "+attack.name);
		
	}

	public Attack chooseMove(Philosopher opp) {
		Gdx.app.log("TODO!", "Choose Attack");
		doAttack(new Attack(), opp);	
		return new Attack();
	}
	
	public static Philosopher getRandom() {
		
		return null;
	}

}