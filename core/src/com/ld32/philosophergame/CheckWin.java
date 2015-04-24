package com.ld32.philosophergame;

public class CheckWin extends FightState {
	public static String n = "\n";

	public CheckWin(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
	}

	@Override
	public void performAction() throws Exception {

		String winnerText = "";
		boolean won = false;
		String message = "";
		if(fight.game.opponent.currenthp <= 0 && fight.game.player.currenthp <= 0){
			winnerText = "Err... somehow you managed to convince each other "+ n +"of the opposing views. Try again!";
			message = fight.game.opponent.phrases[2];
			won = true;
			fight.game.tryAgain = true;
		}
		else if(fight.game.opponent.currenthp <= 0){
			winnerText = n + "You conviced " + fight.game.opponent.name + " of your philosophy!";
			message = fight.game.opponent.phrases[1];
			won = true;
			fight.game.needNextOpponent = true;
		}
		else if(fight.game.player.currenthp <= 0){
			winnerText = n + "You failed to convince " + fight.game.opponent.name + "! Try Again.";
			message = fight.game.opponent.phrases[2];
			won = true;
			fight.game.tryAgain = true;
		}
		if(won){
			fight.fightscreen.showOpponentBubble(message);
			fight.fightscreen.showInfoText(winnerText);
			this.waitForClick = true;
		}
		else fight.advanceState(false);
	}
}
