package com.ld32.philosophergame.gui;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.ld32.philosophergame.PhilosopherGame;

public class Menu extends Table {
	public static String n = "\n"; //Ressources.getLineSeparator();
	KeyTextButton[] entries;
	int length;
	private Skin skin; 
	

	public Menu(Skin skin) {
		this.skin = skin;
		setBackground(skin.getDrawable("default-rect"));
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
	
	public void updateMenu(final PhilosopherGame game){
		entries = new KeyTextButton[6];
		length = 0;
		reset();
		for(int i = 0; i < game.player.attacks.length; i++){
			final int finali = i;
			if(game.player.attacks[i] != null){
				add(new KeyTextButton(game.player.attacks[i].name,skin));
				if(game.player.attacks[i].currentCoolDown > 0){
					entries[i].setDisabled(true);
					entries[i].setText(entries[i].getText() + " (" + game.player.attacks[i].currentCoolDown + ")");
				}
				else if(game.player.attacks[i].coolDown != 0){
					entries[i].setText(entries[i].getText() + " (" + game.player.attacks[i].coolDown + ")");
				}
				entries[i].addListener(new ChangeListener() {
					@Override
					public void changed(ChangeEvent event, final Actor actor) {
						try {
							game.fight.playerAttack.performPlayerAttack(game.player.attacks[finali]);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				entries[i].addListener(new InputListener() {
					@Override
					public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
						event.stop(); //Stops event propagation. So the general stage clickhandler doesn't receive it.
						return true;
					}
				});
			}
			else{add();}
		}
	}
	
}
