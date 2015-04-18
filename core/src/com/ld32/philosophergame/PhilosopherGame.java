package com.ld32.philosophergame;

import com.badlogic.gdx.Game;
public class PhilosopherGame extends Game {
	MenuScreen menuScreen;
	FightScreen fightscreen;

	public void create () {
		menuScreen = new MenuScreen(this);
		fightscreen = new FightScreen(this);
		setScreen(menuScreen);              
	}

}