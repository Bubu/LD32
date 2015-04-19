package com.ld32.philosophergame;

public class Status {
	String name;
	int coolDown;
	float hpDamage;
	float hpRestore;
	float sanityDamage;
	float sanityRestore;
	String message;

	public static Status Thinking(){
		String message = "I have to think about this...";
		return new Status("Thinking", 0, 0, 0, 0, 0, message);
	}
	
	public static Status EternalReturn(){
		String message = "All of this has happened before and will happen again.";
		return new Status("Eternal Return", 20, 0, 5, 0, 0, message);
	}
	
	public static Status Return(){
		String message = "All of this has happened before and will happen again.";
		return new Status("Eternal Return", 20, 0, 5, 0, 0, message);
	}
	
	public static Status Tabu(){
		String message = "All of this has happened before and will happen again.";
		return new Status("Eternal Return", 20, 0, 5, 0, 0, message);
	}
	
	public Status(String name, int coolDown, float hpDamage, float hpRestore, float sanityDamage, float sanityRestore, String message) {
		this.name = name;
		this.coolDown = coolDown;
		this.hpDamage = hpDamage;
		this.hpRestore = hpRestore;
		this.sanityDamage = sanityDamage;
		this.sanityRestore = sanityRestore;
	}

	public Status() {
		this.name = "Stub";
	}

	

}