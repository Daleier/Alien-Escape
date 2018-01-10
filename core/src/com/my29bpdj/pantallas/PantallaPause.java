package com.my29bpdj.pantallas;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Screen;
import com.my29bpdj.game.Utiles;

public class PantallaPause implements Screen {

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        Utiles.imprimirLog("Resize", "RESIZE", "RESIZE");

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        Utiles.imprimirLog("PantallaXogo", "SHOW", "SHOW");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        Utiles.imprimirLog("PantallaXogo", "HIDE", "HIDE");

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        Utiles.imprimirLog("PantallaXogo", "PAUSE", "PAUSE");

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        Utiles.imprimirLog("PantallaXogo", "RESUME", "RESUME");

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        Utiles.imprimirLog("PantallaXogo", "DISPOSE", "DISPOSE");

    }

}