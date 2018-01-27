package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.my29bpdj.game.Audio;

public class Alien extends Personaje{

	private Vector2 velocidade;
	private float velocidadMontado;
	public static enum TIPOS_VIDA{INICIAL,SALVADO,MUERTO};
	private Array<TIPOS_VIDA> numVidas;

	public Alien(Vector2 posicion, Vector2 tamano, float velocidade_max) {
		super(posicion, tamano, velocidade_max);
		velocidade = new Vector2(0,0);
		setVelocidadMontado(0);
		getRectangulo().setSize(tamano.x/2);
		numVidas = new Array<Alien.TIPOS_VIDA>();
	}

	public void inicializarAlien(){
		setPosicion(100, 20);
		setVelocidadMontado(0);
		setVelocidadeX(0);
		setVelocidadeY(0);
		setTamano(15,15);
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
		this.sonidoMovimiento();
	}

	public void setVelocidadeY(float y){
		velocidade.y = y;
		this.sonidoMovimiento();
	}

	private void sonidoMovimiento(){
        /*Es necesario controlar velocidad de x e y ya que en el método procesar entradas
        * de ControladorJuego se ejecutan siempre ambos métodos. Por ejemplo, cuando se
        * pulsa a la derecha se ejecuara setVelocidadX, pero además, al valer ARRIBA y ABAJO false
        * se ejecutará también setVelocidadY*/
		if ((velocidade.x == 0)&&(velocidade.y==0)) {
			if (Audio.audioMovimiento.isPlaying())
				Audio.audioMovimiento.stop();
		} else {
			if (!Audio.audioMovimiento.isPlaying()){

			}
			Audio.audioMovimiento.play();
		}
	}

	public float getVelocidadMontado() {
		return velocidadMontado;
	}

	public void setVelocidadMontado(float velocidadMontado) {
		this.velocidadMontado = velocidadMontado;
	}

	public Array<TIPOS_VIDA> getNumVidas() {
		return numVidas;
	}

	public void setNumVidas(TIPOS_VIDA vida) {
		numVidas.add(vida);
	}

	public int getNumVidasSalvadas(){
		int num=0;
		for (TIPOS_VIDA vida : numVidas){
			if (vida == TIPOS_VIDA.SALVADO) num++;
		}

		return num;
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