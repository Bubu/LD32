package com.ld32.philosophergame.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ld32.philosophergame.Philosopher;
import com.ld32.philosophergame.PhilosopherGame;
import com.ld32.philosophergame.Ressources;
import com.ld32.philosophergame.Philosopher.Philosophers;

public class SelectionScreen extends ScreenAdapter {
	PhilosopherGame game;
	Stage stage;
	public SelectionScreen(final PhilosopherGame game) {
		this.game = game;
		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));

		Table table = new Table();
		stage.addActor(table);		
		table.center();		
		table.setFillParent(true);
		Label titel = new Label("Select your character!", Ressources.Skin().get("title",LabelStyle.class));
		Table charTable = new Table();
		
		int i = 0;
		for(final Philosophers phil: Philosopher.Philosophers.values()){
			Image philImage = new Image(new TextureRegionDrawable(Ressources.getPhilosopherSprite(phil)));
			philImage.setScaling(Scaling.fillY);
			philImage.addListener(new InputListener() {
				@Override
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					game.player = Philosopher.createPhilosopher(phil.toString(), false);
					try {
						game.startFight();
					} catch (Exception e) {
						Gdx.app.log("Exception", "Endless loop detected. No active States.");
						e.printStackTrace();
					}
					return true;
				}
			});
			Table philTable = new Table();
			philTable.add(philImage).size(120).row();
			philTable.add(new Label(phil.toString(), Ressources.Skin()));
			if(i%4 == 0) charTable.row();
			charTable.add(philTable);
			i++;
		}
		
		table.add(titel);
		table.row();
		table.add(charTable);
	}
	
	@Override
	public void show() {
		Gdx.gl.glClearColor(0.7f, 0.3f, 0.9f, 1);
		Gdx.input.setInputProcessor(stage);
	}

	@Override	
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.getBatch().begin();
		stage.getBatch().draw(Ressources.Background(0), 0,0);
		stage.getBatch().end();
		stage.draw();
	}
	
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	public void dispose () {
		stage.dispose();
	}
}
