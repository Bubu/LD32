package com.ld32.philosophergame;

public class Attack {
	String name;
	int coolDown;
	float hpDamage;
	float sanityDamage;
	float bonus;
	float malus;

	public static Attack Paradox(){
		return new Attack("Paradox", 0, 0, 10, 0.5f, 0);
	}
	
	public static Attack AdHominem() {
		return new Attack("Ad Hominem", 40, 0, 10, 0.5f, 0);
	}
	
	public static Attack SelPerption(){
		return new Attack("Selective Perception", 1, 0, 0, 0.5f, 1);
	}
	
	public static Attack EternalReturn(){
		return new Attack("Eternal Return", 1, 0, 0, 0.5f, 1);
	}
	public static Attack WilltoPower(){
		return new Attack("Will to Power", 1, 0, 0, 0.5f, 1);
	}
	public static Attack Summon‹bermensch(){
		return new Attack("Summon ‹bermensch", 1, 0, 0, 0.5f, 1);
	}
	
	public Attack(String name, int coolDown, float hpDamage, float sanityDamage, float bonus, float malus) {
		this.name = name;
		this.coolDown = coolDown;
		this.hpDamage = hpDamage;
		this.sanityDamage = sanityDamage;
		this.bonus = bonus;
		this.malus = malus;
	}

	public Attack() {
		this.name = "Stub";
	}

	

}
