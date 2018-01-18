package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;
 
public class Mariposa extends Personaje {

	public Vector2 direccion,temporal;
    public Vector2 tamano,posicion;
    public float velocidade,velocidade_max;
    public Vector2 puntoDestino;
   
   
    public Mariposa(Vector2 posicion, Vector2 tamano, float velocidade_max) {
 
        this.posicion=posicion;
        this.tamano = tamano;
        this.velocidade_max=velocidade_max;
       
        temporal = new Vector2();
        direccion = new Vector2(0,0);
        puntoDestino = new Vector2();
    }
 
    public void update(float delta){
        temporal.set(direccion);
        posicion.add(temporal.scl(velocidade_max*delta));
    }

}