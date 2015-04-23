package com.ld32.philosophergame;


public class PlayerAttack extends FightState {
	public final boolean waitForClick = true;

	public PlayerAttack(FightScreen screen, boolean active) {
		super(screen, active);
		
	}

	@Override
	public void performAction() {
		screen.showMenu();
	}

	@Override
	public FightState next() {
		// TODO Auto-generated method stub
		return null;
	}

}
