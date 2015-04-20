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
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen extends ScreenAdapter {
	PhilosopherGame game;
	Stage stage;
	KeyTextButton startbutton;
	KeyTextButton quitbutton;
	KeyTextButton restartbutton;
	KeyTextButton activeButton;
	private VerticalGroup group;
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

		group = new VerticalGroup();
		stage.addActor(group);
		
		group.center();

		
		Label titel = new Label("Philosophers Fight", Ressources.Skin().get("title",LabelStyle.class));
		
		group.addActor(titel);

		startbutton = new KeyTextButton("Start the game!", Ressources.Skin());
		startbutton.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				game.resumeGame();
			}
		});
		
		restartbutton = new KeyTextButton("Restart!", Ressources.Skin());
		restartbutton.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				game.restart();
			}
		});
		
		quitbutton = new KeyTextButton("Quit", Ressources.Skin());
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
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.input.setInputProcessor(stage);
		if(game.isRunning){
			
			startbutton.setText("Resume");
			group.addActorAt(2,restartbutton);
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
