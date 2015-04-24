package com.ld32.philosophergame;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.Gdx;

public class Fight {

	PhilosopherGame game;
	Philosopher currentPlayer;
	FightScreen fightscreen;
	FightState currentState;
	ArrayList<FightState> stateList;
	Iterator<FightState> states;
	protected PlayerAttack playerAttack;
	public static String n = "\n";

	Philosopher currentOpponent(){
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
		this.currentPlayer = player;
		this.fightscreen = fightscreen;
		this.game = game;
		advanceState(false);
	}

	// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private void generateStates() {
		stateList.add(new PreConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new PlayerAttack(this, true));
		stateList.add(new CheckWin(this, true));
		stateList.add(new PostConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new AdvanceTurn(this, true));
		stateList.add(new PreConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new OppenentTurn(this, true));
		stateList.add(new CheckWin(this, true));
		stateList.add(new PostConditions(this, false));
		stateList.add(new CheckWin(this, true));
		stateList.add(new AdvanceTurn(this, true));
	}

	private void advancePlayer() {
		currentPlayer = currentOpponent();
		currentPlayer.attacking=true;
		startTurn();
	}

	private void startTurn(){
		currentPlayer.cooldownAttacks();
		if(!currentPlayer.preConditions.isEmpty()){
			handlePreConditions();
		}else{
			selectAttack();
		}
	}

	private void handlePreConditions(){
		String conditionMessage="";
		Iterator<Condition> it = currentPlayer.preConditions.iterator();
		while(it.hasNext()){
			Condition currentCondition=it.next();
			conditionMessage += currentCondition.performCondition(currentPlayer, currentOpponent());
			if(currentCondition.currentDuration == 0){
				currentPlayer.preConditions.remove(currentCondition);
			}
		}

		fightscreen.showInfoText(conditionMessage);
		//waitForClick(Ressources.selectAttack);
	}

	private void selectAttack(){

		if(currentPlayer.attacking){
			if(currentPlayer==game.player){
				fightscreen.showMenu();
			}else{
				handleAttack(game.opponent.choseRandomMove(game), game.player);
			}
		}else{
			checkPostConditions();
		}
	}

	public void handleAttack(Attack attack, Philosopher opponent){

		fightscreen.showAttackBubble(attack);

		String attackText = currentPlayer.doAttack(attack, opponent);
		fightscreen.updateUI();
		//attackText += checkForWinner();

		fightscreen.showInfoText(attackText);
	}

	public void checkPostConditions(){
		advancePlayer();
	}

	public String checkForWinner(){
		String winnerText = "";
		if(game.player != game.opponent && game.opponent.currenthp <= 0){
			winnerText += n + "You conviced " + game.opponent.name + " of your philosophy!";
			fightscreen.showWinMessage();
			fightscreen.showLoseMessage(game.opponent);
			game.needNextOpponent = true;
		}
		if(game.player.currenthp <= 0){
			winnerText += n + "You failed to convince " + game.opponent.name + "! Try Again.";
			//showWinMessage();
			//showLoseMessage(opponent);
			game.tryAgain = true;
		}
		return winnerText;
	}

	// %%%%% Waiting for human player %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	
	void advanceState(boolean clicked) throws Exception{
		Gdx.app.log("Debug", currentState.toString());
		if(currentState.waitForClick == clicked){
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
					throw new Exception("Enless loop. No state active!");				}
			}			
			currentState.performAction();
		}
	}


	private void continueAction(final int action) throws Exception{
		if (game.needNextOpponent){
			game.fought.add(game.opponent.name);
			game.startFight();
			return;
		}else if (game.tryAgain){
			game.startFight();
			return;
		}
		if (action == Ressources.AdvanceText) {
			advancePlayer();
		}else if(action == Ressources.GoToMenu){
			fightscreen.showMenu();
		}else if(action == Ressources.OpponentAttack){
			handleAttack(game.opponent.choseRandomMove(game), game.player);
		}else if(action == Ressources.selectAttack){
			selectAttack();
		}
	}




}
