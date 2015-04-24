package com.ld32.philosophergame;

public abstract class FightState {

	public boolean waitForClick;
	public boolean active;
	
	protected Fight fight; 

	public FightState(Fight fight, boolean active) {
		this.fight = fight;
		this.active = active;		
	}
	
	abstract public void performAction() throws Exception;

	abstract public FightState next();

}
