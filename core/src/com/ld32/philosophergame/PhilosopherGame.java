package com.ld32.philosophergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
public class PhilosopherGame extends Game {
	MenuScreen menuScreen;
	FightScreen fightscreen;
	boolean isRunning;
	Philosopher player;

	public void create () {
		isRunning = false;
		menuScreen = new MenuScreen(this);
		fightscreen = new FightScreen(this);
		setScreen(menuScreen);
	}

	public void start() {
		isRunning = true;	
		player = new Philosopher(100,20,new Texture(Gdx.files.internal("sprite.png")));
		resumeGame();
		
	}

	public void resumeGame() {
		setScreen(fightscreen);
	}

	public void quit() {
		Gdx.app.exit();		
	}

}