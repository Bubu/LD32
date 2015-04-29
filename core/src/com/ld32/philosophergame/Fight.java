package com.ld32.philosophergame;

import java.util.ArrayList;
import java.util.Iterator;

import com.ld32.philosophergame.states.CheckWin;
import com.ld32.philosophergame.states.FightState;
import com.ld32.philosophergame.states.OppenentTurn;
import com.ld32.philosophergame.states.PlayerAttack;
import com.ld32.philosophergame.states.CheckPostConditions;
import com.ld32.philosophergame.states.CheckPreConditions;



public class Fight {

	public PhilosopherGame game;
	public Philosopher currentPlayer;
	public FightScreen fightscreen;
	FightState currentState;
	ArrayList<FightState> stateList;
	Iterator<FightState> states;
	public PlayerAttack playerAttack;
	protected CheckPreConditions playerPre;
	protected CheckPreConditions opponentPre;
	public static String n = "\n";

	public Philosopher currentOpponent(){
		if (currentPlayer == game.player)
			return game.opponent;
		else return game.player;
	}

	public Fight(PhilosopherGame game, Philosopher player, Philosopher opponent, FightScreen fightscreen) throws Exception {
		this.stateList = new ArrayList<FightState>();
		generateStates();
		playerAttack = (PlayerAttack) stateList.get(2); // gets PlayerAttack		
		states = stateList.iterator();
		currentState = states.next();
		playerPre = (CheckPreConditions) stateList.get(0);
		opponentPre = (CheckPreConditions) stateList.get(7);
		this.currentPlayer = player;
		this.fightscreen = fightscreen;
		this.game = game;
		advanceState(false);
	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private void generateStates() {
		stateList.add(new CheckPreConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new PlayerAttack(this, true));
		stateList.add(new CheckWin(this, true));
		stateList.add(new CheckPostConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new AdvanceTurn(this, true));
		stateList.add(new CheckPreConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new OppenentTurn(this, true));
		stateList.add(new CheckWin(this, true));
		stateList.add(new CheckPostConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new AdvanceTurn(this, true));
	}	
	
	public void advanceState(boolean clicked) throws Exception{
		if(currentState.waitForClick == clicked){
			if (game.needNextOpponent){
				game.fought.add(game.opponent.name);
				game.startFight();
				return;
			}else if (game.tryAgain){
				game.startFight();
				return;
			}
			FightState oldState = currentState;
			while(true){
				if(states.hasNext()) currentState = states.next();
				else {
					states = stateList.iterator();
					currentState = states.next();
				}
				if (currentState.active){
					break;
				}
				if (currentState == oldState){
					throw new Exception("Enless loop. No state active!");
				}
			}			
			currentState.performAction();
		}
	}

	public void activateOpponentPre() {
		opponentPre.active = true;		
	}

	public void activatePlayerPre() {
		playerPre.active = true;		
	}

}
