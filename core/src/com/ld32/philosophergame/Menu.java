package com.ld32.philosophergame;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Menu extends Table {
	KeyTextButton[] entries;
	

	public Menu() {
		entries = new KeyTextButton[4];
	}

	public void add(KeyTextButton entry){
		if(entries.length>2){
			this.row();
			entries[entries.length-1] = entry;
		}
			this.add(entry);
	}
}
