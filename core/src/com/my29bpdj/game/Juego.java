package com.my29bpdj.game;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Game;
import com.my29bpdj.pantallas.PantallaJuego;

public class Juego extends Game {

    private PantallaJuego pantallaxogo;

    @Override
    public void create() {
        // TODO Auto-generated method stub

        pantallaxogo = new PantallaJuego(this);
        setScreen(pantallaxogo);
    }

    @Override
    public void dispose(){
        super.dispose();
        pantallaxogo.dispose();
    }
}