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
		if (!arquivo.exists()) {
			HighScores.save();
			System.out.println("Non encontrado");
		}
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
				encontrado=true;
				for (int j=highscores.length; j < 1; j-- ){
					HighScores.highscores[j] = HighScores.highscores[j-1];
				}
				HighScores.highscores[i] =  Integer.toString(puntuacion);
				for(String k : highscores)
					System.out.println(k+",");
			} else
				i++;
		}
		if (encontrado)
			HighScores.save();
	}

	private static void save() {
		FileHandle arquivo = Gdx.files.external(HighScores.archivoHighscores);
		arquivo.writeString(HighScores.highscores[0] + ",", false);
		arquivo.writeString(HighScores.highscores[1] + ",", true);
		arquivo.writeString(HighScores.highscores[2], true);

		/*for(int n = 1; n<highscores.length;n++){
			arquivo.writeString(HighScores.highscores[n] + ",", true);
		}*/
	}
}
