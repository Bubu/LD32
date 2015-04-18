package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen extends ScreenAdapter {
	PhilosopherGame game;
	Stage stage;
	KeyTextButton startbutton;
	KeyTextButton quitbutton;
	KeyTextButton activeButton;
	public MenuScreen(final PhilosopherGame game) {
		this.game = game;
				
		stage = new Stage(new ScreenViewport());
		stage.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(keycode == Input.Keys.ESCAPE && game.isRunning){
					game.resumeGame();
					return true;
				}
				else if(keycode == Input.Keys.DOWN || keycode == Input.Keys.UP ){
					if (activeButton == null){
						activeButton = startbutton;
						activeButton.setSelected(true);
					}							
					else if (activeButton == startbutton){
						activeButton.setSelected(false);
						activeButton = quitbutton;
						activeButton.setSelected(true);
					}					
					else if (activeButton == quitbutton){
						activeButton.setSelected(false);
						activeButton = startbutton;
						activeButton.setSelected(true);
					}
					return true;
				}
				else if(keycode == Input.Keys.ENTER && activeButton != null){
					activeButton.toggle();
					return true;
				}
				else{
					return false;
				}
		 	}
		});
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

		VerticalGroup group = new VerticalGroup();
		stage.addActor(group);
		
		group.center();

		group.debug();
		
		Label titel = new Label("Philosophers Fight", skin);
		
		group.addActor(titel);

		startbutton = new KeyTextButton("Start the game!", skin);
		startbutton.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				game.start();
			}
		});
		
		quitbutton = new KeyTextButton("Quit", skin);
		quitbutton.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				game.quit();
			}
		});
		
		group.addActor(startbutton);
		group.addActor(quitbutton);
		group.space(20);
		group.padBottom(300);
		group.setSize(group.getPrefWidth(), group.getPrefHeight());
		group.setPosition((stage.getWidth() - group.getWidth())/2, (stage.getHeight() - group.getHeight())/2);

	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		if(game.isRunning){
			
			startbutton.setText("Resume");
			activeButton = startbutton;
			activeButton.setSelected(true);
		}
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
