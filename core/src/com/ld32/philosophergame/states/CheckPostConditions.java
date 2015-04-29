package com.ld32.philosophergame.states;


import com.ld32.philosophergame.Fight;
import com.ld32.philosophergame.Philosopher;
import com.ld32.philosophergame.conditions.Condition;

public class CheckPostConditions extends FightState {

	public CheckPostConditions(Fight fight, boolean active) {
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
