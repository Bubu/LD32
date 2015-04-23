package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

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

	public void showLoseMessage(Philosopher opponent) {
		leftBubble.setVisible(false);
		rightBubble.setVisible(true);
		rightBubble.setText(opponent.phrases[1]);
		rightBubble.pack();
	}

	public void showWinMessage() {
		Gdx.app.log("TODO", "Show win message!");
	}

	public void updateUI() {
		menu.updateMenu(game);
		oppStatus.setHp(game.opponent.currenthp);
		oppStatus.setSanity(game.opponent.currentSanity);
		playerStatus.setHp(game.player.currenthp);
		playerStatus.setSanity(game.player.currentSanity);
	}

	public void showAttackMessage(Attack attack){
		//Gdx.app.log("tag", fight.currentPlayer.name);
		String message = attack.messages[Ressources.Rand().nextInt(attack.messages.length)];
		if(game.fight.currentPlayer == game.player){
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

	public void showInfoText(String feedback) {
		infoText.setText(feedback);
		infoText.setVisible(true);
		game.fight.waitForClick(Ressources.AdvanceText);
	}

	public void showMenu(){
		menu.setVisible(true);
		infoText.setVisible(false);
	}

	// %%%%% Turn Handlers %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


	protected void describeStatus(Status status) {
		Gdx.app.log("TODO!", "Describe Status");
	}
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

}
