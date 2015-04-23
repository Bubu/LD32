package com.ld32.philosophergame;

public abstract class FightState {

	public final boolean waitForClick = false;
	public boolean active;
	
	protected FightScreen screen; 

	public FightState(FightScreen screen, boolean active) {
		this.screen = screen;
		this.active = active;		
	}
	
	abstract public void performAction();

	abstract public FightState next();

}
