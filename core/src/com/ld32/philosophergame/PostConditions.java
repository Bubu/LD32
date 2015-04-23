package com.ld32.philosophergame;

public class PostConditions extends FightState {
	public final boolean waitForClick = true;

	public PostConditions(FightScreen screen, boolean active) {
		super(screen, active);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public FightState next() {
		// TODO Auto-generated method stub
		return null;
	}

}
