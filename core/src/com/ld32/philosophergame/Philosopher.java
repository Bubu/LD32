package com.ld32.philosophergame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Philosopher {
	public static enum Philosophers {Socrates, Descartes, Nietzsche, Schopenhauer, Kirkegaard, Hobbes, Freud, Kant, Wittgenstein};
	public static String[] PhilosopherNames = {"Socrates", "Descartes", "Nietzsche", "Schopenhauer", "Kirkegaard", "Hobbes", "Freud", "Kant", "Wittgenstein"};
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

public static Philosopher Schopenhauer(boolean isOpponent){
	
	Philosopher p = new Philosopher("Schopenhauer", 100,20,Ressources.Schopenhauer(),isOpponent);
	p.attacks[3] = Attack.Pessimism();
	p.attacks[4] = Attack.HedgehogDilemma();
	p.attacks[5] = Attack.LifeIsSuffering();
	return p;
}

public static Philosopher Wittgenstein(boolean isOpponent){
	
Philosopher p = new Philosopher("Wittgenstein", 100,20,Ressources.Wittgenstein(),isOpponent);
p.attacks[3] = Attack.LogicalProposition();
p.attacks[4] = Attack.LanguageGames();
p.attacks[5] = Attack.BeatleInABox();
return p;
}

public static Philosopher Hobbes(boolean isOpponent){
	
Philosopher p = new Philosopher("Hobbes", 100,20,Ressources.Hobbes(),isOpponent);
p.attacks[3] = Attack.AllAgainstAll();
p.attacks[4] = Attack.SocialContract();
p.attacks[5] = Attack.SummonLeviathan();
return p;
}

public static Philosopher Freud(boolean isOpponent){
	
Philosopher p = new Philosopher("Freud", 100,20,Ressources.Freud(),isOpponent);
p.attacks[3] = Attack.Tabu();
p.attacks[4] = Attack.SexualRepression();
p.attacks[5] = Attack.SummonSuperEgo();
return p;
}

public static Philosopher Kant(boolean isOpponent){

Philosopher p = new Philosopher("Kant", 100,20,Ressources.Kant(),isOpponent);
p.attacks[3] = Attack.PureReason();
p.attacks[4] = Attack.CathegorialImperativ();
p.attacks[5] = Attack.Enlightenment();
return p;
}

public static Philosopher Kierkegaard(boolean isOpponent){

Philosopher p = new Philosopher("Kierkegaard", 100,20,Ressources.Kierkegaard(),isOpponent);
p.attacks[3] = Attack.Angst();
p.attacks[4] = Attack.ExistentialDespair();
p.attacks[5] = Attack.summonKnightOfFaith();
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
		String returnString = "";
		if (damage != 0){
			returnString += "It does "+ damage + " damage to " + opp.name + "'s conviction!";
		}
		if(attack.sanityDamage != 0){
			if (returnString != "") returnString += n;
			returnString += "It does "+ attack.sanityDamage + " damage to " + opp.name + "'s sanity!";
		}
		if (returnString == "") returnString += "It does nothing!";
		return returnString;
	}

	public Attack choseRandomMove(PhilosopherGame game) {
		Attack attack = attacks[Ressources.Rand().nextInt(attacks.length)];
		return attack;
	}
	
	public static Philosopher getRandom() {
		
		return null;
	}

	public Philosophers getType() {
		if(name == "Socrates") return Philosophers.Socrates;
		if(name == "Descartes") return Philosophers.Descartes;
		if(name == "Nietzsche") return Philosophers.Nietzsche;
		if(name == "Schopenhauer") return Philosophers.Schopenhauer;
		if(name == "Kirkegaard") return Philosophers.Kirkegaard;
		if(name == "Hobbes") return Philosophers.Hobbes;
		if(name == "Freud") return Philosophers.Freud;
		if(name == "Kant") return Philosophers.Kant;
		if(name == "Wittgenstein") return Philosophers.Wittgenstein;
		return null;
		
	}

}