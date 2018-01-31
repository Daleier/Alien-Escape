package com.my29bpdj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by dam203 on 31/01/2018.
 */

public class HighScores {
	public static String[] highscores = { "0", "0", "0" };
	public static String archivoHighscores = "highscores.dat";

	public static void load() {
		FileHandle arquivo = Gdx.files.external(HighScores.archivoHighscores);
		if (!arquivo.exists())
			HighScores.save();
		String scores = arquivo.readString();
		highscores = scores.split(",");
	}

	public static void engadirPuntuacion(int puntuacion) {
		boolean encontrado = false;
		int i = 0;
		while ((i < HighScores.highscores.length) && (!encontrado)) {
			if (puntuacion > Integer.parseInt(HighScores.highscores[i])) {
				/*Desplazar los valores inferiores una posición a la derecha
				 * para no perder los marcadores previos
				 */
				//TODO corregir
				Utiles.imprimirLog("Highscores", "engadirPuntuacion", "Posicion: "+i+" Puntuacion: "+highscores[i]);
				if (i < highscores.length-1) {
					HighScores.highscores[i + 1] = highscores[i];
					highscores[i] = Integer.toString(puntuacion);
				}
				i++;
			} else
				encontrado=true;
		}
		if (encontrado)
			HighScores.save();
	}

	private static void save() {
		FileHandle arquivo = Gdx.files.external(HighScores.archivoHighscores);
		arquivo.writeString(HighScores.highscores[0] + ",", false);
		for(int n = 1; n<highscores.length;n++){
			arquivo.writeString(HighScores.highscores[n] + ",", true);
		}
	}
}
