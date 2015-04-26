package com.ld32.philosophergame;

import java.util.HashSet;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class Philosopher {
	public static enum Philosophers {Socrates, Descartes, Nietzsche, Schopenhauer, Kierkegaard, Hobbes, Freud, Kant, Wittgenstein};
	public static String[] PhilosopherNames = {"Socrates", "Descartes", "Nietzsche", "Schopenhauer", "Kierkegaard", "Hobbes", "Freud", "Kant", "Wittgenstein"};
	int maxhp;
	int currenthp;
	int sanity;
	Image sprite;
	Attack[] attacks;
	String name;
	String[] phrases;
	int currentSanity;
	boolean attacking;
	HashSet<Condition> preConditions;
	HashSet<Condition> postConditions;

	public static String n = "\n"; //Ressources.getLineSeparator();

	public static Philosopher createPhilosopher(String name, boolean isOpponent){
		Philosophers phil = getType(name);
		switch(phil){
		case Descartes:
			return Descartes(isOpponent);
		case Socrates:
			return Socrates(isOpponent);
		case Nietzsche:
			return Nietzsche(isOpponent);
		case Schopenhauer:
			return Schopenhauer(isOpponent);
		case Kierkegaard:
			return Kierkegaard(isOpponent);
		case Hobbes:
			return Hobbes(isOpponent);
		case Freud:
			return Freud(isOpponent);
		case Kant:
			return Kant(isOpponent);
		case Wittgenstein:
			return Wittgenstein(isOpponent);
		default:
			return null;
		}
	}

	public static Philosopher Nietzsche(boolean isOpponent){	
		Philosopher p = new Philosopher("Nietzsche", 100,40,Ressources.Nietzsche(),isOpponent);
		p.attacks[3] = Attack.EternalReturn();
		p.attacks[4] = Attack.WilltoPower();
		p.attacks[5] = Attack.SummonUbermensch();

		p.phrases[0] = "You shall be overcome.";
		p.phrases[1] = "I perish ... and in perishing ... I triumph!";
		p.phrases[2] = "You found me before you found yourself.";
		return p;
	}
	public static Philosopher Descartes(boolean isOpponent){

		Philosopher p = new Philosopher("Descartes", 100,40,Ressources.Descartes(),isOpponent);
		p.attacks[3] = Attack.CartesianDualism();
		p.attacks[4] = Attack.DeusDeceptor();
		p.attacks[5] = Attack.CogitoErgoSum();

		p.phrases[0] = "I think -- therefore I kick ass!";
		p.phrases[1] = "I am indeed amazed when I consider how weak"+n+"my mind is and how prone to error.";
		p.phrases[2] = "Perfect men like perfect numbers are very rare."+n+"You are not one of them.";

		return p;
	}

	public static Philosopher Socrates(boolean isOpponent){

		Philosopher p = new Philosopher("Socrates", 100,40,Ressources.Socrates(),isOpponent);
		p.attacks[3] = Attack.SocraticMethod();
		p.attacks[4] = Attack.PlatonicLove();
		p.attacks[5] = Attack.AristotelianLogic();

		p.phrases[0] = "I can not teach anybody anything,"+n+"I can only make them think.";
		p.phrases[1] = "Bring me the hemlock!";
		p.phrases[2] = "Now you know that you know nothing.";

		return p;
	}

	public static Philosopher Schopenhauer(boolean isOpponent){

		Philosopher p = new Philosopher("Schopenhauer", 100,40,Ressources.Schopenhauer(),isOpponent);
		p.attacks[3] = Attack.Pessimism();
		p.attacks[4] = Attack.HedgehogDilemma();
		p.attacks[5] = Attack.LifeIsSuffering();

		p.phrases[0] = "The two enemies of human happiness are pain"+n+"and boredom. Prepare for pain.";
		p.phrases[1] = "You made me sad. Again.";
		p.phrases[2] = "Now in the height of my victory"+n+"it feels empty and shallow.";

		return p;
	}

	public static Philosopher Wittgenstein(boolean isOpponent){

		Philosopher p = new Philosopher("Wittgenstein", 100,40,Ressources.Wittgenstein(),isOpponent);
		p.attacks[3] = Attack.LogicalAtomism();
		p.attacks[4] = Attack.LanguageGames();
		p.attacks[5] = Attack.BeatleInABox();

		p.phrases[0] = "Logic is not a body of doctrine,"+n+"but a mirror-image of the world.";
		p.phrases[1] = "The limits of my language mean the limits of my world.";
		p.phrases[2] = "I try to put it into language: You lost hard.";

		return p;
	}

	public static Philosopher Hobbes(boolean isOpponent){

		Philosopher p = new Philosopher("Hobbes", 100,40,Ressources.Hobbes(),isOpponent);
		p.attacks[3] = Attack.AllAgainstAll();
		p.attacks[4] = Attack.SocialContract();
		p.attacks[5] = Attack.SummonLeviathan();
		
		p.phrases[0] = "It is not wisdom but Authority that makes a law.";
		p.phrases[1] = "You won with words."+n+"Words are the money of fools.";
		p.phrases[2] = "Get out of my social contract!";
		
		return p;
	}

	public static Philosopher Freud(boolean isOpponent){

		Philosopher p = new Philosopher("Freud", 100,40,Ressources.Freud(),isOpponent);
		p.attacks[3] = Attack.Tabu();
		p.attacks[4] = Attack.SexualRepression();
		p.attacks[5] = Attack.SummonSuperEgo();
		
		p.phrases[0] = "Dreams are often most profound"+n+"when they seem the most crazy.";
		p.phrases[1] = "Personally, I blame my mother.";
		p.phrases[2] = "The first human who hurled an insult"+n+"instead of a stone was the founder"+n+"of civilization. You ass!";
		
		return p;
	}

	public static Philosopher Kant(boolean isOpponent){

		Philosopher p = new Philosopher("Kant", 100,40,Ressources.Kant(),isOpponent);
		p.attacks[3] = Attack.PureReason();
		p.attacks[4] = Attack.CategoricalImperative();
		p.attacks[5] = Attack.Enlightenment();
		
		p.phrases[0] = "Kant touch this!";
		p.phrases[1] = "Looks like you can touch this.";
		p.phrases[2] = "Ingratitude is the essence of vileness!";
		
		return p;
	}

	public static Philosopher Kierkegaard(boolean isOpponent){

		Philosopher p = new Philosopher("Kierkegaard", 100,40,Ressources.Kierkegaard(),isOpponent);
		p.attacks[3] = Attack.Angst();
		p.attacks[4] = Attack.ExistentialDespair();
		p.attacks[5] = Attack.SummonKnightOfFaith();
		
		p.phrases[0] = "Once you label me, you negate me.";
		p.phrases[1] = "The tyrant dies and his rule is over,"+n+"the martyr dies and his rule begins.";
		p.phrases[2] = "Prayer does not change God,"+n+"but it changes him who prays.";
		
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
		sprite.setScaling(Scaling.fill);
		sprite.setHeight(150);
		sprite.setWidth(sprite.getWidth() * 150/texture.getRegionHeight());
		this.attacks = new Attack[6];
		this.attacks[0] = Attack.AdHominem();
		this.attacks[1] = Attack.Paradox();
		this.attacks[2] = Attack.SelPerption();
		this.phrases = new String[3];
		this.attacking = true;
		this.preConditions= new HashSet<Condition>();
		this.postConditions= new HashSet<Condition>();
			
	}

	public String doAttack(Attack attack, Philosopher opponent) {
		attack.currentCoolDown += attack.coolDown;
		int damage = (int) Math.ceil(attack.hpDamage*(1 + attack.malus*(currentSanity-sanity)/sanity + attack.bonus*(opponent.sanity - opponent.currentSanity)/opponent.sanity));  
		
		opponent.currenthp -= damage;
		opponent.currentSanity -= attack.sanityDamage;
		currenthp += attack.hpHealing;
		currentSanity += attack.sanityHealing;


		String returnString = "";
		
		if (damage != 0){
			returnString += n + "It does "+ damage + " damage to " + opponent.name + "'s conviction!";
		}
		if(attack.sanityDamage != 0){
			returnString += n + "It does "+ attack.sanityDamage + " damage to " + opponent.name + "'s sanity!";
		}
		if(attack.hpHealing > 0){
			returnString += n + name + " heals " + attack.hpHealing + " of his conviction!";
		}
		if(attack.sanityHealing > 0){
			returnString += n + name + " heals " + attack.sanityHealing + " of his sanity!";
		}
		if(attack.hpHealing < 0){
			returnString += n + name + " damages his own conviction by " + (-1)*attack.hpHealing;
		}
		if(attack.sanityHealing < 0){
			returnString += n + name + " damages his own sanity by " + (-1)*attack.sanityHealing;
		}
		if (returnString == "") returnString += "It does nothing!";

		returnString = name + " uses \"" + attack.name + "\"." + n + returnString + n;
		
		repairStats(opponent);

		return returnString;

	}

	void repairStats(Philosopher opp){
		if(currentSanity<0){currentSanity=0;};
		if(currenthp<0){currenthp=0;};
		if(opp.currentSanity<0){opp.currentSanity=0;};
		if(opp.currenthp<0){opp.currenthp=0;};
		if(currentSanity>sanity){currentSanity=sanity;};
		if(currenthp>maxhp){currenthp=maxhp;};
		if(opp.currentSanity>opp.sanity){opp.currentSanity=opp.sanity;};
		if(opp.currenthp>opp.maxhp){opp.currenthp= opp.maxhp;};
	}

	public Attack choseRandomMove(PhilosopherGame game) {
		Attack attack = attacks[Ressources.Rand().nextInt(attacks.length)];
		return attack;
	}

	public static Philosophers getType(String name) {
		if(name == "Socrates") return Philosophers.Socrates;
		if(name == "Descartes") return Philosophers.Descartes;
		if(name == "Nietzsche") return Philosophers.Nietzsche;
		if(name == "Schopenhauer") return Philosophers.Schopenhauer;
		if(name == "Kierkegaard") return Philosophers.Kierkegaard;
		if(name == "Hobbes") return Philosophers.Hobbes;
		if(name == "Freud") return Philosophers.Freud;
		if(name == "Kant") return Philosophers.Kant;
		if(name == "Wittgenstein") return Philosophers.Wittgenstein;
		return null;

	}

	public void heal() {
		currenthp = maxhp;
		currentSanity = sanity;
		preConditions = new HashSet<Condition>();
		postConditions = new HashSet<Condition>();
		attacking = true;
	}
	
	public void cooldownAttacks(){
		for(int i = 0; i < attacks.length; i++){
			attacks[i].currentCoolDown -= 1;
			if(attacks[i].currentCoolDown < 0) attacks[i].currentCoolDown = 0;
		}
	}

	public void resetCooldowns() {
		for(int i = 0; i < attacks.length; i++){
			attacks[i].currentCoolDown = 0;
		}
		
	}

	public void addPostCondition(Condition condition) {
		postConditions.add(condition);		
	}
	
	public void addPreCondition(Condition condition) {
		preConditions.add(condition);		
	}

}