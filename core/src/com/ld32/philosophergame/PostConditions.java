package com.ld32.philosophergame;

public class PostConditions extends FightState {
	public final boolean waitForClick = true;

	public PostConditions(Fight fight, boolean active) {
		super(fight, active);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performAction() throws Exception {
		
		fight.advanceState(false);
	}

	@Override
	public FightState next() {
		// TODO Auto-generated method stub
		return null;
	}

}
