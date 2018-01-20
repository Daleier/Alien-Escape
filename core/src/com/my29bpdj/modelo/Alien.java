package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;

public class Alien extends Personaje{

        private Vector2 velocidade;


	private float velocidadMontado;

        public Alien(Vector2 posicion, Vector2 tamano, float velocidade_max) {
			super(posicion, tamano, velocidade_max);
			velocidade = new Vector2(0,0);
			setVelocidadMontado(0);
			getRectangulo().setSize(tamano.x/2);
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

	public float getVelocidadMontado() {
		return velocidadMontado;
	}

	public void setVelocidadMontado(float velocidadMontado) {
		this.velocidadMontado = velocidadMontado;
	}

	@Override
	public void actualizarRectangulo(){

		getRectangulo().x = getPosicion().x+getTamano().x/4;
		getRectangulo().y = getPosicion().y+getTamano().y/4;

	}

	@Override
	public void update(float delta) {
		setPosicion(getPosicion().x+(velocidade.x+velocidadMontado)*delta,getPosicion().y+velocidade.y*delta);
	}



}