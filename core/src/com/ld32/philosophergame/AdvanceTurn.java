package com.ld32.philosophergame;

public class AdvanceTurn extends FightState {
	
	public AdvanceTurn(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
		
	}

	@Override
	public void performAction() throws Exception {
		fight.currentPlayer = fight.currentOpponent();
		fight.currentPlayer.attacking=true;
		fight.currentPlayer.cooldownAttacks();
		
		fight.advanceState(false);
	}

}
