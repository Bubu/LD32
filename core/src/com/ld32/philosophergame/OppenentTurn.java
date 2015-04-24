package com.ld32.philosophergame;

public class OppenentTurn extends FightState {

	public OppenentTurn(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
	}

	@Override
	public void performAction() {
		this.waitForClick = false;
		Attack attack = fight.game.opponent.choseRandomMove(fight.game);
		String message = attack.messages[Ressources.Rand().nextInt(attack.messages.length)];
		fight.fightscreen.showOpponentBubble(message);
		
		String attackText = fight.game.opponent.doAttack(attack, fight.game.player);
		fight.fightscreen.updateUI();
		fight.fightscreen.showInfoText(attackText);
		
		this.waitForClick = true;
	}

	@Override
	public FightState next() {
		// TODO Auto-generated method stub
		return null;
	}

}
