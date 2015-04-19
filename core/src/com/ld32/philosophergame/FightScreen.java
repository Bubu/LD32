package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FightScreen extends ScreenAdapter {

	PhilosopherGame game;
	Stage stage;
	Opponent opponent;
	Menu menu;
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
		 menu = new Menu();
		 for(int i = 0; i < game.player.attacks.length; i++){
			 if(game.player.attacks[i] != null){
				 menu.add(new KeyTextButton(game.player.attacks[i].name,skin));
			 }
			 else{menu.add();}
		 }
		 game.player.sprite.setDebug(true);
		 game.player.sprite.setPosition(20, 25);
		 Table table = new Table();
		 
		 
		 table.setFillParent(true);
		 table.debug();
		 table.right().bottom();
		 stage.addActor(table);
		 stage.addActor(game.player.sprite);

		 menu.setDebug(true, true);
		 table.add(menu);
		

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

}
