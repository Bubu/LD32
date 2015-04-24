package com.ld32.philosophergame;

import java.util.Iterator;

public class PreConditions extends FightState {

	public PreConditions(Fight fight, boolean active) {
		super(fight, active);
		this.waitForClick = false;
	}

	@Override
	public void performAction() throws Exception {
		String conditionMessage="";
		Iterator<Condition> it = fight.currentPlayer.preConditions.iterator();
		while(it.hasNext()){
			Condition currentCondition=it.next();
			conditionMessage += currentCondition.performCondition(fight.currentPlayer, fight.currentOpponent());
			if(currentCondition.currentDuration == 0){
				it.remove();
				if(fight.currentPlayer.preConditions.isEmpty()) active = false;
			}
		}

		fight.fightscreen.showInfoText(conditionMessage);
		waitForClick = true;
	}
	
	public void addCondition(Philosopher philosopher, Condition condition){
		philosopher.addPostCondition(condition);
		active = true;
	}

}
