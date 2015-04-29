package com.ld32.philosophergame;

import com.ld32.philosophergame.states.FightState;

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
