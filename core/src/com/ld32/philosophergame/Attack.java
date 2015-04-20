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
	
	// Wittgenstein Attacks
	
	public static Attack LogicalAtomism(){
		String[] messages = new String[3];
		messages[0] = "Time to diconstruct you!";
		messages[1] = "Some of your statements are senseless, some are nonsensical."+n+"The rest is simply wrong.";
		messages[2] = "Whereof one cannot speak, thereof one must be silent.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack LanguageGames(){
		String[] messages = new String[3];
		messages[0] = "What is the difference between a duck?";
		messages[1] = "How are a chicken and a grape alike?"+n+"They are both purple... except for the chicken.";
		messages[2] = "We can not say that you am the worst of all times,"+n+"because we have no concept of 'of all times'.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack BeatleInABox(){
		String[] messages = new String[3];
		messages[0] = "My beatle is much bigger than yours.";
		messages[1] = "In my world I am the winner. In your world we may even tie!";
		messages[2] = "My box seems to be bigger on the inside!";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	// Hobbes Attacks
	
	public static Attack SocialContract(){
		String[] messages = new String[3];
		messages[0] = "I'm making you an offer you can not refuse.";
		messages[1] = "This is our only chance to escape the state of nature.";
		messages[2] = "Just accept the terms and conditions and sign here!";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack AllAgainstAll(){
		String[] messages = new String[3];
		messages[0] = "The condition of man... is a condition of"+n+"war of everyone against everyone.";
		messages[1] = "Life is nasty, brutish, and short";
		messages[2] = "Men look not at the greatnesse of the evill past, but the greatnesse of the good to follow!";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack SummonLeviathan(){
		String[] messages = new String[3];
		messages[0] = "There is no power on earth to be compared to the Leviathan.";
		messages[1] = "I broke my back lifting the Leviathan to heaven.";
		messages[2] = "Now I am about to take my last voyage, a great leap in the dark";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	// Freud Attacks
	
	public static Attack Tabu(){
		String[] messages = new String[3];
		messages[0] = "Silence, you fool!";
		messages[1] = "It is generally assumed that the taboo is older"+n+"than the gods and goes back to the pre-religious age.";
		messages[2] = "The mind should develop a blind spot whenever a dangerous"+n+"thought presented itself. The process should be automatic, instinctive. ";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack SexualRepression(){
		String[] messages = new String[3];
		messages[0] = "Your aggression seems to come from an erotic infatuation to your grandmother.";
		messages[1] = "Sometimes a cigar is just a cigar.";
		messages[2] = "I sense a slight castration anxiety. Don't worry this is natural.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack SummonSuperEgo(){
		String[] messages = new String[3];
		messages[0] = "The ego is not master in its own house.";
		messages[1] = "The super-ego is never so inexorable, so impersonal, so independent"+n+"of its emotional origins as we require it to be in men";
		messages[2] = "My ego, my super-ego and I, that's all I got in the end."+n+"That's what I found out and there ain't no need to cry.";
		return new Attack("Summon Ubermensch", 1, 0, 0, 0.5f, 1, messages);
	}
	
	// Kant Attacks
	
	public static Attack PureReason(){
		String[] messages = new String[3];
		messages[0] = "Silence, you fool!";
		messages[1] = "It is generally assumed that the taboo is older"+n+"than the gods and goes back to the pre-religious age.";
		messages[2] = "The mind should develop a blind spot whenever a dangerous"+n+"thought presented itself. The process should be automatic, instinctive. ";
		return new Attack("Pure Reson", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack CategoricalImperative(){
		String[] messages = new String[3];
		messages[0] = "Act only on that maxim through which you can at the"+n+"same time will that it should become a universal law";
		messages[1] = "Call me the categorical imperator!";
		messages[2] = "By a lie, a man... annihilates his dignity as a man.";
		return new Attack("Categorical Imperative", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack Enlightenment(){
		String[] messages = new String[3];
		messages[0] = "Have the courage to use your own reason --"+n+"That is the motto of enlightenment";
		messages[1] = "Knowing others is wisdom, knowing yourself is Enlightenment.";
		messages[2] = "It must be difficult to work yourself out of the immaturity which has become almost natural for you.";
		return new Attack("Enlightenment", 1, 0, 0, 0.5f, 1, messages);
	}
	
	// Kierkegard Attacks
	
	public static Attack Angst(){
		String[] messages = new String[3];
		messages[0] = "We can easily forgive a child who is afraid of the dark;"+n+"the real tragedy of life is when men are afraid of the light.";
		messages[1] = "Oh, my sweet summer child, what do you know of angst?";
		messages[2] = "Anxiety is an alien power which lays hold of the individual;"+n+"and yet one cannot tear oneself away, not has a will to do so;"+n+"for one fears, but what one fears one desires";
		return new Attack("Pure Reson", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack ExistentialDespair(){
		String[] messages = new String[3];
		messages[0] = "Life can only be understood backwards; but it must be lived forwards.";
		messages[1] = "In a few hundred years no one will know"+n+"who you are or that you ever existed.";
		messages[2] = "The most painful state of being is remembering the future,"+n+"particularly the one you'll never have.";
		return new Attack("Existential Despair", 1, 0, 0, 0.5f, 1, messages);
	}
	
	public static Attack SummonKnightOfFaith(){
		String[] messages = new String[3];
		messages[0] = "The true knight of faith is a witness, never a teacher, and therein lies his deep humanity.";
		messages[1] = "Faith consists in believing when it is beyond the power of reason to believe.";
		messages[2] = "It must be difficult to work yourself out of the immaturity which has become almost natural for you.";
		return new Attack("Summon Knight of Faith", 1, 0, 0, 0.5f, 1, messages);
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
