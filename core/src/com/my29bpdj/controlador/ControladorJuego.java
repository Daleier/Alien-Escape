package com.my29bpdj.controlador;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.my29bpdj.modelo.Alien;
import com.my29bpdj.modelo.Controles;
import com.my29bpdj.modelo.ElementoMovil;
import com.my29bpdj.modelo.Mariposa;
import com.my29bpdj.modelo.Mundo;
import com.my29bpdj.modelo.Nave;

import java.util.HashMap;

import static com.badlogic.gdx.math.MathUtils.random;


public class ControladorJuego {
	Mundo meuMundo;
	private Alien alien;
	private Mariposa mariposa;
	private Nave nave;


	public enum Keys {
        IZQUIERDA, DERECHA,ARRIBA, ABAJO
	}

	HashMap<Keys, Boolean> keys = new HashMap<ControladorJuego.Keys, Boolean>();{
		keys.put(Keys.IZQUIERDA, false);
		keys.put(Keys.DERECHA, false);
		keys.put(Keys.ARRIBA, false);
		keys.put(Keys.ABAJO, false);
	};
       
	public ControladorJuego(Mundo mundo){
		this.meuMundo=mundo;
		this.alien=meuMundo.getAlien();
		this.mariposa=meuMundo.getMariposa();
		this.nave = meuMundo.getNave();
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
								tronco.getPosicion().y), Mundo.TAMANO_TRONCO.cpy(), random(-70,-40), ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
				meuMundo.getTroncos().removeValue(tronco, true);
			}
			if (tronco.getPosicion().x > Mundo.TAMANO_MUNDO_ANCHO) {
				meuMundo.getTroncos().add(new ElementoMovil(new Vector2(MathUtils.random(-2 * Mundo.TAMANO_TRONCO.x, -Mundo.TAMANO_TRONCO.x),
						tronco.getPosicion().y), Mundo.TAMANO_TRONCO.cpy(), random(40,70), ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
				meuMundo.getTroncos().removeValue(tronco, true);
			}
		}
	}

	private void controlarNave(float delta){
		Nave nave = meuMundo.getNave();

		if ((nave.getPosicion().x > 33 && nave.getPosicion().x < 35) ||
				(nave.getPosicion().x > 133 && nave.getPosicion().x < 135) ||
				(nave.getPosicion().x > 227 && nave.getPosicion().x < 229))
		{
			nave.setParado(true);
		}
		if (nave.isParado()){
			nave.setTiempo(nave.getTiempo()+delta);
			if (nave.getTiempo() > nave.getTIEMPO_MOVIENDOSE()){
				nave.setTiempo(0);
				nave.setParado(false);
			}
		}
		if(!nave.isParado()){
			nave.setPosicion(nave.getPosicion().x+delta*nave.getVelocidade(),nave.getPosicion().y);

			// Se chega ó final do recorrido cambiamos de dirección
			if (nave.getPosicion().x >=Mundo.TAMANO_MUNDO_ANCHO-nave.getTamano().x){
				nave.setPosicion(Mundo.TAMANO_MUNDO_ANCHO-nave.getTamano().x,nave.getPosicion().y);
				nave.setVelocidade(-1*nave.getVelocidade());
			} else if (nave.getPosicion().x<=0) {
				nave.setPosicion(0,nave.getPosicion().y);
				nave.setVelocidade(-1*nave.getVelocidade());
			}
		}
	}

	private void controlarAlien(float delta){ //TODO refactorizar
		// Actualiza Alien
		alien.update(delta);

		// Impide que se mova fora dos límites da pantalla
		if (alien.getPosicion().x <=0){
			alien.setPosicion(0, alien.getPosicion().y);
		}
		else {
			if (alien.getPosicion().x >= Mundo.TAMANO_MUNDO_ANCHO-alien.getTamano().x){
				alien.setPosicion(Mundo.TAMANO_MUNDO_ANCHO-alien.getTamano().x, alien.getPosicion().y);
			}

		}

		if (alien.getPosicion().y <= Controles.FONDO_NEGRO.height){
			alien.setPosicion(alien.getPosicion().x,Controles.FONDO_NEGRO.height);
		}
		else {
			if (alien.getPosicion().y >= Mundo.TAMANO_MUNDO_ALTO-alien.getTamano().y){
				alien.setPosicion(alien.getPosicion().x, Mundo.TAMANO_MUNDO_ALTO-alien.getTamano().y);
			}
		}

		// Controla que suba enriba dun elemento móvil
		alien.setVelocidadMontado(0);
		for (ElementoMovil elem : meuMundo.getRocas()){
			if (Intersector.overlaps(elem.getRectangulo(), alien.getRectangulo())){
				alien.setVelocidadMontado(elem.getVelocidade());
			}
		}
		for (ElementoMovil elem : meuMundo.getTroncos()){
			if (Intersector.overlaps(elem.getRectangulo(), alien.getRectangulo())){
				alien.setVelocidadMontado(elem.getVelocidade());
			}
		}
        // Controla se lle colle un vehículo
        for (ElementoMovil elem : meuMundo.getCoches()){
            if (Intersector.overlaps(elem.getRectangulo(), alien.getRectangulo())){
                alien.setNumVidas(Alien.TIPOS_VIDA.MUERTO);
                alien.inicializarAlien();
            }
        }
        // Controla se cae a auga ou lava
        if (alien.getVelocidadMontado()==0) {
            boolean seguro = false;
            // Se está nunha zona segura xa non mira as perigosas
            for (int cont = 0; cont < Mundo.ZONAS_SEGURAS.length; cont++) {
                if (Intersector.overlaps(Mundo.ZONAS_SEGURAS[cont], alien.getRectangulo())) {
                    seguro = true;
                    break;
                }
            }
            if (!seguro) {
                for (int cont = 0; cont < Mundo.ZONAS_PERIGOSAS.length; cont++) {
                    if (Intersector.overlaps(Mundo.ZONAS_PERIGOSAS[cont], alien.getRectangulo())) {
                        alien.setNumVidas(Alien.TIPOS_VIDA.MUERTO);
                        alien.inicializarAlien();
                    }
                }
            }
        }
		// Controla se mariposa toca o alien
        if (Intersector.overlaps(alien.getRectangulo(), mariposa.getRectangulo())){
			alien.setNumVidas(Alien.TIPOS_VIDA.MUERTO);
            alien.inicializarAlien();
            mariposa.inicializarMariposa();
        }

		// Controla si alien llega a la nave
        if (Intersector.overlaps(alien.getRectangulo(), nave.getRectangulo())){
            alien.setNumVidas(Alien.TIPOS_VIDA.SALVADO);
            alien.inicializarAlien();
        }
	}

	private void controlarMariposa(float delta){
		mariposa.puntoDestino.set(new Vector2(alien.getPosicion().x, alien.getPosicion().y));
		Vector2 direccion = mariposa.puntoDestino.cpy().sub(mariposa.posicion);
		mariposa.direccion.set(direccion.nor());
		mariposa.update(delta);
	}

	public void update(float delta){
		meuMundo.updateCronometro(delta);
		controlarNave(delta);
		controlarCoches(delta);
		controlarRocas(delta);
		controlarTroncos(delta);
		controlarMariposa(delta);
		controlarAlien(delta);

		procesarEntradas();
	}

	/**
	 * Modifica o estado do mapa de teclas e pon a true
	 * @param tecla: tecla pulsada
	 */
	public void pulsarTecla(Keys tecla){
		keys.put(tecla, true);
	}

	/**
	 * Modifica o estado do mapa de teclas e pon a false
	 * @param tecla: tecla liberada
	 */
	public void liberarTecla(Keys tecla){
		keys.put(tecla, false);
	}

	private void procesarEntradas(){

		if (keys.get(Keys.DERECHA))
			alien.setVelocidadeX(alien.velocidade_max);
		if (keys.get(Keys.IZQUIERDA))
			alien.setVelocidadeX(-alien.velocidade_max);
		if (!(keys.get(Keys.IZQUIERDA)) && (!(keys.get(Keys.DERECHA))))
			alien.setVelocidadeX(0);

		if (keys.get(Keys.ARRIBA))
			alien.setVelocidadeY(alien.velocidade_max);
		if (keys.get(Keys.ABAJO))
			alien.setVelocidadeY(-alien.velocidade_max);
		if (!(keys.get(Keys.ARRIBA)) && (!(keys.get(Keys.ABAJO))))
			alien.setVelocidadeY(0);

	}

}