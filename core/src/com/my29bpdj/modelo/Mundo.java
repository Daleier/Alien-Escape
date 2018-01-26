package com.my29bpdj.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
/**
 * Created by dam203 on 10/01/2018.
 */

public class Mundo {
    public static final int TAMANO_MUNDO_ANCHO=300;
    public static final int TAMANO_MUNDO_ALTO=500;
    public final static Vector2 TAMANO_COCHES = new Vector2(20,15);
    public final static Vector2 TAMANO_AUTOBUSES = new Vector2(30,15);
    public final static Vector2 TAMANO_ROCA = new Vector2(60,60);
	public final static Vector2 TAMANO_TRONCO = new Vector2(80,40);
    public static final Rectangle ZONAS_PERIGOSAS[]={new Rectangle(0,40,300,120),
            new Rectangle(0,220,300,120), new Rectangle(0,420,300,80)};
    public static final Rectangle ZONAS_SEGURAS[]={new Rectangle(40,420,20,60),
            new Rectangle(140,420,20,60), new Rectangle(240,420,20,60)};  // AS PLATAFORMAS QUE ESTAN ENRIBA DA LAVA.
    public static final float PROPORCION_REAL_MUNDO_ANCHO = ((float) Gdx.graphics.getWidth() / Mundo.TAMANO_MUNDO_ANCHO);
    public static final float PROPORCION_REAL_MUNDO_ALTO = ((float) Gdx.graphics.getHeight() / Mundo.TAMANO_MUNDO_ALTO);
    private final static int TEMPO_INICIAL=120;

    private float cronometro;
    private Alien alien;
    private Nave nave;
    private Mariposa mariposa;
    private Array<ElementoMovil>coches;
    private Array<ElementoMovil>rocas;
	private Array<ElementoMovil>troncos;


	public Mundo(){
        alien = new Alien(new Vector2(100,20), new Vector2(15,15),this.TAMANO_MUNDO_ANCHO/3);
        nave = new Nave(new Vector2(0,480), new Vector2(40,20), 60);
        mariposa = new Mariposa(new Vector2(150,400), new Vector2(30,25),15);

        coches = new Array<ElementoMovil>();
        addCoches();
        rocas = new Array<ElementoMovil>();
        addRocas();
		troncos = new Array<ElementoMovil>();
		addTroncos();
        cronometro=TEMPO_INICIAL;

    }

	private void addTroncos() {
		troncos.add(new ElementoMovil(new Vector2(100,220),TAMANO_TRONCO.cpy(),-50,ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
		troncos.add(new ElementoMovil(new Vector2(60,260),TAMANO_TRONCO.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
		troncos.add(new ElementoMovil(new Vector2(150,300),TAMANO_TRONCO.cpy(),-70,ElementoMovil.TIPOS_ELEMENTOS.TRONCO));
	}

	private void addCoches() {
        coches.add(new ElementoMovil(new Vector2(0,345),TAMANO_AUTOBUSES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(30,345),TAMANO_AUTOBUSES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(70,345),TAMANO_COCHES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
        coches.add(new ElementoMovil(new Vector2(105,345),TAMANO_COCHES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(140,345),TAMANO_AUTOBUSES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(210,345),TAMANO_AUTOBUSES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(245,345),TAMANO_COCHES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(278,345),TAMANO_COCHES.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.COCHE));

//        coches.add(new ElementoMovil(new Vector2(5,380),TAMANO_COCHES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(40,380),TAMANO_COCHES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
        coches.add(new ElementoMovil(new Vector2(70,380),TAMANO_COCHES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(105,380),TAMANO_COCHES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(150,380),TAMANO_AUTOBUSES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
        coches.add(new ElementoMovil(new Vector2(180,380),TAMANO_AUTOBUSES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(220,380),TAMANO_AUTOBUSES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(265,380),TAMANO_AUTOBUSES.cpy(),40,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));

        coches.add(new ElementoMovil(new Vector2(0,400),TAMANO_AUTOBUSES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(35,400),TAMANO_COCHES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(70,400),TAMANO_AUTOBUSES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(115,400),TAMANO_COCHES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(170,400),TAMANO_AUTOBUSES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(210,400),TAMANO_AUTOBUSES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(245,400),TAMANO_COCHES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
        coches.add(new ElementoMovil(new Vector2(278,400),TAMANO_COCHES.cpy(),-45,ElementoMovil.TIPOS_ELEMENTOS.COCHE));

        coches.add(new ElementoMovil(new Vector2(0,365),TAMANO_COCHES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(35,365),TAMANO_COCHES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
        coches.add(new ElementoMovil(new Vector2(70,365),TAMANO_AUTOBUSES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(115,365),TAMANO_COCHES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(140,365),TAMANO_AUTOBUSES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(200,365),TAMANO_AUTOBUSES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
//        coches.add(new ElementoMovil(new Vector2(240,365),TAMANO_COCHES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.COCHE));
//        coches.add(new ElementoMovil(new Vector2(278,365),TAMANO_AUTOBUSES.cpy(),-65,ElementoMovil.TIPOS_ELEMENTOS.AUTOBUS));
    }

    private void addRocas() {
        rocas.add(new ElementoMovil(new Vector2(175,100),TAMANO_ROCA.cpy(),-50,ElementoMovil.TIPOS_ELEMENTOS.ROCA));
        rocas.add(new ElementoMovil(new Vector2(10,100),TAMANO_ROCA.cpy(),-50,ElementoMovil.TIPOS_ELEMENTOS.ROCA));

        rocas.add(new ElementoMovil(new Vector2(150,40),TAMANO_ROCA.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.ROCA));
        rocas.add(new ElementoMovil(new Vector2(25,40),TAMANO_ROCA.cpy(),50,ElementoMovil.TIPOS_ELEMENTOS.ROCA));

    }

    public Alien getAlien() {
        return alien;
    }

    public Nave getNave(){
        return nave;
    }

    public Mariposa getMariposa() {
        return mariposa;
    }

    public Array<ElementoMovil>getCoches(){
        return coches;
    }

    public Array<ElementoMovil>getRocas() {
        return rocas;
    }

    public Array<ElementoMovil> getTroncos() {
		return troncos;
	}

    public int getCronometro() {
        return (int)cronometro;
    }

    public void setCronometro(float cronometro) {
        this.cronometro = cronometro;
    }

    public void updateCronometro(float delta){
        cronometro-=delta;
    }
}