package com.my29bpdj.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class My29bpdjGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private FPSLogger fps;

	@Override
	public void create () {
		fps = new FPSLogger();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Utiles.imprimirLog("My29bpdjGame","create","29BPDJ");
	}


	@Override
	public void render () {
		//fps.log();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		Utiles.imprimirLog("My29bpdjGame","dispose","29BPDJ");

	}

	@Override
	public void resize(int width, int height) {
		Utiles.imprimirLog("My29bpdjGame","resize","29BPDJ");
		super.resize(width, height);
	}

	@Override
	public void pause() {
		Utiles.imprimirLog("My29bpdjGame","pause","29BPDJ");
		super.pause();
	}

	@Override
	public void resume() {
		Utiles.imprimirLog("My29bpdjGame","resume","29BPDJ");
		super.resume();
	}
}
