package com.ld32.philosophergame;

import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Menu extends Table {
	KeyTextButton[] entries;
	int length; 
	

	public Menu() {
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
}
