package com.ld32.philosophergame;

public class Attack {
	String name;
	int coolDown;
	int currentCoolDown;
	int hpDamage;
	int sanityDamage;
	float bonus;
	float malus;
	int hpHealing;
	int sanityHealing;
	float thinkingChance;
	String[] messages;

	public static String n = "\n"; //Ressources.getLineSeparator();
	// Generale Attacks


	public static Attack Paradox(){
		String[] messages = new String[3];
		messages[0] = "This statement is a lie.";
		messages[1] = "Can an omnipotent being create a rock"+n+"too heavy for itself to lift?";
		messages[2] = "White horses are not horses because"+n+"white and horse refer to different things.";		
		int coolDown = 0; float thinkingChance=0.1f;
		int hpDamage = 0;	 int sanityDamage = 10;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0;
		return new Attack("Paradox", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack AdHominem() {
		String[] messages = new String[6];
		messages[0] = "You stink!";
		messages[1] = "I would listen to you, but then again,"+n+"you are an idiot.";
		messages[2] = "You don't really have a degree, do you?";
		messages[3] = "That's what she said!";
		messages[4] = "If I agree with you we are both wrong!";
		messages[5] = "Get a haircut, you hippy!";

		int coolDown = 0; float thinkingChance=0.05f;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 1f;
		return new Attack("Ad Hominem", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack SelPerption(){
		String[] messages = new String[3];
		messages[0] = "Lalalalala, I'm not listening!";
		messages[1] = "So you are saying, I am completely right?";
		messages[2] = "I believe your own argument defeats itself.";
		int coolDown = 0; float thinkingChance=0f;
		int hpDamage = 0;	 int sanityDamage = 0;
		int hpHealing = 5;  int sanityHealing = 10;
		float malus = 0;        float bonus = 0;
		return new Attack("Selective Perception", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Nietzsche Attacks

	public static Attack EternalReturn(){
		String[] messages = new String[3];
		messages[0] = "I'll be back!";
		messages[1] = "Don't simply bear the necessary. Love it!";
		messages[2] = "Eternal return. This is the greatest burden of all.";
		int coolDown = 3; float thinkingChance=0.15f;
		int hpDamage = 15;	 int sanityDamage = 15;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0.5f;
		return new Attack("Eternal Return", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}
	public static Attack WilltoPower(){
		String[] messages = new String[3];
		messages[0] = "I have the power!";
		messages[1] = "The world is the will to power"+n+"-- and nothing besides!";
		messages[2] = "There is only power and those too weak to seek it!";
		int coolDown = 3; float thinkingChance=0.1f;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 20;  int sanityHealing = -10;
		float malus = 0;        float bonus = 0;
		return new Attack("Will to Power", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}
	public static Attack SummonUbermensch(){
		String[] messages = new String[3];
		messages[0] = "A wild Ubermensch appears!";
		messages[1] = "We are but a bridge from ape to Ubermensch.";
		messages[2] = "I make my own morales.";

		int coolDown = 5; float thinkingChance=0.2f;
		int hpDamage = 20;	 int sanityDamage = 10;
		int hpHealing = 10;  int sanityHealing = 10;
		float malus = 0;        float bonus = 0;
		return new Attack("Summon Ubermensch", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Descartes Attacks

	public static Attack CartesianDualism(){
		String[] messages = new String[3];
		messages[0] = "I separate my mind from my body.";
		messages[1] = "The thinking thing is the essence of himself.";
		messages[2] = "Two are better than one.";
		int coolDown = 2; float thinkingChance=0.15f;;
		int hpDamage = 10;	 int sanityDamage = 10;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0;
		return new Attack("Cartesian Dualism", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack DeusDeceptor(){
		String[] messages = new String[3];
		messages[0] = "Everything was arranged to deceive you!";
		messages[1] = "A malicious deamon controls your senses.";
		messages[2] = "I show you how deep the rabbit hole goes.";
		int coolDown = 5; float thinkingChance = 0.6f;
		int hpDamage = 0;	 int sanityDamage = 20;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0;
		return new Attack("Deus Deceptor", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}	

	public static Attack CogitoErgoSum(){
		String[] messages = new String[3];
		messages[0] = "Je pense ainsi je suis.";
		messages[1] = "I may be wrong, but at least I am.";
		messages[2] = "For all I know, you might be just a P-Zombie.";
		int coolDown = 3; float thinkingChance=0.15f;;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 10;  int sanityHealing = 10;
		float malus = 0;        float bonus = 0;
		return new Attack("Cogito Ergo Sum", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}	

	// Socrates Attacks

	public static Attack SocraticMethod(){
		String[] messages = new String[3];
		messages[0] = "I see, from the few words which you have uttered,"+n+"that he has attended more to the art which"+n+"is called rhetoric than to dialectic.";
		messages[1] = "The unexamined life is not worth living.";
		messages[2] = "Please continue. I am curious about"+n+"the next thing you do not know.";

		int coolDown = 3; float thinkingChance=0.2f;;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0.3f;        float bonus = 0;
		return new Attack("Socratic Method", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack PlatonicLove(){
		String[] messages = new String[3];
		messages[0] = "I would love to see you"+n+"handcuffed in a dark cave!";
		messages[1] = "I like the idealised version of you.";
		messages[2] = "How does it feel to be ruled"+n+"by the philosopher king?";

		int coolDown = 2; float thinkingChance=0.1f;
		int hpDamage = 0;	 int sanityDamage = 20;
		int hpHealing = 20;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0.5f;

		return new Attack("Platonic Love", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}	

	public static Attack AristotelianLogic(){
		String[] messages = new String[3];
		messages[0] = "All living things are beautiful."+n+"I am a living thing."+n+"Therfore I am beautiful. Oh, yeah!";
		messages[1] = "Every non-Socrates against a"+n+"non-non-Socrates will be non-winning.";
		messages[2] = "One man's modus ponens is another man's modus tollens.";

		int coolDown = 3; float thinkingChance=0f;
		int hpDamage = 20;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0.3f;        float bonus = 0;

		return new Attack("Aristotelian Logic", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Attack Schopenhauer

	public static Attack Pessimism(){
		String[] messages = new String[3];
		messages[0] = "The brain may be regarded as a"+n+"kind of parasite of the organism,"+n+"a pensioner, as it were, who"+n+"dwells with the body.";
		messages[1] = "Wicked thoughts and worthless"+n+"efforts gradually set their mark"+n+"on the face, especially your face.";
		messages[2] = "Pessimism: A valuable protection against quackery.";

		int coolDown = 3; float thinkingChance=0.1f;
		int hpDamage = 20;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0.6f;

		return new Attack("Pessimism", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack LifeIsSuffering(){
		String[] messages = new String[3];
		messages[0] = "To live alone is the fate of all great souls.";
		messages[1] = "There is no doubt that"+n+"life is given us, not to be enjoyed,"+n+"but to be overcome; to be got over.";
		messages[2] = "I think I need a time out and go cry.";

		int coolDown = 4; float thinkingChance=0.1f;
		int hpDamage = 0;	 int sanityDamage = 20;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0.6f;

		return new Attack("Life is Suffering", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack HedgehogDilemma(){
		String[] messages = new String[3];
		messages[0] = "Real Closeness is impossible."+n+"For hedgehogs I mean.";
		messages[1] = "The more you try, the more you"+n+"hurt the people closest to you.";
		messages[2] = "Almost all of our sorrows spring"+n+"out of our relations with other people.";

		int coolDown = 5; float thinkingChance=0.1f;
		int hpDamage = 40;	 int sanityDamage = 0;
		int hpHealing = -20;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0.2f;

		return new Attack("Hedgehog Dilemma", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Wittgenstein Attacks

	public static Attack LogicalAtomism(){
		String[] messages = new String[3];
		messages[0] = "Time to diconstruct you!";
		messages[1] = "Some of your statements are"+n+"senseless, some are nonsensical."+n+"The rest is simply wrong.";
		messages[2] = "Whereof one cannot speak, thereof one must be silent.";

		int coolDown = 4; float thinkingChance=0.1f;;
		int hpDamage = 30;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0.3f;        float bonus = 0;

		return new Attack("Logical Atomism", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack LanguageGames(){
		String[] messages = new String[3];
		messages[0] = "What is the difference between a duck?";
		messages[1] = "How are a chicken and a grape alike?"+n+"They are both purple..."+n+"except for the chicken.";
		messages[2] = "We can not say that you am the worst of all times,"+n+"because we have no concept of 'of all times'.";

		int coolDown = 5; float thinkingChance=0.1f;;
		int hpDamage = 10;	 int sanityDamage = 20;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0.6f;        float bonus = 0;

		return new Attack("Language Games", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack BeatleInABox(){
		String[] messages = new String[3];
		messages[0] = "My beatle is much bigger than yours.";
		messages[1] = "In my world I am the winner. In your world we may even tie!";
		messages[2] = "My box seems to be bigger on the inside!";

		int coolDown = 3; float thinkingChance=0.4f;;
		int hpDamage = 0;	 int sanityDamage = 0;
		int hpHealing = 10;  int sanityHealing = 10;
		float malus = 0;        float bonus = 0;

		return new Attack("Beatle in a Box", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Hobbes Attacks

	public static Attack SocialContract(){
		String[] messages = new String[3];
		messages[0] = "I'm making you an offer you can not refuse.";
		messages[1] = "This is our only chance to escape the state of nature.";
		messages[2] = "Just accept the terms and conditions and sign here!";

		int coolDown = 3; float thinkingChance=0.1f;;
		int hpDamage = 40;	 int sanityDamage = 0;
		int hpHealing = -25;  int sanityHealing = 0;
		float malus = 0.1f;        float bonus = 0f;

		return new Attack("Social Contract", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack AllAgainstAll(){
		String[] messages = new String[3];
		messages[0] = "The condition of man... is a condition of"+n+"war of everyone against everyone.";
		messages[1] = "Life is nasty, brutish, and short.";
		messages[2] = "Men look not at the greatnesse of the evill past," + n + "but the greatnesse of the good to follow!";
		int coolDown = 4; float thinkingChance=0.10f;;
		int hpDamage = 15;	 int sanityDamage = 10;
		int hpHealing = 15;  int sanityHealing = 10;
		float malus = 0;        float bonus = 1f;
		return new Attack("All against All", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack SummonLeviathan(){
		String[] messages = new String[3];
		messages[0] = "There is no power on earth" + n + "to be compared to the Leviathan.";
		messages[1] = "I broke my back lifting the Leviathan to heaven.";
		messages[2] = "Now I am about to take my last voyage," + n + " a great leap in the dark.";
		int coolDown = 5; float thinkingChance=0.25f;
		int hpDamage = 20;	 int sanityDamage = 15;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0;
		return new Attack("Summon Leviathan", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Freud Attacks

	public static Attack Tabu(){
		String[] messages = new String[3];
		messages[0] = "Silence, you fool!";
		messages[1] = "It is generally assumed that the taboo"+n+"is older than the gods and"+n+"goes back to the pre-religious age.";
		messages[2] = "The mind should develop a blind spot whenever"+n+" a dangerous thought presented itself."+n+" The process should be automatic, instinctive. ";
		int coolDown = 3; float thinkingChance=0.1f;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 20;  int sanityHealing = 0;
		float malus = 0;        float bonus = 0.5f;

		return new Attack("Tabu", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack SexualRepression(){
		String[] messages = new String[3];
		messages[0] = "Your aggression seems to come from"+n+"an erotic infatuation to your grandmother.";
		messages[1] = "Sometimes a cigar is just a cigar.";
		messages[2] = "I sense a slight castration anxiety. "+n+"Don't worry this is natural.";

		int coolDown = 4; float thinkingChance=0.1f;
		int hpDamage = 10;	 int sanityDamage = 20;
		int hpHealing = 0;  int sanityHealing = -5;
		float malus = 0;        float bonus = 0;

		return new Attack("Sexual Repression", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack SummonSuperEgo(){
		String[] messages = new String[3];
		messages[0] = "The ego is not master in its own house.";
		messages[1] = "The super-ego is never so inexorable, so impersonal,"+n+"so independent of its emotional origins "+n+"as we require it to be in men";
		messages[2] = "My ego, my superego and I, that's all I got in the end."+n+"That's what I found out and there ain't no need to cry.";

		int coolDown = 5; float thinkingChance=0.2f;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 20;  int sanityHealing = 10;
		float malus = 0;        float bonus = 1;

		return new Attack("Summon Superego", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Kant Attacks

	public static Attack PureReason(){
		String[] messages = new String[3];
		messages[0] = "My thoughts shall cut like steal."+n+"Very long and very folded steal.";
		messages[1] = "Science is organized knowledge. Wisdom is organized life. ";
		messages[2] = "All our knowledge begins with the senses,"+n+"proceeds then to the understanding,"+n+"and ends with reason."+n+"There is nothing higher than reason.";

		int coolDown = 5; float thinkingChance=0f;
		int hpDamage = 50;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 1;        float bonus = 0;

		return new Attack("Pure Reson", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack CategoricalImperative(){
		String[] messages = new String[3];
		messages[0] = "Act only on that maxim through which you can at the"+n+"same time will that it should become a universal law.";
		messages[1] = "Call me the categorical imperator!";
		messages[2] = "By a lie, a man... annihilates his dignity as a man.";

		int coolDown = 3; float thinkingChance=0f;;
		int hpDamage = 10;	 int sanityDamage = 5;
		int hpHealing = 10;  int sanityHealing = 5;
		float malus = 1;        float bonus = 1;

		return new Attack("Categorical Imperative", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack Enlightenment(){
		String[] messages = new String[3];
		messages[0] = "Have the courage to use your own reason --"+n+"That is the motto of enlightenment.";
		messages[1] = "Knowing others is wisdom,"+n+"knowing yourself is Enlightenment.";
		messages[2] = "It must be difficult to work"+n+"yourself out of the immaturity"+n+"which has become almost natural for you.";

		int coolDown = 5; float thinkingChance=0f;;
		int hpDamage = 10;	 int sanityDamage = 0;
		int hpHealing = 30;  int sanityHealing = 20;
		float malus = 0;        float bonus = 0;

		return new Attack("Enlightenment", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	// Kierkegard Attacks

	public static Attack Angst(){
		String[] messages = new String[3];
		messages[0] = "We can easily forgive a child who is afraid"+n+"of the dark; the real tragedy of life"+n+"is when men are afraid of the light.";
		messages[1] = "Oh, my sweet summer child, what do you know of angst?";
		messages[2] = "Anxiety is an alien power which lays hold"+n+"of the individual; and yet one cannot tear"+n+"oneself away, not has a will to do so;"+n+"for one fears, but what one fears one desires";
		int coolDown = 4; float thinkingChance=0.1f;;
		int hpDamage = 20;	 int sanityDamage = 0;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0;        float bonus = 1;

		return new Attack("Angst", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack ExistentialDespair(){
		String[] messages = new String[3];
		messages[0] = "Life can only be understood backwards;"+n+"but it must be lived forwards.";
		messages[1] = "In a few hundred years no one will know"+n+"who you are or that you ever existed.";
		messages[2] = "The most painful state of being"+n+"is remembering the future, particularly"+n+"the one you'll never have.";

		int coolDown = 4; float thinkingChance=0.5f;;
		int hpDamage = 10;	 int sanityDamage = 10;
		int hpHealing = 0;  int sanityHealing = 0;
		float malus = 0.5f;        float bonus = 0;

		return new Attack("Existential Despair", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}

	public static Attack SummonKnightOfFaith(){
		String[] messages = new String[3];
		messages[0] = "The true knight of faith is a witness,"+n+"never a teacher, and therein lies his deep humanity.";
		messages[1] = "Faith consists in believing when it is beyond"+n+"the power of reason to believe.";
		messages[2] = "Just a mental flesh wound!";

		int coolDown = 5; float thinkingChance=0.2f;
		int hpDamage = 20;	 int sanityDamage = 10;
		int hpHealing = 10;  int sanityHealing = 10;
		float malus = 0;        float bonus = 0;

		return new Attack("Summon Knight of Faith", coolDown, hpDamage, sanityDamage, hpHealing, sanityHealing, bonus, malus, thinkingChance, messages);
	}


	public Attack(String name, int coolDown, int hpDamage, int sanityDamage, int hpHealing, int sanityHealing, float bonus, float malus, float thinkingChance, String[] messages) {
		this.name = name;
		this.coolDown = coolDown;
		this.currentCoolDown = 0;
		this.hpDamage = hpDamage;
		this.sanityDamage = sanityDamage;
		this.hpHealing = hpHealing;
		this.sanityHealing = sanityHealing;
		this.bonus = bonus;
		this.malus = malus;
		this.messages = messages;
		this.thinkingChance = thinkingChance;
	}

	public Attack() {
		this.name = "Stub";
	}



}
