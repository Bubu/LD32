package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SelectionScreen extends ScreenAdapter {
	PhilosopherGame game;
	Stage stage;
	public SelectionScreen(final PhilosopherGame game) {
		this.game = game;
		Gdx.app.log("Test", "Creating selection screen");
				
		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));

		VerticalGroup group = new VerticalGroup();
		stage.addActor(group);		
		group.center();		
		Label titel = new Label("Select your character!", Ressources.Skin());
		
		group.addActor(titel);
		
		group.space(20);
		group.padBottom(300);
		group.setSize(group.getPrefWidth(), group.getPrefHeight());
		group.setPosition((stage.getWidth() - group.getWidth())/2, (stage.getHeight() - group.getHeight())/2);

	}
	
	@Override
	public void show() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.input.setInputProcessor(stage);
	}

	@Override	
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	public void dispose () {
		stage.dispose();
	}
}
