package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
	StatusDisplay oppStatus;
	StatusDisplay playerStatus;
	
	public FightScreen(final PhilosopherGame game) {
		this.game = game;
		
		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));

		// Creation of speech bubble:
		leftBubble = new LeftBubble(game.player.phrases[0]);
		leftBubble.setVisible(false);
		rightBubble = new RightBubble(game.opponent.phrases[0]);
		rightBubble.setVisible(true);
		
		game.player.sprite.setPosition(20, 25);
		
		stage.addActor(generateTopTable());
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
	
	public Table generateTopTable(){
		oppStatus = new StatusDisplay(game.opponent);
		playerStatus = new StatusDisplay(game.player);
		
		Table topTable = new Table();
		topTable.setFillParent(true);
		topTable.top();
		
		topTable.add(playerStatus).top().pad(10).padRight(20);
		topTable.add(oppStatus).top().pad(10);
		topTable.add(game.opponent.sprite).height(150)
			.width(game.opponent.sprite.getWidth()* 100/game.opponent.sprite.getWidth())
			.pad(15);
		return topTable;
	}

	// %%%%% Attack Handlers %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public void handleAttack(Attack attack, Philosopher opponent){
		String feedback = game.player.doAttack(attack, opponent);
		updateUI();
		showAttackInfo(attack, feedback);
		showAttackMessage(attack);
	}
	
	private void updateUI() {
		oppStatus.setHp(game.opponent.currenthp);
		oppStatus.setSanity(game.opponent.currentSanity);
		playerStatus.setHp(game.player.currenthp);
		playerStatus.setSanity(game.player.currentSanity);
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
			handleAttack(game.opponent.choseRandomMove(game), game.player);
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
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.9f, 1);
		Gdx.input.setInputProcessor(stage);
	}
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
}
