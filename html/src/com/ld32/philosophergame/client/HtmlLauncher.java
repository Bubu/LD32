package com.ld32.philosophergame.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.ld32.philosophergame.PhilosopherGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(722, 480);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new PhilosopherGame();
        }
}