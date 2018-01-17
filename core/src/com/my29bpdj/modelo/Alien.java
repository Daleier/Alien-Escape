package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;

public class Alien extends Personaje{

        private Vector2 velocidade;

        public Alien(Vector2 posicion, Vector2 tamano, float velocidade_max) {
			super(posicion, tamano, velocidade_max);
			velocidade = new Vector2(0,0);
        }

	public float getVelocidadeX(){
		return velocidade.x;
	}
	public float getVelocidadeY(){
		return velocidade.y;
	}

	public void setVelocidadeX(float x){
		velocidade.x = x;

	}
	public void setVelocidadeY(float y){
		velocidade.y = y;
	}

	@Override
	public void update(float delta) {
		setPosicion(getPosicion().x+velocidade.x*delta, getPosicion().y+velocidade.y*delta);
	}
 
}