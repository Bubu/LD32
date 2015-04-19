package com.ld32.philosophergame;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

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
	
	public void updateMenu(final Philosopher player, final Philosopher opponent ){
		for(int i = 0; i < player.attacks.length; i++){
			final int finali = i;
			if(player.attacks[i] != null){
				add(new KeyTextButton(player.attacks[i].name,skin));
				entries[i].addListener(new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, Actor actor) {
						player.doAttack(player.attacks[finali], opponent);
					}
				});
			}
			else{add();}
		}
	}
}
