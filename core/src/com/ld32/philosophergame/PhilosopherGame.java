package com.ld32.philosophergame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.ld32.philosophergame.gui.MenuScreen;
import com.ld32.philosophergame.gui.SelectionScreen;
import com.ld32.philosophergame.gui.WinScreen;

public class PhilosopherGame extends Game {
	MenuScreen menuScreen;
	FightScreen fightscreen;
	public Fight fight;
	SelectionScreen selectionScreen;
	public boolean isRunning;
	public Philosopher player;
	public Philosopher opponent;
	private Screen currentScreen;
	public LinkedList<String> fought;
	public boolean needNextOpponent = false;
	public boolean tryAgain = false;

	public void create () {
		isRunning = false;
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void startFight() throws Exception {
		if(!tryAgain){
			opponent = getNextOpponent();
		}
		if(opponent == null){
			setScreen(new WinScreen(this));
			return;
		}
		needNextOpponent = false;
		tryAgain = false;
		player.heal();
		opponent.heal(); 
		player.resetCooldowns();
		fightscreen = new FightScreen(this);
		fight = new Fight(this, player, opponent, fightscreen);
		
		currentScreen = fightscreen;
		setScreen(currentScreen);
	}

	private Philosopher getNextOpponent() {
		List<String> toFight = new LinkedList<String>(Arrays.asList(Philosopher.PhilosopherNames));
		toFight.remove(player.name);
		toFight.removeAll(fought);
		if (toFight.size() == 0) return null;
		int pick = Ressources.Rand().nextInt(toFight.size());
		return Philosopher.createPhilosopher(toFight.get(pick), true);
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
		fought = new LinkedList<String>();
		tryAgain = false;
		isRunning = true;
		selectionScreen = new SelectionScreen(this);
		currentScreen = selectionScreen;
	}

}