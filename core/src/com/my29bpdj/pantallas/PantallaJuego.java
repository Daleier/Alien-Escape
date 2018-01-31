package com.my29bpdj.pantallas;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.my29bpdj.controlador.ControladorJuego;
import com.my29bpdj.game.Audio;
import com.my29bpdj.game.HighScores;
import com.my29bpdj.game.Juego;
import com.my29bpdj.game.Utiles;
import com.my29bpdj.modelo.Alien;
import com.my29bpdj.modelo.Controles;
import com.my29bpdj.modelo.Mundo;
import com.my29bpdj.renderer.RendererJuego;

public class PantallaJuego implements Screen, InputProcessor {
    public static boolean pause;
    private boolean finXogo;
    private boolean sair;
    private Mundo meuMundo;
    private Juego meuxogogame;
    private RendererJuego rendererxogo;
    private ControladorJuego controladorJuego;
	private BitmapFont bitMapFont;


    public PantallaJuego(Juego meuxogogame){
        Audio.audioInicio.play();
        meuMundo = new Mundo();
        this.meuxogogame=meuxogogame;
        rendererxogo=new RendererJuego(meuMundo);
        controladorJuego = new ControladorJuego(meuMundo);
    }


    @Override
    public void render(float delta) {
        controladorJuego.update(delta);
        rendererxogo.render(delta);
        if(!Audio.audioInicio.isPlaying() && !Audio.audioJuego.isPlaying()){
            if(!Audio.audioOvni01_alcanzado.isPlaying() && !Audio.audioOvni02_alcanzado.isPlaying() && !Audio.audioOvni03_alcanzado.isPlaying()){
                Audio.audioJuego.play();
            }
        }
		if (meuMundo.getAlien().getNumVidas().size>=15){
			finXogo=true;
		}
		if (meuMundo.getCronometro() < 1){
			finXogo=true;
		}
        if (pause) {
            if (Audio.audioInicio.isPlaying()) {
                Audio.audioInicio.pause();
                Audio.setInicioPausada(true);
            }
            if (Audio.audioJuego.isPlaying()) {
                Audio.audioJuego.pause();
                Audio.setJuegoPausada(true);
            }
            if (Audio.audioMovimiento.isPlaying())
                Audio.audioMovimiento.stop();
            if (Audio.audioOvni01_alcanzado.isPlaying()) {
                Audio.audioOvni01_alcanzado.pause();
                Audio.setOvni01AlcanzadoPausada(true);
            }
            if (Audio.audioOvni02_alcanzado.isPlaying()) {
                Audio.audioOvni02_alcanzado.pause();
                Audio.setOvni02AlcanzadoPausada(true);
            }
            if (Audio.audioOvni03_alcanzado.isPlaying()) {
                Audio.audioOvni03_alcanzado.pause();
                Audio.setOvni03AlcanzadoPausada(true);
            }
            if (Audio.audioSpaceship.isPlaying()) {
                Audio.audioSpaceship.pause();
                Audio.setSpaceshipPausada(true);
            }
            Audio.audioCoche01.stop();
            Audio.audioCoche02.stop();
            Audio.audioCoche03.stop();
            meuxogogame.setScreen(new PantallaPause(meuxogogame, this));
            return;
        }

		if (finXogo){
            if (Audio.audioInicio.isPlaying()) {
                Audio.audioInicio.stop();
            }
            if (Audio.audioJuego.isPlaying()) {
                Audio.audioJuego.stop();
            }
            if (Audio.audioMovimiento.isPlaying())
                Audio.audioMovimiento.stop();
            if (Audio.audioOvni01_alcanzado.isPlaying()) {
                Audio.audioOvni01_alcanzado.stop();
            }
            if (Audio.audioOvni02_alcanzado.isPlaying()) {
                Audio.audioOvni02_alcanzado.stop();
            }
            if (Audio.audioOvni03_alcanzado.isPlaying()) {
                Audio.audioOvni03_alcanzado.stop();
            }
            if (Audio.audioSpaceship.isPlaying()) {
                Audio.audioSpaceship.stop();
            }
			HighScores.engadirPuntuacion(meuMundo.getAlien().getNumVidasSalvadas());
            meuxogogame.setScreen(new PantallaMarcadores(meuxogogame));
			return;
		}
    }

    @Override
    public void resize(int width, int height) {
        rendererxogo.resize(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        if(PantallaPresentacion.musicaOn){
			Audio.iniciarClaxon();
		}
        pause=false;
	}

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
		if(PantallaPresentacion.musicaOn){
			Audio.paraClaxon();
		}
    }

