package com.my29bpdj.pantallas;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.my29bpdj.controlador.ControladorJuego;
import com.my29bpdj.game.Juego;
import com.my29bpdj.modelo.Mundo;
import com.my29bpdj.renderer.RendererJuego;

public class PantallaJuego implements Screen, InputProcessor {
    private boolean pause;
    private boolean finXogo;
    private boolean sair;
    private Mundo meuMundo;
    private Juego meuxogogame;
    private RendererJuego rendererxogo;
    private ControladorJuego controladorJuego;


    public PantallaJuego(Juego meuxogogame){
        meuMundo = new Mundo();
        this.meuxogogame=meuxogogame;
        rendererxogo=new RendererJuego(meuMundo);
        controladorJuego = new ControladorJuego(meuMundo);

    }


    @Override
    public void render(float delta) {
        controladorJuego.update(delta);
        rendererxogo.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        rendererxogo.resize(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

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
        rendererxogo.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
// Liberamos as teclas para que se arrastramos o dedo a outro control sen soltar o anterior non xunte o efecto
		controladorJuego.liberarTecla(ControladorJuego.Keys.ABAIXO);
		controladorJuego.liberarTecla(ControladorJuego.Keys.ARRIBA);
		controladorJuego.liberarTecla(ControladorJuego.Keys.ESQUERDA);
		controladorJuego.liberarTecla(ControladorJuego.Keys.DEREITA);

		switch(keycode){
			case Input.Keys.UP:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.ARRIBA);
				break;
			case Input.Keys.DOWN:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.ABAIXO);
				break;
			case Input.Keys.LEFT:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.ESQUERDA);
				break;
			case Input.Keys.RIGHT:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.DEREITA);
				break;
		}


		return false;    }

    @Override
    public boolean keyUp(int keycode) {
		switch (keycode) {
			case Input.Keys.UP:
				controladorJuego.liberarTecla(ControladorJuego.Keys.ARRIBA);
				break;
			case Input.Keys.DOWN:
				controladorJuego.liberarTecla(ControladorJuego.Keys.ABAIXO);
				break;
			case Input.Keys.LEFT:
				controladorJuego.liberarTecla(ControladorJuego.Keys.ESQUERDA);
				break;
			case Input.Keys.RIGHT:
				controladorJuego.liberarTecla(ControladorJuego.Keys.DEREITA);
				break;
		}
		return false;    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector3 temporal= new Vector3(screenX,screenY,0);
		this.rendererxogo.getCamara2d().unproject(temporal);
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