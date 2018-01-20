package com.my29bpdj.modelo;


import com.badlogic.gdx.math.Rectangle;

/**
 * Created by dam203 on 18/01/2018.
 */

public class Controles {
	public final static Rectangle FONDO_NEGRO = new Rectangle(0,0,Mundo.TAMANO_MUNDO_ANCHO,12);
	public final static Rectangle CONTROL = new Rectangle(10,40,50,70);
	public final static Rectangle FLECHA_IZQUIERDA = new Rectangle(Controles.CONTROL.x,Controles.CONTROL.y+Controles.CONTROL.height/3,
			Controles.CONTROL.width/2,Controles.CONTROL.height/3);
	public final static Rectangle FLECHA_DERECHA = new Rectangle(Controles.CONTROL.x+Controles.CONTROL.width/2,Controles.CONTROL.y+Controles.CONTROL.height/3,
			Controles.CONTROL.width/2,Controles.CONTROL.height/3);
	public final static Rectangle FLECHA_ARRIBA = new Rectangle(Controles.CONTROL.x,Controles.CONTROL.y+Controles.CONTROL.height*2/3,
			Controles.CONTROL.width, Controles.CONTROL.height/3);
	public final static Rectangle FLECHA_ABAJO = new Rectangle(Controles.CONTROL.x,Controles.CONTROL.y,
			Controles.CONTROL.width,Controles.CONTROL.height/3);
}
