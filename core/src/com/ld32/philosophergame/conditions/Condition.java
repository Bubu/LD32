package com.ld32.philosophergame.conditions;

import com.ld32.philosophergame.Philosopher;

public abstract class Condition{
	String name;
	int duration;
	public int currentDuration;
	int ident;
	public String activateMessage;

	public Condition(String name, int duration, String description){
		this.name = name;
		this.duration = duration;
		this.currentDuration = duration;
		this.activateMessage = description;
	}

	
	abstract public  String performCondition(Philosopher currentPlayer, Philosopher currentOpponent);
	
	public String toString(){
		return super.toString() + this.name;
	}
	
	@Override
	public boolean equals(Object other){
		return (other instanceof Condition) && (this.name.equals(((Condition)other).name));
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

}
