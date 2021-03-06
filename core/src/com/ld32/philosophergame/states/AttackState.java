package com.ld32.philosophergame.states;


import com.ld32.philosophergame.Attack;
import com.ld32.philosophergame.Fight;
import com.ld32.philosophergame.Ressources;
import com.ld32.philosophergame.conditions.Condition;

public abstract class AttackState extends FightState {
	private static String n = "\n";

	public AttackState(Fight fight, boolean active) {
		super(fight, active);
	}

	protected String handleAttack(Attack attack) throws Exception{
		String bubbleMessage = attack.messages[Ressources.Rand().nextInt(attack.messages.length)];
		String attackText = fight.currentPlayer.doAttack(attack, fight.currentOpponent());
		attackText += handleConditions(attack);
		fight.fightscreen.updateUI();
		fight.fightscreen.showInfoText(attackText);
		this.waitForClick = true;
		return bubbleMessage;

	}

	protected String handleConditions(Attack attack) {
		if(Ressources.Rand().nextFloat() < attack.thinkingChance){
			Condition condition = Condition.Thinking();
			if(fight.currentOpponent().addPreCondition(condition)){
				if(fight.game.opponent == fight.currentOpponent()){
					fight.activateOpponentPre();
				}
				else{
					fight.activatePlayerPre();
				}
				return n + fight.currentOpponent().name + " " + condition.activateMessage;
			}
		}
		return "";
	}

}