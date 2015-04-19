package com.ld32.philosophergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
public class PhilosopherGame extends Game {
	MenuScreen menuScreen;
	FightScreen fightscreen;
	boolean isRunning;
	Philosopher player;

	public void create () {
		isRunning = false;
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void start() {
		isRunning = true;	
		player =  Philosopher.Nietzsche();
		fightscreen = new FightScreen(this);
		resumeGame();
		
	}

	public void resumeGame() {
		setScreen(fightscreen);
	}

	public void quit() {
		Gdx.app.exit();		
	}

}