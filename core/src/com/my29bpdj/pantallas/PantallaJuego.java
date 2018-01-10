package com.my29bpdj.pantallas;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Screen;
import com.my29bpdj.game.Juego;
import com.my29bpdj.game.My29bpdjGame;
import com.my29bpdj.renderer.RendererJuego;
import com.my29bpdj.renderer.Test01RendererJuego;
import com.my29bpdj.renderer.Test02RendererJuego;
import com.my29bpdj.renderer.Test03RendererJuego;

public class PantallaJuego implements Screen {
    private boolean pause;
    private boolean finXogo;
    private boolean sair;

    private Juego meuxogogame;
    private Test03RendererJuego rendererxogo;

    public PantallaJuego(Juego meuxogogame){
        this.meuxogogame=meuxogogame;
        rendererxogo=new Test03RendererJuego();
    }


    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

        rendererxogo.render(0);
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub

        rendererxogo.dispose();
    }

}