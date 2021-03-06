package com.my29bpdj.game;

/**
 * Created by dam203 on 09/01/2018.
 */

import com.badlogic.gdx.Game;
import com.my29bpdj.pantallas.PantallaJuego;
import com.my29bpdj.pantallas.PantallaPresentacion;
import com.my29bpdj.renderer.RendererJuego;

public class Juego extends Game {

    @Override
    public void create() {
        AssetsJuego.cargarTexturas();
        Audio.iniciarAudio();
        setScreen(new PantallaPresentacion(this));
    }

    @Override
    public void dispose(){
        super.dispose();
        AssetsJuego.liberarTexturas();
        Audio.dispose();
    }
}