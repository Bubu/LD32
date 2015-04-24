package com.ld32.philosophergame;


public class Condition{
	String name;
	int duration;
	int currentDuration;
	int ident;
	String activateMessage;

	public Condition(int ident, String name, int duration, String description){
		this.name = name;
		this.duration = duration;
		this.currentDuration = duration;
		this.ident = ident;
		this.activateMessage = description;
	}

	public static Condition Thinking(){
		return new Condition(0, "Thinking", 2, "has to think about this.");
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
	
	public boolean equals(Condition other){
		return this.name == other.name;
	}

}