    @Override
    public void pause() {
        Gdx.input.setInputProcessor(null);
		if (!finXogo) {
			pause = true;
		}

    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(this);
		if(PantallaPresentacion.musicaOn){
			Audio.iniciarClaxon();
		}
		pause=false;
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        rendererxogo.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
// Liberamos as teclas para que se arrastramos o dedo a outro control sen soltar o anterior non xunte o efecto
		controladorJuego.liberarTecla(ControladorJuego.Keys.ABAJO);
		controladorJuego.liberarTecla(ControladorJuego.Keys.ARRIBA);
		controladorJuego.liberarTecla(ControladorJuego.Keys.IZQUIERDA);
		controladorJuego.liberarTecla(ControladorJuego.Keys.DERECHA);

		switch(keycode){
			case Input.Keys.UP:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.ARRIBA);
				break;
			case Input.Keys.DOWN:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.ABAJO);
				break;
			case Input.Keys.LEFT:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.IZQUIERDA);
				break;
			case Input.Keys.RIGHT:
				controladorJuego.pulsarTecla(ControladorJuego.Keys.DERECHA);
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
				controladorJuego.liberarTecla(ControladorJuego.Keys.ABAJO);
				break;
			case Input.Keys.LEFT:
				controladorJuego.liberarTecla(ControladorJuego.Keys.IZQUIERDA);
				break;
			case Input.Keys.RIGHT:
				controladorJuego.liberarTecla(ControladorJuego.Keys.DERECHA);
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
		Circle dedo = new Circle(temporal.x,temporal.y,2);

        if (Intersector.overlaps(new Circle(temporal.x, temporal.y, 2), Controles.FLECHA_IZQUIERDA)){
            controladorJuego.pulsarTecla(ControladorJuego.Keys.IZQUIERDA);
        } else if (Intersector.overlaps(new Circle(temporal.x, temporal.y, 2), Controles.FLECHA_DERECHA)){
            controladorJuego.pulsarTecla(ControladorJuego.Keys.DERECHA);
        } else if (Intersector.overlaps(new Circle(temporal.x, temporal.y, 2), Controles.FLECHA_ARRIBA)){
            controladorJuego.pulsarTecla(ControladorJuego.Keys.ARRIBA);
        } else if (Intersector.overlaps(new Circle(temporal.x, temporal.y, 2), Controles.FLECHA_ABAJO)){
            controladorJuego.pulsarTecla(ControladorJuego.Keys.ABAJO);
        }
        // Controles pausa y salir
		Rectangle recTemporal = new Rectangle();
		recTemporal.set(Controles.CONTROL_PAUSE.x,Controles.CONTROL_PAUSE.y,Controles.CONTROL_PAUSE.width,Controles.CONTROL_PAUSE.height);
		if (Intersector.overlaps(dedo, recTemporal)){
			pause = true;
		}
		recTemporal.set(Controles.CONTROL_SALIR.x,Controles.CONTROL_SALIR.y,Controles.CONTROL_SALIR.width,Controles.CONTROL_SALIR.height);
		if (Intersector.overlaps(dedo, recTemporal)){
			dispose();
            if (Audio.audioInicio.isPlaying()) {
                Audio.audioInicio.stop();
            }
            if (Audio.audioJuego.isPlaying()) {
                Audio.audioJuego.stop();
            }
            if (Audio.audioMovimiento.isPlaying())
                Audio.audioMovimiento.stop();
            if (Audio.audioOvni01_alcanzado.isPlaying()) {
                Audio.audioOvni01_alcanzado.stop();
            }
            if (Audio.audioOvni02_alcanzado.isPlaying()) {
                Audio.audioOvni02_alcanzado.stop();
            }
            if (Audio.audioOvni03_alcanzado.isPlaying()) {
                Audio.audioOvni03_alcanzado.stop();
            }
            if (Audio.audioSpaceship.isPlaying()) {
                Audio.audioSpaceship.stop();
            }
			meuxogogame.setScreen(new PantallaPresentacion(meuxogogame));
		}
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        controladorJuego.liberarTecla(ControladorJuego.Keys.IZQUIERDA);
        controladorJuego.liberarTecla(ControladorJuego.Keys.DERECHA);
        controladorJuego.liberarTecla(ControladorJuego.Keys.ARRIBA);
        controladorJuego.liberarTecla(ControladorJuego.Keys.ABAJO);
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