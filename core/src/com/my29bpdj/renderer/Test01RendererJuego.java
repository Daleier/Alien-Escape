package com.my29bpdj.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.my29bpdj.modelo.Mundo;

/**
 * Created by dam203 on 10/01/2018.
 */

public class Test01RendererJuego implements InputProcessor{
    /**
     * Debuxa todos os elementos gr�ficos da pantalla
     * @param delta: tempo que pasa entre un frame e o seguinte.
     */

    private Texture grafico;
    private SpriteBatch spritebatch;

    private OrthographicCamera camara2d;


    public Test01RendererJuego(){
        camara2d = new OrthographicCamera();
        grafico = new Texture(Gdx.files.internal("spaceship50x50.png"));
        spritebatch = new SpriteBatch();
    }

    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        camara2d.rotate(1);
        camara2d.position.set(50,50,0);
//        camara2d.zoom+=0.01f;
        camara2d.update();
        spritebatch.setProjectionMatrix(camara2d.combined);


        spritebatch.begin();
        spritebatch.draw(grafico,Mundo.TAMANO_MUNDO_ANCHO/2,Mundo.TAMANO_MUNDO_ALTO/2,50,50);
        spritebatch.end();
    }
    public void resize(int width, int height) {

        camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO,
                Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();

        spritebatch.setProjectionMatrix(camara2d.combined);
    }
    public void dispose(){
        spritebatch.dispose();
        grafico.dispose();
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
