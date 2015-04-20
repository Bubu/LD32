package com.ld32.philosophergame;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
public class PhilosopherGame extends Game {
	MenuScreen menuScreen;
	FightScreen fightscreen;
	SelectionScreen selectionScreen;
	boolean isRunning;
	Philosopher player;
	Philosopher opponent;
	Philosopher currentplayer;
	private Screen currentScreen;
	private ArrayList<Philosopher.Philosophers> fought;

	public void create () {
		isRunning = false;
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void startFight() {
		opponent = getNextOpponent();
		currentplayer = player; 
		fightscreen = new FightScreen(this);
		currentScreen = fightscreen;
		setScreen(currentScreen);
	}

	private Philosopher getNextOpponent() {
		int pick = Ressources.Rand().nextInt(Philosopher.Philosophers.values().length);
		return Philosopher.createPhilosopher(Philosopher.Philosophers.values()[pick], true);
	}

	public void resumeGame() {
		if(!isRunning) start();
		setScreen(currentScreen);
	}

	public void quit() {
		Gdx.app.exit();		
	}

	public void restart() {
		start();
		resumeGame();		
	}

	void start() {
		isRunning = true;
		selectionScreen = new SelectionScreen(this);
		currentScreen = selectionScreen;
	}

}