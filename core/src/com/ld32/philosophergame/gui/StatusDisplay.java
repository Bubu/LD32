package com.ld32.philosophergame.gui;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.ld32.philosophergame.Philosopher;
import com.ld32.philosophergame.Ressources;


public class StatusDisplay extends Table {

	private ProgressBar healthbar;
	private ProgressBar sanitybar;
	private Label healthLabel;
	private Label sanityLabel;

	public StatusDisplay(Philosopher phil) {
		healthbar = generateBar(phil.maxhp);
		sanitybar = generateBar(phil.sanity);
		sanitybar.setStyle(Ressources.Skin().get("default-sanity", ProgressBarStyle.class));
		healthLabel =new Label(Integer.toString(phil.currenthp)+"/"+Integer.toString(phil.maxhp), Ressources.Skin());
		healthLabel.setAlignment(Align.right);
		sanityLabel = new Label(Integer.toString(phil.currentSanity)+"/"+Integer.toString(phil.sanity), Ressources.Skin());
		sanityLabel.setAlignment(Align.right);
		Label name = new Label(phil.name,Ressources.Skin());
		
		add(name).center().row();
		add(healthbar).left();
		add(healthLabel).width(70);
		row();
		add(sanitybar).left().padTop(5);
		add(sanityLabel).width(70);
	}

	private ProgressBar generateBar(int maxValue) {
		ProgressBar bar = new ProgressBar(0, maxValue, 1, false, Ressources.Skin());
		bar.setValue(maxValue);
		return bar;
	}
	
	public void setHp(int hp){
		healthbar.setValue(hp);
		healthLabel.setText(Integer.toString(hp)+"/"+Integer.toString((int)healthbar.getMaxValue()));
	}
	public void setSanity(int sanity){
		sanitybar.setValue(sanity);
		sanityLabel.setText(Integer.toString(sanity)+"/"+Integer.toString((int)sanitybar.getMaxValue()));
	}
}
