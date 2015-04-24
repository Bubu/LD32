package com.ld32.philosophergame;


public class PlayerAttack extends FightState {

	public PlayerAttack(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;		
	}

	@Override
	public void performAction() {
		this.waitForClick = false;
		fight.fightscreen.showMenu();
	}
	
	public void performPlayerAttack(Attack attack){
		String message = attack.messages[Ressources.Rand().nextInt(attack.messages.length)];
		fight.fightscreen.showPlayerBubble(message);
		String attackText = fight.game.player.doAttack(attack, fight.game.opponent);
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
