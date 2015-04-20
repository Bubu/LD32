package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class WinScreen extends ScreenAdapter implements Screen {
	PhilosopherGame game;
	Stage stage;

	static String n = System.getProperty("line.separator");

	public WinScreen(final PhilosopherGame game) {
		this.game = game;
		stage = new Stage(new ScreenViewport());
		stage.addListener(Ressources.EscListener(game));
		Table table = new Table();
		stage.addActor(table);		
		table.center();		
		table.setFillParent(true);
		Label titel = new Label("You defeated all your fellow philosophers in argument!" + n + "You won!", Ressources.Skin());
		titel.setAlignment(Align.center);
		
		KeyTextButton restartbutton = new KeyTextButton("Restart!", Ressources.Skin());
		restartbutton.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				game.restart();
			}
		});
	
		table.add(titel).row();
		table.add(restartbutton).padTop(10);
	
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
		stage.draw();
	}
	
	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}
	
	public void dispose () {
		stage.dispose();
	}
}
