package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public final class Ressources {
	private static Ressources instance = null;
	private Skin skin;
	public TextureRegion[][] philosophers;
	private LabelStyle bubbleStyleLeft;
	private LabelStyle bubbleStyleRight;
	private Ressources() {
		 philosophers = TextureRegion.split(new Texture(Gdx.files.internal("PhilospherSprites.png")), 15, 26);
		 skin = new Skin(Gdx.files.internal("uiskin.json"));
		 //load bubble skin
		 NinePatch bubblePatchLeft = new NinePatch(new Texture(Gdx.files.internal("BubbleLeft.png")), 49, 49, 24, 56);
		 skin.add("bubbleBackgroundLeft",bubblePatchLeft);
		 bubbleStyleLeft = new LabelStyle(skin.getFont("default-font"), skin.getColor("white"));
		 bubbleStyleLeft.background = skin.getDrawable("bubbleBackgroundLeft");
		 
		 NinePatch bubblePatchRight = new NinePatch(new Texture(Gdx.files.internal("BubbleRight.png")), 20, 43, 14, 50);
		 skin.add("bubbleBackgroundRight",bubblePatchRight);
		 bubbleStyleRight = new LabelStyle(skin.getFont("default-font"), skin.getColor("white"));
		 bubbleStyleRight.background = skin.getDrawable("bubbleBackgroundRight");

	}
	public static Ressources getInstance() {
		if(instance == null) {
			instance = new Ressources();
		}
		return instance;
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
	public static TextureRegion Kirkegaard(){
		return getInstance().philosophers[0][2];
	}
	public static TextureRegion Hobbes(){
		return getInstance().philosophers[0][3];
	}
	public static TextureRegion Sokrates(){
		return getInstance().philosophers[0][5];
	}
	public static TextureRegion Freud(){
		return getInstance().philosophers[0][6];
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
	
}
