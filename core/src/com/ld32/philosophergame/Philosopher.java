package com.ld32.philosophergame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Philosopher {
	public static enum Philosophers {Socrates, Descartes, Nietzsche, Schopenhauer, Kirkegaard, Hobbes, Freud, Kant, Wittgenstein};
	int maxhp;
	int currenthp;
	int sanity;
	Image sprite;
	Attack[] attacks;
	String name;
	String[] phrases;
	int currentSanity;

	static String n = System.getProperty("line.separator");
	
	public static Philosopher createPhilosopher(Philosophers phil, boolean isOpponent){
		switch(phil){
		case Descartes:
			return Descartes(isOpponent);
		case Socrates:
			return Socrates(isOpponent);
		case Nietzsche:
			return Nietzsche(isOpponent);
		case Schopenhauer:
			return Nietzsche(isOpponent);
		case Kirkegaard:
			return Nietzsche(isOpponent);
		case Hobbes:
			return Nietzsche(isOpponent);
		case Freud:
			return Nietzsche(isOpponent);
		case Kant:
			return Nietzsche(isOpponent);
		case Wittgenstein:
			return Nietzsche(isOpponent);
		default:
			return null;
		}
	}
	
	public static Philosopher Nietzsche(boolean isOpponent){	
		Philosopher p = new Philosopher("Nietzsche", 100,20,Ressources.Nietzsche(),isOpponent);
		p.attacks[3] = Attack.EternalReturn();
		p.attacks[4] = Attack.WilltoPower();
		p.attacks[5] = Attack.SummonUbermensch();
		
		p.phrases[0] = "You shall be overcome.";
		p.phrases[1] = "I perish ... and in perishing ... I triumph!";
		p.phrases[2] = "You found me before you found yourself.";
		return p;
	}
	public static Philosopher Descartes(boolean isOpponent){
		
		Philosopher p = new Philosopher("Descartes", 100,20,Ressources.Descartes(),isOpponent);
		p.attacks[3] = Attack.CartesianDualism();
		p.attacks[4] = Attack.DeusDeceptor();
		p.attacks[5] = Attack.CogitoErgoSum();
		
		p.phrases[0] = "I think -- therefore I kick ass!";
		p.phrases[1] = "I am indeed amazed when I consider how weak"+n+"my mind is and how prone to error.";
		p.phrases[2] = "Perfect men like perfect numbers are very rare."+n+"You are not one of them.";
		
		return p;
	}
	
public static Philosopher Socrates(boolean isOpponent){
		
		Philosopher p = new Philosopher("Socrates", 100,20,Ressources.Socrates(),isOpponent);
		p.attacks[3] = Attack.SocraticMethod();
		p.attacks[4] = Attack.PlatonicLove();
		p.attacks[5] = Attack.AristotelianLogic();
		return p;
	}
	

	public Philosopher(String name, int maxhp, int sanity, TextureRegion texture, boolean isOpponent) {
		this.name = name;
		this.maxhp = maxhp;
		this.currenthp = maxhp;
		this.sanity = sanity;
		this.currentSanity = sanity;
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
		this.phrases = new String[3];
	}

	public String doAttack(Attack attack, Philosopher opp) {
		int damage = (int) Math.ceil(attack.hpDamage*(1 + attack.malus*(currentSanity-sanity)/sanity + attack.bonus*(opp.sanity - opp.currentSanity)/opp.sanity));  
		opp.currenthp -= damage;
		opp.currentSanity -= attack.sanityDamage;
		return "It does "+ damage + " damage to " + opp.name + "'s conviction!";
	}

	public Attack choseRandomMove(PhilosopherGame game) {
		Attack attack = attacks[Ressources.Rand().nextInt(attacks.length)];
		return attack;
	}
	
	public static Philosopher getRandom() {
		
		return null;
	}

}