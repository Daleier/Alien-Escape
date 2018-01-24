package com.my29bpdj.pantallas;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.my29bpdj.game.Juego;
import com.my29bpdj.game.Utiles;

public class PantallaPause implements Screen, InputProcessor {

    private Juego meuxogogame;
    private OrthographicCamera camara2d;
    private SpriteBatch spritebatch;
    private static Texture fondo;
	private PantallaJuego pantallaJuego;

    public PantallaPause(Juego meuxogogame, PantallaJuego pantallaJuego) {
        this.meuxogogame=meuxogogame;
		this.pantallaJuego = pantallaJuego;
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        fondo = new Texture(Gdx.files.internal("graficos/libgdx_itin1_pantallapause.jpg"));
    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
		Gdx.input.setInputProcessor(null);
		spritebatch.dispose();
		fondo.dispose();
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
		meuxogogame.setScreen(pantallaJuego);
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