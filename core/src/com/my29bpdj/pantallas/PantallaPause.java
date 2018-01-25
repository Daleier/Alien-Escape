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
import com.my29bpdj.modelo.Mundo;

import javax.rmi.CORBA.Util;

public class PantallaPause implements Screen, InputProcessor {

    private Juego meuxogogame;
    private OrthographicCamera camara2d;
    private SpriteBatch spritebatch;
    private static Texture fondo;
	private PantallaJuego pantallaJuego;

    public PantallaPause(Juego meuxogogame, PantallaJuego pantallaJuego) {
        Utiles.imprimirLog("PantallaPause","PantallaPause","Iniciada pausa");
        this.meuxogogame=meuxogogame;
		this.pantallaJuego = pantallaJuego;
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        fondo = new Texture(Gdx.files.internal("graficos/libgdx_itin1_pantallapause.jpg"));
    }

    @Override
    public void render(float delta) {
		spritebatch.begin();
        spritebatch.draw(fondo,0,0,Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
        spritebatch.end();
    }

    @Override
    public void resize(int width, int height) {
		camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();

        spritebatch.setProjectionMatrix(camara2d.combined);
        spritebatch.disableBlending();
    }

    @Override
    public void show() {
		Gdx.input.setInputProcessor(this);

    }

    @Override
    public void hide() {
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