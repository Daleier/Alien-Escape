package com.my29bpdj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
 
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

		/**
		* Método encargado de cargar todas as texturas
		*/
		public static void cargarTexturas(){
//               	LIBGDX_itin1_alien.png (textureAlien).
			FileHandle imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_alien.png");
			textureAlien = new Texture(imageFileHandle);
//                LIBGDX_itin1_alien_dead.png (textureAlienDead).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_alien_dead.png");
			textureAlienDead = new Texture(imageFileHandle);
//                LIBGDX_itin1_alien_rescue.png (textureAlienRescue).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_alien_rescue.png");
			textureAlienRescue = new Texture(imageFileHandle);
//                LIBGDX_itin1_autobus1.png (textureAutobus).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_autobus1.png");
			textureAutobus = new Texture(imageFileHandle);
//                LIBGDX_itin1_coche1.png (textureCoche).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_coche1.png");
			textureCoche = new Texture(imageFileHandle);
//                LIBGDX_itin1_fondoxogo.jpg (textureFondo).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_fondoxogo.jpg");
			textureFondo = new Texture(imageFileHandle);
//                LIBGDX_itin1_nave.png (textureNave).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_nave.png");
			textureNave = new Texture(imageFileHandle);
//                LIBGDX_itin1_roca.png (textureRoca).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_roca.png");
			textureRoca = new Texture(imageFileHandle);
//                LIBGDX_itin1_tronco.jpg (textureTronco).
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_itin1_tronco.jpg");
			textureTronco = new Texture(imageFileHandle);
//                LIBGDX_puntonegro.jpg (texturePuntoNegro)
			imageFileHandle = Gdx.files.internal("GRAFICOS/LIBGDX_puntonegro.jpg");
			texturePuntoNegro = new Texture(imageFileHandle);
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
		}
}