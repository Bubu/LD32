package com.ld32.philosophergame;

public class CheckWin extends FightState {

	public CheckWin(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
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
