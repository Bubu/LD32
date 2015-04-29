package com.ld32.philosophergame.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.ld32.philosophergame.Ressources;

public class RightBubble extends Label {

	public RightBubble(CharSequence text) {
		super(text, Ressources.BubbleStyleRight());
		this.setPosition(160, 250);
	}
	

}
