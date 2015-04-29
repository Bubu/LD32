package com.ld32.philosophergame.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class KeyTextButton extends TextButton {
	boolean selected;

	public KeyTextButton(String text, Skin skin) {
		super(text, skin);
		selected = false;
	}
	

	@Override
	public boolean isPressed() {
		return selected || super.isPressed();
	}



	public void setSelected(boolean sel) {
		selected = sel;		
	}
}