package com.ld32.philosophergame.conditions;

import com.ld32.philosophergame.Philosopher;

public class ThinkingCondition extends Condition {

	
	public String performCondition(Philosopher currentPlayer, Philosopher currentOpponent){
		
		String conditionInfo = "";
		switch(ident){
		case 0:
			currentPlayer.attacking = false;
			conditionInfo = currentPlayer.name + " is still thinking.";
			currentDuration -=1;
		}

		return conditionInfo;
	}
	
}
