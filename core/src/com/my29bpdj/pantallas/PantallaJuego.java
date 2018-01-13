package com.my29bpdj.pantallas;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Screen;
import com.my29bpdj.controlador.ControladorJuego;
import com.my29bpdj.game.Juego;
import com.my29bpdj.game.My29bpdjGame;
import com.my29bpdj.modelo.Mundo;
import com.my29bpdj.renderer.RendererJuego;
import com.my29bpdj.renderer.Test01RendererJuego;
import com.my29bpdj.renderer.Test02RendererJuego;
import com.my29bpdj.renderer.Test03RendererJuego;

public class PantallaJuego implements Screen {
    private boolean pause;
    private boolean finXogo;
    private boolean sair;
    private Mundo meuMundo;
    private Juego meuxogogame;
    private RendererJuego rendererxogo;
    private ControladorJuego controladorXogo;


    public PantallaJuego(Juego meuxogogame){
        meuMundo = new Mundo();
        this.meuxogogame=meuxogogame;
        rendererxogo=new RendererJuego(meuMundo);
        controladorXogo = new ControladorJuego(meuMundo);

    }


    @Override
    public void render(float delta) {
        controladorXogo.update(delta);
        rendererxogo.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        rendererxogo.resize(width, height);
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
        rendererxogo.dispose();
    }

}