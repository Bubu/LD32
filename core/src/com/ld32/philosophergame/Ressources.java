package com.ld32.philosophergame;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public final class Ressources {
	public static int AdvanceText = 0;
	private static Ressources instance = null;
	private Skin skin;
	public TextureRegion[][] philosophers;
	private LabelStyle bubbleStyleLeft;
	private LabelStyle bubbleStyleRight;
	private Random rand;
	private Ressources() {
		 rand = new Random();
		 philosophers = TextureRegion.split(new Texture(Gdx.files.internal("PhilospherSprites.png")), 15, 26);
		 skin = new Skin(Gdx.files.internal("uiskin.json"));
		 //load bubble skin
		 NinePatch bubblePatchLeft = new NinePatch(new Texture(Gdx.files.internal("BubbleLeft.png")), 49, 49, 24, 56);
		 skin.add("bubbleBackgroundLeft",bubblePatchLeft);
		 bubbleStyleLeft = new LabelStyle(skin.getFont("mono-font"), skin.getColor("black"));
		 bubbleStyleLeft.background = skin.getDrawable("bubbleBackgroundLeft");
		 
		 NinePatch bubblePatchRight = new NinePatch(new Texture(Gdx.files.internal("BubbleRight.png")), 20, 43, 14, 50);
		 skin.add("bubbleBackgroundRight",bubblePatchRight);
		 bubbleStyleRight = new LabelStyle(skin.getFont("mono-font"), skin.getColor("black"));
		 bubbleStyleRight.background = skin.getDrawable("bubbleBackgroundRight");

	}
	public static Ressources getInstance() {
		if(instance == null) {
			instance = new Ressources();
		}
		return instance;
	}
	
	public static TextureRegion getPhilosopherSprite(Philosopher.Philosophers phil){
		switch(phil){
		case Descartes:
			return Descartes();
		case Socrates:
			return Socrates();
		case Nietzsche:
			return Nietzsche();
		case Schopenhauer:
			return Schopenhauer();
		case Kierkegaard:
			return Kierkegaard();
		case Hobbes:
			return Hobbes();
		case Freud:
			return Freud();
		case Kant:
			return Kant();
		case Wittgenstein:
			return Wittgenstein();
		default:
			return null;
		}
	}
	public static TextureRegion Nietzsche(){
		return getInstance().philosophers[0][4];
	}
	public static TextureRegion Descartes(){
		return getInstance().philosophers[0][0];
	}
	public static TextureRegion Schopenhauer(){
		return getInstance().philosophers[0][1];
	}
	public static TextureRegion Kierkegaard(){
		return getInstance().philosophers[0][2];
	}
	public static TextureRegion Hobbes(){
		return getInstance().philosophers[0][3];
	}
	public static TextureRegion Socrates(){
		return getInstance().philosophers[0][5];
	}
	public static TextureRegion Freud(){
		return getInstance().philosophers[0][6];
	}
	public static TextureRegion Kant(){
		return getInstance().philosophers[0][7];
	}
	public static TextureRegion Wittgenstein(){
		return getInstance().philosophers[1][0];
	}
	public static Skin Skin(){
		return getInstance().skin;
	}
	public static LabelStyle BubbleStyleLeft(){
		return getInstance().bubbleStyleLeft;
	}
	public static LabelStyle BubbleStyleRight(){
		return getInstance().bubbleStyleRight;
	}
	public static EventListener EscListener(final PhilosopherGame game) {
		InputListener esclistner = new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ESCAPE ){
					game.setScreen(game.menuScreen);
					return true;
				}
				else{
					return false;
				}
		 	}
		};
		return esclistner;
		
	}
	public static Random Rand(){
		return getInstance().rand;
	}
}
