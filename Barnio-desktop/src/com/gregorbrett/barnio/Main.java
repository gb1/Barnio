package com.gregorbrett.barnio;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Barnio";
		cfg.useGL20 = true;
		cfg.width = 1080;
		cfg.height = 640;
		
		
		new LwjglApplication(new BarnioGame(), cfg);
	}
}
