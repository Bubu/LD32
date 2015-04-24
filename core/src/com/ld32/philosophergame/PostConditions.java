package com.ld32.philosophergame;

public class PostConditions extends FightState {

	public PostConditions(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
	}

	@Override
	public void performAction() throws Exception {
		
		fight.advanceState(false);
	}
	
	public void addCondition(Philosopher philosopher, Condition condition){
		philosopher.addPostCondition(condition);
		active = true;
	}

}
