package com.ld32.philosophergame;

public class Attack {
	String name;
	int coolDown;
	float hpDamage;
	float sanityDamage;
	float bonus;
	float malus;

	public static Attack Confuse(){
		return new Attack("Confuse", 0, 0, 10, 0.5f, 0);
	}
	public Attack(String name, int coolDown, float hpDamage, float sanityDamage, float bonus, float malus) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.coolDown = coolDown;
		this.hpDamage = hpDamage;
		this.sanityDamage = sanityDamage;
		this.bonus = bonus;
		this.malus = malus;
	}

}
