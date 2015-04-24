package com.ld32.philosophergame;


public class PlayerAttack extends AttackState {

	public PlayerAttack(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;		
	}

	@Override
	public void performAction() throws Exception {
		this.waitForClick = false;
		if(fight.currentPlayer.attacking){
			fight.fightscreen.showMenu();
		}
		else fight.advanceState(false);

	}
	
	public void performPlayerAttack(Attack attack) throws Exception{
			String message = handleAttack(attack);
			fight.fightscreen.showPlayerBubble(message);
	}

}
