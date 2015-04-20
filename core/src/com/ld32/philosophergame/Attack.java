package com.ld32.philosophergame;

public class Attack {
	String name;
	int coolDown;
	float hpDamage;
	float sanityDamage;
	float bonus;
	float malus;
	String[] messages;
	
	static String n = System.getProperty("line.separator");
	// Generale Attacks
	
	
	public static Attack Paradox(){
		String[] messages = new String[3];
		messages[0] = "This statement is a lie.";
		messages[1] = "Can an omnipotent being create a rock"+n+"too heavy for itself to lift?";
		messages[2] = "White horses are not horses because white"+n+"and horse refer to different things.";		
		return new Attack("Paradox", 0, 0, 10, 0.5f, 0, messages);
	}
	
	public static Attack AdHominem() {
		String[] messages = new String[3];
		messages[0] = "You stink!";
		messages[1] = "I would listen to you, but then again,"+n+"you are an idiot.";
		messages[2] = "You don't really have a degree, do you?";
		return new Attack("Ad Hominem", 40, 0, 10, 0.5f, 0, messages);
	}
	
	public static Attack SelPerption(){
		String[] messages = new String[3];
		messages[0] = "Lalalalala, I'm not listening!";
		messages[1] = "So you are saying, I am completely right?";
		messages[2] = "I believe your own argument defeats itself.";
		return new Attack("Selective Perception", 1, 0, 0, 0.5f, 1, messages);
	}
	
	// Nietzsche Attacks
	
	public static Attack EternalReturn(){
		String[] messages = new String[3];
		messages[0] = "I'll be back!";
		messages[1] = "Don't simply bear the necessary. Love it!";
		messages[2] = "This is the greatest burden of all.";
		return new Attack("Eternal Return", 1, 0, 0, 0.5f, 1, messages);
	}
	public static Attack WilltoPower(){
		String[] messages = new String[3];
		messages[0] = "I have the power!";
		messages[1] = "The world is the will to power"+n+"— and nothing besides!";
		messages[2] = "There is only power and those too weak to seek it!";
		return new Attack("Will to Power", 1, 0, 0, 0.5f, 1, messages);
	}
	public static Attack SummonUbermensch(){
		String[] messages = new String[3];
		messages[0] = "A wild Übermensch appears!";
		messages[1] = "We are but a bridge from ape to Übermensch.";
		messages[2] = "I make my own morales.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	// Attack Schopenhauer
	
	public static Attack Pessimism(){
		String[] messages = new String[3];
		messages[0] = "Why ";
		messages[1] = "We are but a bridge from ape to Übermensch.";
		messages[2] = "I make my own morales.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack LifeIsSuffering(){
		String[] messages = new String[3];
		messages[0] = "Why ";
		messages[1] = "We are but a bridge from ape to Übermensch.";
		messages[2] = "I make my own morales.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack HedgehogDilemma(){
		String[] messages = new String[3];
		messages[0] = "Real Closeness is impossible.";
		messages[1] = "The more you try, the more you hurt the people closest to you.";
		messages[2] = "I make my own morales.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	
	public Attack(String name, int coolDown, float hpDamage, float sanityDamage, float bonus, float malus, String[] messages) {
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
