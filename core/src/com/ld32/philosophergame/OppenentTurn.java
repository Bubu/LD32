package com.ld32.philosophergame;

public class OppenentTurn extends AttackState {

	public OppenentTurn(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
	}

	@Override
	public void performAction() throws Exception {
		this.waitForClick = false;
		Attack attack = fight.game.opponent.choseRandomMove(fight.game);
		if(fight.currentPlayer.attacking){
			String message = handleAttack(attack);
			fight.fightscreen.showOpponentBubble(message);
		}
		else fight.advanceState(false);
	}

}
