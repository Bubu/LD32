package com.ld32.philosophergame;

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

	public void create () {
		isRunning = false;
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void startFight() {
		currentScreen = fightscreen;
		player =  Philosopher.Nietzsche(false);
		opponent = Philosopher.Descartes(true);
		currentplayer = player; 
		fightscreen = new FightScreen(this);
		resumeGame();
		
	}

	public void resumeGame() {
		setScreen(currentScreen);
	}

	public void quit() {
		Gdx.app.exit();		
	}

	public void restart() {
		start();
		
	}

	void start() {
		isRunning = true;
		currentScreen = selectionScreen;
		selectionScreen = new SelectionScreen(this);
		setScreen(selectionScreen);
		
	}

}