package com.ld32.philosophergame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class Menu extends Table {
	KeyTextButton[] entries;
	int length;
	private Skin skin; 
	

	public Menu(Skin skin) {
		this.skin = skin;
		entries = new KeyTextButton[6];
		length = 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Cell add() {
		if(length>=2){
			this.row();
			entries[entries.length-1] = null;
		}
		length ++;
		return super.add().width(200).pad(10);
	}

	public Cell<KeyTextButton> add(KeyTextButton entry){
		if(length == 2){
			this.row();
		}
		if(length == 4){
			this.row();
		}
		entries[length] = entry;
		length ++;
		return super.add(entry).width(200).pad(10);
			
	}
	
	public void updateMenu(final Philosopher player, final Philosopher opponent, final Label l){
		entries = new KeyTextButton[6];
		reset();
		for(int i = 0; i < player.attacks.length; i++){
			final int finali = i;
			if(player.attacks[i] != null){
				add(new KeyTextButton(player.attacks[i].name,skin));
				entries[i].addListener(new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, final Actor actor) {
						player.doAttack(player.attacks[finali], opponent);
						actor.getParent().setVisible(false);
						l.setText("Attack!");
						l.setVisible(true);
						actor.getParent().getParent().getParent().addListener(new InputListener(){
							@Override
							public boolean keyDown(InputEvent event, int keycode) {
								if(keycode == Input.Keys.ENTER){
									actor.getParent().setVisible(true);
									l.setVisible(false);
									actor.getParent().getParent().getParent().removeListener(this);
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
								actor.getParent().setVisible(true);
								l.setVisible(false);
								actor.getParent().getParent().getParent().removeListener(this);
							}
						});
					}
				});
			}
			else{add();}
		}
	}
}
