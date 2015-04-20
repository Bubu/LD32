package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FightScreen extends ScreenAdapter {

	public static String n = System.getProperty("line.separator");

	PhilosopherGame game;
	Stage stage;
	Menu menu;
	Label infoText;
	LeftBubble leftBubble;
	RightBubble rightBubble;
	ProgressBar oppHealth;
	ProgressBar playerHealth;
	
	public FightScreen(final PhilosopherGame game) {
		this.game = game;
		
		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));

		// Creation of speech bubble:
		leftBubble = new LeftBubble(game.player.phrases[0]);
		leftBubble.setVisible(false);
		rightBubble = new RightBubble(game.opponent.phrases[0]);
		rightBubble.debug();
		rightBubble.setVisible(true);
		
		game.player.sprite.setPosition(20, 25);
		
		stage.addActor(generateOpponentTable());
		stage.addActor(generateMenuTable());
		stage.addActor(generateInfoTextTable());
		stage.addActor(game.player.sprite);
		stage.addActor(leftBubble);
		stage.addActor(rightBubble);
	}
	
	// %%%%% Table Generators %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public Table generateMenuTable(){
		menu = new Menu(Ressources.Skin());
		menu.updateMenu(game);
		Table menutable = new Table();
		menutable.setFillParent(true);
		menutable.right().bottom();
		menutable.add(menu);
		return menutable;
	}
	
	public Table generateInfoTextTable(){
		infoText = new Label("", Ressources.Skin());
		infoText.setVisible(false);
		Table infoTextTable = new Table();
		infoTextTable.setFillParent(true);
		infoTextTable.left().top();
		infoTextTable.add(infoText).padLeft(210).padTop(350);
		return infoTextTable;
	}
	
	public Table generateOpponentTable(){
		oppHealth = new ProgressBar(0, game.opponent.maxhp, 1, false, Ressources.Skin());
		oppHealth.setValue(game.opponent.currenthp);
		playerHealth = new ProgressBar(0, game.player.maxhp, 1, false, Ressources.Skin());
		playerHealth.setValue(game.player.currenthp);

		Table opponentTable = new Table();
		opponentTable.debugAll();
		opponentTable.setFillParent(true);
		opponentTable.right().top();
		opponentTable.add(playerHealth);
		opponentTable.add(oppHealth);
		opponentTable.add(game.opponent.sprite).height(150)
			.width(game.opponent.sprite.getWidth()* 100/game.opponent.sprite.getWidth())
			.pad(15);
		return opponentTable;
	}
	
	// %%%%% Attack Handlers %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public void handleAttack(Attack attack){
		String feedback = game.player.doAttack(attack, game.opponent);
		oppHealth.setValue(game.opponent.currenthp);
		showAttackInfo(attack, feedback);
		showAttackMessage(attack);
	}
	
	public void showAttackMessage(Attack attack){
		String message = attack.messages[Ressources.Rand().nextInt(attack.messages.length)];
		if(game.currentplayer == game.player){
			leftBubble.setVisible(true);
			leftBubble.setText(message);
			leftBubble.pack();
			rightBubble.setVisible(false);
		}else{
			rightBubble.setVisible(true);
			rightBubble.setText(message);
			rightBubble.pack();
			leftBubble.setVisible(false);
		}
	}

	public void showAttackInfo(Attack attack, String feedback) {
		game.fightscreen.infoText.setText(game.currentplayer.name + " uses \"" + attack.name + "\"" + n + feedback);
		game.fightscreen.infoText.setVisible(true);
		waitForClick(Ressources.AdvanceText);
	}

	protected boolean checkStatus() {
		//game.player.status
		return false;
	}	
	
	// %%%%% Turn Handlers %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public void waitForClick (final int action) {
		InputListener listener = new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ENTER){
					continueAction(action,this);
					return true;
				}
				else{
					return false;
				}
			}
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
					continueAction(action,this);
			}
		};
		game.fightscreen.stage.addListener(listener);
	}

	private void continueAction(final int action, InputListener listener){
		if (action == Ressources.AdvanceText) {
			advancePlayer();
		}
		stage.removeListener(listener);
	}
	
	private void advancePlayer() {
		if(game.currentplayer == game.player){
			game.currentplayer = game.opponent;
			handleAttack(game.opponent.choseRandomMove(game));
		}
		else{
			game.currentplayer = game.player;
			menu.setVisible(true);
			infoText.setVisible(false);
		}
	}

	protected void describeStatus(Status status) {
		Gdx.app.log("TODO!", "Describe Status");
	}

	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	public void show() {
		Gdx.gl.glClearColor(0.2f, 0.3f, 0.9f, 1);
		Gdx.input.setInputProcessor(stage);
	}
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
}
