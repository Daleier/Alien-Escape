package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
/**
 * Created by dam203 on 10/01/2018.
 */

public class Mundo {
    public static final int TAMANO_MUNDO_ANCHO=300;
    public static final int TAMANO_MUNDO_ALTO=500;

    private Alien alien;
    private Nave nave;
    private Array<ElementoMovil>coches;

    public Mundo(){
        alien = new Alien(new Vector2(100,20), new Vector2(15,15),100);
        nave = new Nave(new Vector2(0,480), new Vector2(40,20), 60);

        coches = new Array<ElementoMovil>();
        coches.add(new ElementoMovil(new Vector2(10,400),new Vector2(20,15),65));
        coches.add(new ElementoMovil(new Vector2(40,400),new Vector2(20,15),65));
    }

    public Alien getAlien() {
        return alien;
    }

    public Nave getNave(){
        return nave;
    }

    public Array<ElementoMovil>getCoches(){
        return coches;
    }
}