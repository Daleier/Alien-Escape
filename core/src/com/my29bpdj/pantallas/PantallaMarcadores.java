package com.my29bpdj.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.Bitmap;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.my29bpdj.game.Juego;
import com.my29bpdj.modelo.Mundo;

/**
 * Created by dam203 on 09/01/2018.
 */

public class PantallaMarcadores implements Screen, InputProcessor {
	private Juego meuxogogame;
	private SpriteBatch spritebatch;
	private BitmapFont bitMapFont;
	StringBuilder sbuffer;
	StringBuilder sbuffer2;

    public PantallaMarcadores(Juego meuxogogame) {
		//Libgdx by default, creates a BitmapFont using the default 15pt Arial font included in the libgdx JAR file.
		//Using FreeTypeFont, it is possible so create fonts with a desired size on the fly.
		this.meuxogogame=meuxogogame;
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/ds-digit.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = (int)(15 * Mundo.PROPORCION_REAL_MUNDO_ANCHO);
		this.bitMapFont = generator.generateFont(parameter); // font size in pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
		//bitMapFont = new BitmapFont();
		sbuffer = new StringBuilder();
		sbuffer2 = new StringBuilder();
		sbuffer.append("ESCAPAR DE LOS ALIEN");
		sbuffer2.append("29BPDJ");
		spritebatch = new SpriteBatch();
//		bitMapFont.draw(spritebatch,  "your text", 0, 100, Mundo.TAMANO_MUNDO_ANCHO, HAlignment.CENTER);
    }


    @Override
    public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spritebatch.begin();
		bitMapFont.setColor(Color.YELLOW);
	//bitMapFont.setScale(0.5f, 2);
		bitMapFont.draw(spritebatch, sbuffer, 20*Mundo.PROPORCION_REAL_MUNDO_ANCHO, 450*Mundo.PROPORCION_REAL_MUNDO_ALTO);
		bitMapFont.draw(spritebatch, sbuffer2, Mundo.TAMANO_MUNDO_ANCHO/2,420*Mundo.PROPORCION_REAL_MUNDO_ALTO);
	// Falta el código que muestra las puntuaciones
		spritebatch.end();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
		Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
		Gdx.input.setInputProcessor(null);

    }

    @Override
    public void resume() {
		Gdx.input.setInputProcessor(this);

    }

    @Override
    public void dispose() {
		bitMapFont.dispose();
		spritebatch.dispose();
		Gdx.input.setInputProcessor(null);


	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		dispose();
		meuxogogame.setScreen(new PantallaPresentacion(meuxogogame));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
