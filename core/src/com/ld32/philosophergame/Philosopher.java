package com.ld32.philosophergame;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
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
		p.attacks[5] = Attack.SummonÜbermensch();
		return p;
	}
	
	Philosopher p = new Philosopher("Schopenhauer", 100,20,Ressources.Schopenhauer(),isOpponent);
	p.attacks[3] = Attack.Pessimism();
	p.attacks[4] = Attack.HedgehogDilemma();
	p.attacks[5] = Attack.LifeIsSuffering();
	return p;
}

Philosopher p = new Philosopher("Wittgenstein", 100,20,Ressources.Wittgenstein(),isOpponent);
p.attacks[3] = Attack.LogicalProposition();
p.attacks[4] = Attack.LanguageGames();
p.attacks[5] = Attack.BeatleInABox();
return p;
}

Philosopher p = new Philosopher("Hobbes", 100,20,Ressources.Hobbes(),isOpponent);
p.attacks[3] = Attack.AllAgainstAll();
p.attacks[4] = Attack.SocialContract();
p.attacks[5] = Attack.SummonLeviathan();
return p;
}

Philosopher p = new Philosopher("Freud", 100,20,Ressources.Freud(),isOpponent);
p.attacks[3] = Attack.Tabu();
p.attacks[4] = Attack.SexualRepression();
p.attacks[5] = Attack.SummonSuperEgo();
return p;
}

Philosopher p = new Philosopher("Kant", 100,20,Ressources.Kant(),isOpponent);
p.attacks[3] = Attack.PureReason();
p.attacks[4] = Attack.CathegorialImperativ();
p.attacks[5] = Attack.Enlightenment();
return p;
}

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
		Gdx.app.log("TODO!", "Handle Attack: "+attack.name);
		return "It does something!";
	}

	public Attack chooseMove(Philosopher opp) {
		Gdx.app.log("TODO!", "Choose Attack");
		doAttack(new Attack(), opp);	
		return new Attack();
	}
	
	public static Philosopher getRandom() {
		
		return null;
	}

}