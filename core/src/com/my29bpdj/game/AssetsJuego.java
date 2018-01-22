package com.my29bpdj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;

public class AssetsJuego {
 
		public static Texture textureAlien;
		public static Texture textureAlienDead;
		public static Texture textureAlienRescue;
		public static Texture textureAutobus;
		public static Texture textureCoche;
		public static Texture textureFondo;
		public static Texture textureNave;
		public static Texture textureRoca;
		public static Texture textureTronco;
		public static Texture texturePuntoNegro;
		public static Animation naveAnimacion;
		public static Texture textureCursor;
		public static Animation mariposaAnimacion;


		/**
		* Método encargado de cargar todas as texturas
		*/
		public static void cargarTexturas(){
//               	LIBGDX_itin1_alien.png (textureAlien).
			FileHandle imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_alien.png");
			textureAlien = new Texture(imageFileHandle);
//                libgdx_itin1_alien_dead.png (textureAlienDead).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_alien_dead.png");
			textureAlienDead = new Texture(imageFileHandle);
//                libgdx_itin1_alien_rescue.png (textureAlienRescue).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_alien_rescue.png");
			textureAlienRescue = new Texture(imageFileHandle);
//                libgdx_itin1_autobus1.png (textureAutobus).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_autobus1.png");
			textureAutobus = new Texture(imageFileHandle);
//                libgdx_itin1_coche1.png (textureCoche).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_coche1.png");
			textureCoche = new Texture(imageFileHandle);
//                libgdx_itin1_fondoxogo.jpg (textureFondo).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_fondoxogo.jpg");
			textureFondo = new Texture(imageFileHandle);
//                libgdx_itin1_nave.png (textureNave).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_nave.png");
			textureNave = new Texture(imageFileHandle);
//                libgdx_itin1_roca.png (textureRoca).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_roca.png");
			textureRoca = new Texture(imageFileHandle);
//                libgdx_itin1_tronco.jpg (textureTronco).
			imageFileHandle = Gdx.files.internal("graficos/libgdx_itin1_tronco.jpg");
			textureTronco = new Texture(imageFileHandle);
//                libgdx_puntonegro.jpg (texturePuntoNegro)
			imageFileHandle = Gdx.files.internal("graficos/libgdx_puntonegro.jpg");
			texturePuntoNegro = new Texture(imageFileHandle);

//				Animación nave
			imageFileHandle = Gdx.files.internal("graficos/libgdx_spaceship.png");
			generarAnimacionNave(imageFileHandle);

		// Cursor
			imageFileHandle = Gdx.files.internal("graficos/controles/libgdx_itin1_controis.png");
			textureCursor = new Texture(imageFileHandle);

		// Animación mariposa
			imageFileHandle = Gdx.files.internal("graficos/butterfly.png");
			generarAnimacionMariposa(imageFileHandle);

		}

	private static void generarAnimacionMariposa(FileHandle imageFileHandle) {
		Texture textureAnimMariposa = new Texture(imageFileHandle);
		TextureRegion[][] tmp = TextureRegion.split(textureAnimMariposa,30,25);
		int num_columnas = tmp[0].length;
		int num_filas = tmp.length;
		TextureRegion[] framesanimacion = new TextureRegion[num_columnas*(num_filas-1)];
		int cont=0;
		for (int fila = 0; fila < num_filas-1; fila++) {
			for (int col = 0; col < num_columnas; col++) {
				framesanimacion[cont] = tmp[fila][col];
				cont++;
			}
		}
		mariposaAnimacion = new Animation(0.15f, framesanimacion);
	}

	private static void generarAnimacionNave(FileHandle imageFileHandle) {
		Texture textureAnimNave = new Texture(imageFileHandle);
		TextureRegion[][] tmp = TextureRegion.split(textureAnimNave,200,110);
		int num_columnas = tmp[0].length;
		int num_filas = tmp.length;
		TextureRegion[] framesanimacion = new TextureRegion[num_columnas*num_filas-1];
		int cont=0;
		for(int fila=0; fila<num_filas;fila++){
			for(int col=0; col<num_columnas;col++){
				if (!((fila==1)&&(col==0))) {
					framesanimacion[cont] = tmp[fila][col];
					cont++;
				}
			}
		}
		naveAnimacion = new Animation(0.15f, framesanimacion);
	}

	/**
		* Método encargado de liberar todas as texturas
		*/
		public static void liberarTexturas(){
			textureAlien.dispose();
			textureAlienDead.dispose();
			textureAlienRescue.dispose();
			textureAutobus.dispose();
			textureCoche.dispose();
			textureFondo.dispose();
			textureNave.dispose();
			textureRoca.dispose();
			textureTronco.dispose();
			texturePuntoNegro.dispose();
			textureCursor.dispose();
		}
}