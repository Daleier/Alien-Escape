package com.my29bpdj.controlador;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.my29bpdj.modelo.ElementoMovil;
import com.my29bpdj.modelo.Mundo;

public class ControladorJuego {
        Mundo meuMundo;
       
        public ControladorJuego(Mundo mundo){
                this.meuMundo=mundo;
               
         }

        private void controlarCoches(float delta) {
                for(ElementoMovil coche: meuMundo.getCoches()){
                        coche.update(delta);
                        if (coche.getVelocidade()>0){   // Vai de esquerda a dereita
                                if (coche.getPosicion().x>=Mundo.TAMANO_MUNDO_ANCHO){
                                        coche.setPosicion(-Mundo.TAMANO_AUTOBUSES.x, coche.getPosicion().y);
                                }
                        }
                        else{   // Vai de dereita a esquerda
                                if (coche.getPosicion().x<=-coche.getTamano().x){
                                        if (coche.getTipo()==ElementoMovil.TIPOS_ELEMENTOS.COCHE)       // E un coche enton necesitamos situalo un pouco a dereita se non vai pisando o autobus
                                                coche.setPosicion(Mundo.TAMANO_MUNDO_ANCHO+Mundo.TAMANO_AUTOBUSES.x-Mundo.TAMANO_COCHES.x, coche.getPosicion().y);
                                        else
                                                coche.setPosicion(Mundo.TAMANO_MUNDO_ANCHO, coche.getPosicion().y);
                                }
                        }
                }
        }

        private void controlarRocas(float delta){
                for(ElementoMovil roca: meuMundo.getRocas()){
                	roca.update(delta);
					if (roca.getVelocidade()>0){   // izq a drta
							if (roca.getPosicion().x>=Mundo.TAMANO_MUNDO_ANCHO){
									roca.setPosicion(-Mundo.TAMANO_ROCA.x, roca.getPosicion().y);
							}
					} else{   // drta a izq
						if (roca.getPosicion().x<= -Mundo.TAMANO_ROCA.x){
							roca.setPosicion(Mundo.TAMANO_MUNDO_ANCHO, roca.getPosicion().y);
						}
					}
                }
        }

	private void controlarTroncos(float delta){
		for(ElementoMovil tronco: meuMundo.getTroncos()) {
			tronco.update(delta);
			if (tronco.getPosicion().x < -Mundo.TAMANO_TRONCO.x) {
				meuMundo.getTroncos().add(new ElementoMovil(
						new Vector2(MathUtils.random(Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ANCHO + Mundo.TAMANO_TRONCO.x),
								tronco.getPosicion().y), Mundo.TAMANO_TRONCO.cpy(), tronco.getVelocidade(), ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
				meuMundo.getTroncos().removeValue(tronco, true);

			}
			if (tronco.getPosicion().x > Mundo.TAMANO_MUNDO_ANCHO) {
				meuMundo.getTroncos().add(new ElementoMovil(new Vector2(MathUtils.random(-2 * Mundo.TAMANO_TRONCO.x, -Mundo.TAMANO_TRONCO.x),
						tronco.getPosicion().y), Mundo.TAMANO_TRONCO.cpy(), tronco.getVelocidade(), ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
				meuMundo.getTroncos().removeValue(tronco, true);
			}
		}
	}

        public void update(float delta){
                controlarCoches(delta);
                controlarRocas(delta);
                controlarTroncos(delta);
        }
 
}