package com.ld32.philosophergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class FightScreen extends ScreenAdapter {

	PhilosopherGame game;
	Stage stage;
	Philosopher opponent;
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
		opponent = new Philosopher("EvilNietzsche", 100,20,new Texture(Gdx.files.internal("nietzsche.png")),true);
		
		menu = new Menu();
		for(int i = 0; i < game.player.attacks.length; i++){
			final int finali = i;
			if(game.player.attacks[i] != null){
				menu.add(new KeyTextButton(game.player.attacks[i].name,skin));
				menu.entries[i].addListener(new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, Actor actor) {
						game.player.doAttack(game.player.attacks[finali]);
					}
				});
			}
			else{menu.add();}
		}
		game.player.sprite.setDebug(true);
		game.player.sprite.setPosition(20, 25);
		
		Table menutable = new Table();

		menutable.setFillParent(true);
		menutable.debug();
		menutable.right().bottom();
		
		Table opponentTable = new Table();
		opponentTable.setFillParent(true);
		opponentTable.debug();
		opponentTable.right().top();
		opponentTable.add(opponent.sprite).height(100)
			.width(opponent.sprite.getWidth()* 100/opponent.sprite.getWidth())
			.pad(50);
		
		stage.addActor(opponentTable);
		
		stage.addActor(menutable);
		stage.addActor(game.player.sprite);
		

		menu.setDebug(true, true);
		menutable.add(menu);


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
