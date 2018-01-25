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
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.my29bpdj.game.Juego;
import com.my29bpdj.game.Utiles;
import com.my29bpdj.modelo.Mundo;

public class PantallaPresentacion implements Screen, InputProcessor {

	private Juego meuxogogame;
	private OrthographicCamera camara2d;
	private SpriteBatch spritebatch;
	private static Texture fondo;
	private Rectangle botones[]={new Rectangle(100, 268, 98, 32),
			new Rectangle(100, 235, 98, 32),
			new Rectangle(100, 200, 98, 32)};

	public PantallaPresentacion(Juego meuxogogame) {
		this.meuxogogame=meuxogogame;

		camara2d = new OrthographicCamera();
		spritebatch = new SpriteBatch();
		fondo = new Texture(Gdx.files.internal("graficos/libgdx_itin1_pantallapresentacion.png"));
	}

	@Override
    public void render(float delta) {
		spritebatch.begin();
		spritebatch.draw(fondo,0,0, Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
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
		Vector3 temp = new Vector3(screenX,screenY,0);
		camara2d.unproject(temp);
		Circle dedo = new Circle(temp.x,temp.y,2);
		if (Intersector.overlaps(dedo, botones[0]))	{	// Pulsar Juego nuevo
			dispose();
			meuxogogame.setScreen(new PantallaJuego(meuxogogame));
		}else if (Intersector.overlaps(dedo, botones[1])){ // Puntuaciones
			dispose();
			meuxogogame.setScreen(new PantallaMarcadores(meuxogogame));
		}else if (Intersector.overlaps(dedo, botones[2])){ // Salir
			Gdx.app.exit();
		}


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