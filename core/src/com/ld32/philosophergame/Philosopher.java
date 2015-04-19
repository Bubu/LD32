package com.ld32.philosophergame;

import java.util.ArrayList;
import java.util.Random;

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
	int currentSanity;
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
		p.attacks[5] = Attack.SummonUbermensch();
		return p;
	}
	public static Philosopher Descartes(boolean isOpponent){
		
		Philosopher p = new Philosopher("Descartes", 100,20,Ressources.Descartes(),isOpponent);
		p.attacks[3] = Attack.EternalReturn();
		p.attacks[4] = Attack.WilltoPower();
		p.attacks[5] = Attack.SummonUbermensch();
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

	public String doAttack(Attack attack, Philosopher opp) {
		int damage = (int) Math.ceil(attack.hpDamage + attack.bonus * sanity - attack.malus * opp.sanity);  
		opp.currenthp -= damage;
		opp.currentSanity -= attack.sanityDamage;
		return "It does "+ damage + " damage to " + opp.name + "'s conviction!";
	}

	public void chooseMove(PhilosopherGame game) {
		Random rand = new Random();
		Attack attack = attacks[rand.nextInt(6)];
		String feedback = doAttack(attack, game.player);
		game.fightscreen.playerHealth.setValue(game.player.currenthp);
		game.fightscreen.showAttackInfo(this,attack, feedback);
	}
	
	public static Philosopher getRandom() {
		
		return null;
	}

}