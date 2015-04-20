package com.ld32.philosophergame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
	public LinkedList<String> fought;
	public boolean needNextOpponent;

	public void create () {
		fought = new LinkedList<String>();
		isRunning = false;
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void startFight() {
		opponent = getNextOpponent();
		if(opponent == null){
			setScreen(new WinScreen(this));
			return;
		}
		needNextOpponent = false;
		currentplayer = player; 
		player.currenthp = player.maxhp;
		player.currentSanity = player.sanity;
		fightscreen = new FightScreen(this);
		currentScreen = fightscreen;
		setScreen(currentScreen);
	}

	private Philosopher getNextOpponent() {
		List<String> toFight = new LinkedList<String>(Arrays.asList(Philosopher.PhilosopherNames));
		Gdx.app.log("Debug", player.name);
		toFight.remove(player.name);
		toFight.removeAll(fought);
		int pick = Ressources.Rand().nextInt(toFight.size());
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