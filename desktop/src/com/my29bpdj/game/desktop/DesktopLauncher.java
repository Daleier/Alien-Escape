package com.my29bpdj.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.my29bpdj.game.Juego;
import com.my29bpdj.game.My29bpdjGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Alien Escape 29BPDJ";
		config.width = 450;
		config.height = 750;
		config.resizable=false;
		config.addIcon("alienicon.png", Files.FileType.Internal);
		new LwjglApplication(new Juego(), config);
	}
}
