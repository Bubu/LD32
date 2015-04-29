package com.ld32.philosophergame.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ld32.philosophergame.Ressources;

public class LeftBubble extends Label {

	public LeftBubble(CharSequence text) {
		super(text, Ressources.BubbleStyleLeft());
		this.setPosition(40, 160);
	}
	

}
