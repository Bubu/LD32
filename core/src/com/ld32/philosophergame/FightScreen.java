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
	ProgressBar oppHealth;
	ProgressBar playerHealth;
	
	public FightScreen(final PhilosopherGame game) {
		this.game = game;
		
		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));
		

		menu = new Menu(Ressources.Skin());
		menu.updateMenu(game);
		
		// Creation of speech bubble
		LeftBubble bubbleLeft = new LeftBubble("Hallo");
		bubbleLeft.debug();
		RightBubble bubbleRight = new RightBubble("Sassssssss\n\rdassssssssssssssssssssssssss");
		bubbleRight.setVisible(true);
		
		game.player.sprite.setPosition(20, 25);
		
		Table menutable = new Table();

		menutable.setFillParent(true);
		menutable.right().bottom();
		
		stage.addActor(generateOpponentTable());
		stage.addActor(menutable);
		stage.addActor(generateInfoTexttable());
		stage.addActor(game.player.sprite);
		stage.addActor(bubbleLeft);
		stage.addActor(bubbleRight);
		
		menutable.add(menu);
	}
	
	
	
	public Table generateInfoTexttable(){
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
	
	public void handleAttack(Attack attack){
		String feedback = game.player.doAttack(attack, game.opponent);
		oppHealth.setValue(game.opponent.currenthp);
		showAttackInfo(game.player, attack, feedback);
	}

	public void showAttackInfo(Philosopher phil, Attack attack, String feedback) {
		game.fightscreen.menu.setVisible(false);
		game.fightscreen.infoText.setText(phil.name + " uses \"" + attack.name + "\"" + n + feedback);
		game.fightscreen.infoText.setVisible(true);
		game.fightscreen.stage.addListener(new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ENTER){
					advanceText(this);
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
				advanceText(this);
			}
		});
	}

	protected boolean checkStatus() {
		//game.player.status
		return false;
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

	private void advanceText(InputListener listener) {
		game.fightscreen.menu.setVisible(true);
		game.fightscreen.infoText.setVisible(false);
		game.fightscreen.stage.removeListener(listener);
		if(game.currentplayer == game.player){
			game.currentplayer = game.opponent;
			game.opponent.chooseMove(game);
		}
		else{
			game.currentplayer = game.player;
		}
	}

}
