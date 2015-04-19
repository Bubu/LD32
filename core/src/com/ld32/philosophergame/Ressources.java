package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public final class Ressources {
	private static Ressources instance = null;
	public TextureRegion[][] philosophers;
	private Ressources() {
		 philosophers = TextureRegion.split(new Texture(Gdx.files.internal("PhilospherSprites.png")), 15, 26);
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
}
