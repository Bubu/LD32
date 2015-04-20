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
		String[] messages = new String[6];
		messages[0] = "You stink!";
		messages[1] = "I would listen to you, but then again,"+n+"you are an idiot.";
		messages[2] = "You don't really have a degree, do you?";
		messages[3] = "That's what she said!";
		messages[4] = "If I agree with you we are both wrong!";
		messages[5] = "Get a haircut, you hippy!";
		return new Attack("Ad Hominem", 0, 10, 0, 0, 0, messages);
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
		messages[2] = "Eternal return. This is the greatest burden of all.";
		return new Attack("Eternal Return", 1, 0, 0, 0.5f, 1, messages);
	}
	public static Attack WilltoPower(){
		String[] messages = new String[3];
		messages[0] = "I have the power!";
		messages[1] = "The world is the will to power"+n+"-- and nothing besides!";
		messages[2] = "There is only power and those too weak to seek it!";
		return new Attack("Will to Power", 1, 0, 0, 0.5f, 1, messages);
	}
	public static Attack SummonUbermensch(){
		String[] messages = new String[3];
		messages[0] = "A wild Ubermensch appears!";
		messages[1] = "We are but a bridge from ape to �bermensch.";
		messages[2] = "I make my own morales.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}

	// Descartes Attacks
	
	public static Attack CartesianDualism(){
		String[] messages = new String[3];
		messages[0] = "I separate my mind from my body.";
		messages[1] = "The thinking thing is the essence of himself.";
		messages[2] = "Two are better than one.";
		return new Attack("Cartesian Dualism", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack DeusDeceptor(){
		String[] messages = new String[3];
		messages[0] = "Everything was arranged to deceive you!";
		messages[1] = "A malicious deamon controls your senses.";
		messages[2] = "I show you how deep the rabbit hole goes.";
		return new Attack("Deus Deceptor", 1, 0, 0, 0.5f, 1, messages);
	}	
	
	public static Attack CogitoErgoSum(){
		String[] messages = new String[3];
		messages[0] = "Je pense ainsi je suis.";
		messages[1] = "I may be wrong, but at least I am.";
		messages[2] = "For all I know, you might be just a P-Zombie.";
		return new Attack("Cogito Ergo Sum", 1, 0, 0, 0.5f, 1, messages);
	}	
	
	// Socrates Attacks
	
	public static Attack SocraticMethod(){
		String[] messages = new String[3];
		messages[0] = "I see, from the few words which you have uttered,"+n+"that he has attended more to the art which"+n+"is called rhetoric than to dialectic.";
		messages[1] = "The unexamined life is not worth living.";
		messages[2] = "Please continue. I am curious about"+n+"the next thing you do not know.";
		return new Attack("Socratic Method", 1, 0, 0, 0.5f, 1, messages);
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
	
	public static Attack PlatonicLove(){
		String[] messages = new String[3];
		messages[0] = "I would love to see you"+n+"handcuffed in a dark cave!";
		messages[1] = "I like the idealised version of you.";
		messages[2] = "How does it feel to be ruled"+n+"by the philosopher king?";
		return new Attack("Platonic Love", 1, 0, 0, 0.5f, 1, messages);
	}	
	
	public static Attack AristotelianLogic(){
		String[] messages = new String[3];
		messages[0] = "All living things are beautiful."+n+"I am a living thing."+n+"Therfore I am beautiful. Oh, yeah!";
		messages[1] = "Every non-Socrates against a"+n+"non-non-Socrates will be non-winning.";
		messages[2] = "One man's modus ponens is another man's modus tollens.";
		return new Attack("Aristotelian Logic", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public Attack(String name, int coolDown, float hpDamage, float sanityDamage, float bonus, float malus, String[] messages) {
		this.name = name;
		this.coolDown = coolDown;
		this.hpDamage = hpDamage;
		this.sanityDamage = sanityDamage;
		this.bonus = bonus;
		this.malus = malus;
		this.messages = messages;
	}

	public Attack() {
		this.name = "Stub";
	}

	

}
