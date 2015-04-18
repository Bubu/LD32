package com.ld32.philosophergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
public class PhilosopherGame extends Game {
	MenuScreen menuScreen;
	FightScreen fightscreen;
	boolean isRunning;

	public void create () {
		isRunning = false;
		menuScreen = new MenuScreen(this);
		fightscreen = new FightScreen(this);
		setScreen(menuScreen);
	}

	public void start() {
		isRunning = true;	
		resumeGame();
		
	}

	public void resumeGame() {
		setScreen(fightscreen);
	}

	public void quit() {
		Gdx.app.exit();		
	}

}