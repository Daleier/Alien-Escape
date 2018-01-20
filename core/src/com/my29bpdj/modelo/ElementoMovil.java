package com.my29bpdj.modelo;

import com.badlogic.gdx.math.Vector2;

public class ElementoMovil extends Personaje {

        public static enum TIPOS_ELEMENTOS {COCHE, AUTOBUS, TRONCO, ROCA};
        private TIPOS_ELEMENTOS tipo;

        public ElementoMovil(Vector2 posicion, Vector2 tamano, float velocidade_max,TIPOS_ELEMENTOS tipo) {
                super(posicion, tamano, velocidade_max);
				setVelocidade(velocidade_max);
                this.tipo=tipo;
        }

        public TIPOS_ELEMENTOS getTipo() {
                return tipo;
        }


        @Override
        public void update(float delta) {
                setPosicion(posicion.add((velocidade*delta),0));
        }
}