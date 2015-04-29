package com.ld32.philosophergame.states;

import com.ld32.philosophergame.Fight;


public abstract class FightState {

	public boolean waitForClick;
	public boolean active;
	
	protected Fight fight; 

	public FightState(Fight fight, boolean active) {
		this.fight = fight;
		this.active = active;		
	}
	
	abstract public void performAction() throws Exception;

}
