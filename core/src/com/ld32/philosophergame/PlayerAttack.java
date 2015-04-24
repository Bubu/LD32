package com.ld32.philosophergame;


public class PlayerAttack extends AttackState {

	public PlayerAttack(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;		
	}

	@Override
	public void performAction() {
		this.waitForClick = false;
		fight.fightscreen.showMenu();
	}
	
	public void performPlayerAttack(Attack attack) throws Exception{
		if(fight.currentPlayer.attacking){
			String message = handleAttack(attack);
			fight.fightscreen.showPlayerBubble(message);
		}
		else fight.advanceState(false);
	}

}
