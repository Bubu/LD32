package com.ld32.philosophergame.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ld32.philosophergame.PhilosopherGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.addIcon("icon128.png", FileType.Internal);
		cfg.addIcon("icon32.png", FileType.Internal);
		cfg.addIcon("icon32.png", FileType.Internal);
		cfg.title = "Philosopher's game";
		cfg.height = 480;
		cfg.width = 722;
		cfg.resizable = false;
		new LwjglApplication(new PhilosopherGame(), cfg);
	}
}
