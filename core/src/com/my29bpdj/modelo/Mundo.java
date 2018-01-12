package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by dam203 on 10/01/2018.
 */

public class Mundo {
    public static final int TAMANO_MUNDO_ANCHO=300;
    public static final int TAMANO_MUNDO_ALTO=500;

    private Alien alien;
    private Nave nave;

    public Mundo(){
        alien = new Alien(new Vector2(100,20), new Vector2(15,15),100);
        nave = new Nave(new Vector2(0,480), new Vector2(40,20), 60);
    }

    public Alien getAlien() {
        return alien;
    }

    public Nave getNave(){
        return nave;
    }

}