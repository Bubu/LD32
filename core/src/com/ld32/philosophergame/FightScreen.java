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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FightScreen extends ScreenAdapter {

	public static String n = System.getProperty("line.separator");

	PhilosopherGame game;
	Stage stage;
	Menu menu;
	Label infoText;
	
	public FightScreen(final PhilosopherGame game) {
		this.game = game;
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport());
		stage.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ESCAPE ){
					game.setScreen(game.menuScreen);
					return true;
				}
				else{
					return false;
				}
		 	}
		});
		
		infoText = new Label("", skin);
		infoText.setVisible(false);
		ProgressBar oppHealth = new ProgressBar(0, game.opponent.maxhp, 1, false, skin);
		oppHealth.setValue(game.opponent.currenthp);

		menu = new Menu(skin);
		menu.updateMenu(game);
		

		game.player.sprite.setPosition(20, 25);
		
		Table menutable = new Table();

		menutable.setFillParent(true);
		menutable.right().bottom();
		
		Table infoTextTable = new Table();
		infoTextTable.setFillParent(true);
		infoTextTable.left().top();
		
		infoTextTable.add(infoText).padLeft(210).padTop(350);
		
		Table opponentTable = new Table();
		opponentTable.debugAll();
		opponentTable.setFillParent(true);
		opponentTable.right().top();
		opponentTable.add(oppHealth);
		opponentTable.add(game.opponent.sprite).height(150)
			.width(game.opponent.sprite.getWidth()* 100/game.opponent.sprite.getWidth())
			.pad(15);
		
		stage.addActor(opponentTable);
		stage.addActor(menutable);
		stage.addActor(infoTextTable);
		stage.addActor(game.player.sprite);
		
		menutable.add(menu);


	}
	
	public void handleAttack(Attack attack){
		String feedback = game.player.doAttack(attack, game.opponent);
		showAttackInfo(attack, feedback);
	}

	private void showAttackInfo(Attack attack, String feedback) {
		game.fightscreen.menu.setVisible(false);
		game.fightscreen.infoText.setText(game.player.name + " uses \"" + attack.name + "\"" + n + feedback);
		game.fightscreen.infoText.setVisible(true);
		game.fightscreen.stage.addListener(new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ENTER){
					advanceText(this,game.opponent);
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
				advanceText(this,game.opponent);
			}
		});
	}

	protected boolean checkStatus() {
		game.player.status
		return false;
	}

	protected void describeAttack(Attack attack) {
		Gdx.app.log("TODO!", "Describe Attack");
	}
	
	protected void describeStatus(Status status) {
		Gdx.app.log("TODO!", "Describe Attack");
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

	private void advanceText(InputListener listener, Philosopher next) {
		game.fightscreen.menu.setVisible(true);
		game.fightscreen.infoText.setVisible(false);
		game.fightscreen.stage.removeListener(listener);
		if(!(next == game.player)){
			next.chooseMove(game.player);
		}
	}

}
