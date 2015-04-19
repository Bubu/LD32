package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
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
	ProgressBar oppHealth;
	ProgressBar playerHealth;
	
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
		oppHealth = new ProgressBar(0, game.opponent.maxhp, 1, false, skin);
		oppHealth.setValue(game.opponent.currenthp);
		playerHealth = new ProgressBar(0, game.player.maxhp, 1, false, skin);
		playerHealth.setValue(game.player.currenthp);

		menu = new Menu(skin);
		menu.updateMenu(game);
		
		// Creation of speech bubble
		NinePatch bubblePatchLeft = new NinePatch(new Texture(Gdx.files.internal("BubbleLeft.png")), 49, 49, 24, 56);
		skin.add("bubbleBackgroundLeft",bubblePatchLeft);
		LabelStyle bubbleStyleLeft = new LabelStyle(skin.getFont("default-font"), skin.getColor("white"));
		Label bubbleLeft = new Label("\n\rSassssssss\n\rdassssssssssssssssssssssssss                              \n\r\n\r", bubbleStyleLeft);
		bubbleLeft.debug();
		bubbleStyleLeft.background = skin.getDrawable("bubbleBackgroundLeft");
		
		NinePatch bubblePatchRight = new NinePatch(new Texture(Gdx.files.internal("BubbleLeft.png")), 14, 37, 14, 50);
		skin.add("bubbleBackgroundRight",bubblePatchRight);
		LabelStyle bubbleStyleRight = new LabelStyle(skin.getFont("default-font"), skin.getColor("white"));
		Label bubbleRight = new Label("", bubbleStyleRight);
		bubbleStyleRight.background = skin.getDrawable("bubbleBackgroundRight");
		
		bubbleLeft.setPosition(30, 150);
		bubbleRight.setPosition(20, 30);
		
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
		opponentTable.add(playerHealth);
		opponentTable.add(oppHealth);
		opponentTable.add(game.opponent.sprite).height(150)
			.width(game.opponent.sprite.getWidth()* 100/game.opponent.sprite.getWidth())
			.pad(15);
		
		stage.addActor(opponentTable);
		stage.addActor(menutable);
		stage.addActor(infoTextTable);
		stage.addActor(game.player.sprite);
		stage.addActor(bubbleLeft);
		//stage.addActor(bubbleRight);
		
		menutable.add(menu);
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
		if(!(game.currentplayer != game.player)){
			game.currentplayer = game.opponent;
			game.opponent.chooseMove(game);
		}
		else{
			game.currentplayer = game.player;
		}
	}

}
