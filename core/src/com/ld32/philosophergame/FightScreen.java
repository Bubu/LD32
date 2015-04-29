package com.ld32.philosophergame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ld32.philosophergame.gui.LeftBubble;
import com.ld32.philosophergame.gui.Menu;
import com.ld32.philosophergame.gui.RightBubble;
import com.ld32.philosophergame.gui.StatusDisplay;

public class FightScreen extends ScreenAdapter {

	public static String n = "\n"; //Ressources.getLineSeparator();

	PhilosopherGame game;
	Stage stage;
	Menu menu;
	Label infoText;
	LeftBubble leftBubble;
	RightBubble rightBubble;
	StatusDisplay oppStatus;
	StatusDisplay playerStatus;
	//Fight fight;

	public FightScreen(final PhilosopherGame game) {
		this.game = game;
		//this.fight = game.fight;

		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));

		// Creation of speech bubble:
		leftBubble = new LeftBubble(game.player.phrases[0]);
		leftBubble.setVisible(false);
		Table bubbleTable = new Table(Ressources.Skin());
		bubbleTable.setFillParent(true);
		rightBubble = new RightBubble(game.opponent.phrases[0]);
		if(game.opponent.phrases[0] != null){
			rightBubble.setVisible(true);
		}
		else rightBubble.setVisible(false);

		bubbleTable.add(rightBubble);

		game.player.sprite.setPosition(20, 25);

		stage.addActor(generateTopTable());
		stage.addActor(generateMenuTable());
		stage.addActor(generateInfoTextTable());
		stage.addActor(game.player.sprite);
		stage.addActor(leftBubble);
		stage.addActor(bubbleTable);
		stage.addListener(getClickListener());
	}

	// %%%%% Table Generators %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	private EventListener getClickListener() {
		InputListener listener = new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ENTER){
					try {
						game.fight.advanceState(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
				try {
					game.fight.advanceState(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		return listener;
	}

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
		infoText = new Label("", Ressources.Skin().get("info",LabelStyle.class));
		infoText.setVisible(false);
		infoText.setAlignment(Align.topLeft);
		Table infoTextTable = new Table();
		infoTextTable.setFillParent(true);
		infoTextTable.right().bottom();
		infoTextTable.add(infoText).height(143).width(442);
		return infoTextTable;
	}

	public Table generateTopTable(){
		oppStatus = new StatusDisplay(game.opponent);
		playerStatus = new StatusDisplay(game.player);

		Table topTable = new Table();
		topTable.setFillParent(true);
		topTable.top();

		Table description = new Table(Ressources.Skin());
		description.add().row();
		description.add("Conviction: ").row();
		description.add("Sanity: ").row();

		topTable.add(description).top().pad(10).padTop(36);
		topTable.add(playerStatus).top().pad(10).padRight(20);
		topTable.add(oppStatus).top().pad(10);
		topTable.add(game.opponent.sprite).height(150)
		.width(game.opponent.sprite.getWidth()* 100/game.opponent.sprite.getWidth())
		.pad(15);
		return topTable;
	}

	// %%%%%  Show messages and stuff %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public void updateUI() {
		menu.updateMenu(game);
		oppStatus.setHp(game.opponent.currenthp);
		oppStatus.setSanity(game.opponent.currentSanity);
		playerStatus.setHp(game.player.currenthp);
		playerStatus.setSanity(game.player.currentSanity);
	}

	public void showInfoText(String feedback) {
		infoText.setText(feedback);
		infoText.setVisible(true);
	}

	public void showMenu(){
		menu.setVisible(true);
		infoText.setVisible(false);
	}

	// %%%%% Turn Handlers %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%



	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.getBatch().begin();
		stage.getBatch().draw(Ressources.Background(0), 0,0);
		stage.getBatch().end();
		stage.draw();
	}
	public void show() {
		updateUI();
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.9f, 1);
		Gdx.input.setInputProcessor(stage);
	}
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public void showOpponentBubble(String message) {
		rightBubble.setVisible(true);
		rightBubble.setText(message);
		rightBubble.pack();
		leftBubble.setVisible(false);
		
	}

	public void showPlayerBubble(String message) {
		leftBubble.setVisible(true);
		leftBubble.setText(message);
		leftBubble.pack();
		rightBubble.setVisible(false);
	}

}
