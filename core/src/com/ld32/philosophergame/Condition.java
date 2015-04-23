package com.ld32.philosophergame;

public class Condition {
	String name;
	int duration;
	int currentDuration;
	int ident;

	public Condition(int ident, String name, int duration){
		this.name = name;
		this.duration = duration;
		this.currentDuration = duration;
		this.ident = ident;
		//this.message = description;
	}
	// TODO Auto-generated constructor stub

	public static Condition Thinking(){
		return new Condition(0, "Thinking", 2);
	}

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
	
	public String toString(){
		return super.toString() + this.name;
	}

}
