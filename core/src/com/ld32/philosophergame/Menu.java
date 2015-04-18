package com.ld32.philosophergame;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Menu extends Table {
	

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(Skin skin) {
		super(skin);
		// TODO Auto-generated constructor stub
	}
	public void add(KeyTextButton entry){
		this.add(entry);
	}
}
