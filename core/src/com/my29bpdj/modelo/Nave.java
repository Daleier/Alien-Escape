package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;

public class Nave extends Personaje{

	private float tiempo;
	private boolean parado;
	private final int TIEMPO_MOVIENDOSE=3;

	public Nave(Vector2 posicion, Vector2 tamano, float velocidade_max) {
		super(posicion, tamano, velocidade_max);
		setVelocidade(velocidade_max);
		this.parado = false;
		this.tiempo = 0;

	}


	@Override
	public void update(float delta) {
		posicion.add((velocidade*delta),0);

	}

	public float getTiempo() {
		return tiempo;
	}

	public void setTiempo(float tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isParado() {
		return parado;
	}

	public void setParado(boolean parado) {
		this.parado = parado;
	}

	public int getTIEMPO_MOVIENDOSE() {
		return TIEMPO_MOVIENDOSE;
	}
}