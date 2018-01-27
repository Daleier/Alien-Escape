package com.my29bpdj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

/**
 * Created by dam203 on 26/01/2018.
 */

public class Audio {

	public static Sound audioCoche01;
	public static Sound audioCoche02;
	public static Sound audioCoche03;
	public static Music audioFin;
	public static Music audioInicio;
	public static Music audioJuego;
	public static Music audioMovimiento;
	public static Music audioMuerte;
	public static Music audioOvni01_alcanzado;
	public static Music audioOvni02_alcanzado;
	public static Music audioOvni03_alcanzado;
	public static Sound audioOvni_contacto;
	public static Music audioPresentacion;
	public static Music audioSpaceship;

	private static boolean inicioPausada;
	private static boolean juegoPausada;
	private static boolean ovni01AlcanzadoPausada;
	private static boolean ovni02AlcanzadoPausada;
	private static boolean ovni03AlcanzadoPausada;
	private static boolean spaceshipPausada;
	public static Sound[] claxon = new Sound[3];
	private static Task claxonCoches;


	public static void iniciarAudio() {
		audioCoche01 = Gdx.audio.newSound(Gdx.files.internal("musica/coche01.mp3"));
		claxon[0] = audioCoche01;
		audioCoche02 = Gdx.audio.newSound(Gdx.files.internal("musica/coche02.mp3"));
		claxon[1] = audioCoche02;
		audioCoche03 = Gdx.audio.newSound(Gdx.files.internal("musica/coche03.mp3"));
		claxon[2] = audioCoche03;
		audioFin = Gdx.audio.newMusic(Gdx.files.internal("musica/fin.mp3"));
		audioFin.setVolume(0.5f);
		audioInicio = Gdx.audio.newMusic(Gdx.files.internal("musica/inicio.mp3"));
		audioInicio.setVolume(0.5f);
		audioJuego = Gdx.audio.newMusic(Gdx.files.internal("musica/juego.mp3"));
		audioJuego.setLooping(true);
		audioJuego.setVolume(0.5f);
		audioMovimiento = Gdx.audio.newMusic(Gdx.files.internal("musica/movimiento.wav"));
		audioMovimiento.setLooping(true);
		audioMovimiento.setVolume(0.5f);
		audioMuerte = Gdx.audio.newMusic(Gdx.files.internal("musica/muerte.mp3"));
		audioMuerte.setVolume(0.5f);
		audioOvni01_alcanzado = Gdx.audio.newMusic(Gdx.files.internal("musica/ovni01_alcanzado.mp3"));
		audioOvni01_alcanzado.setVolume(0.7f);
		audioOvni02_alcanzado = Gdx.audio.newMusic(Gdx.files.internal("musica/ovni02_alcanzado.mp3"));
		audioOvni02_alcanzado.setVolume(0.7f);
		audioOvni03_alcanzado = Gdx.audio.newMusic(Gdx.files.internal("musica/ovni03_alcanzado.mp3"));
		audioOvni03_alcanzado.setVolume(0.7f);
		audioOvni_contacto = Gdx.audio.newSound(Gdx.files.internal("musica/ovni_contacto.mp3"));
		audioPresentacion = Gdx.audio.newMusic(Gdx.files.internal("musica/presentacion.mp3"));
		audioPresentacion.setLooping(true);
		audioPresentacion.setVolume(0.5f);
		audioSpaceship = Gdx.audio.newMusic(Gdx.files.internal("musica/space_ship_floating_sound.mp3"));
		audioSpaceship.setVolume(0.3f);
	}

	public static void dispose(){
		audioCoche01.dispose();
		audioCoche02.dispose();
		audioCoche03.dispose();
		audioFin.dispose();
		audioInicio.dispose();
		audioJuego.dispose();
		audioMovimiento.dispose();
		audioMuerte.dispose();
		audioOvni01_alcanzado.dispose();
		audioOvni02_alcanzado.dispose();
		audioOvni03_alcanzado.dispose();
		audioOvni_contacto.dispose();
		audioPresentacion.dispose();
	}

	public static void iniciarClaxon(){
		claxonCoches = new Task(){
			@Override
			public void run() {
				Audio.claxon[MathUtils.random(0, 2)].play(0.2f);
			}
		};

		Timer.schedule(claxonCoches, 0, 2f);

	}

	public static void paraClaxon(){
		claxonCoches.cancel();
	}

	public static boolean isInicioPausada() {
		return inicioPausada;
	}

	public static void setInicioPausada(boolean inicioPausada) {
		Audio.inicioPausada = inicioPausada;
	}

	public static boolean isJuegoPausada() {
		return juegoPausada;
	}

	public static void setJuegoPausada(boolean juegoPausada) {
		Audio.juegoPausada = juegoPausada;
	}

	public static boolean isOvni01AlcanzadoPausada() {
		return ovni01AlcanzadoPausada;
	}

	public static void setOvni01AlcanzadoPausada(boolean ovni01AlcanzadoPausada) {
		Audio.ovni01AlcanzadoPausada = ovni01AlcanzadoPausada;
	}

	public static boolean isOvni02AlcanzadoPausada() {
		return ovni02AlcanzadoPausada;
	}

	public static void setOvni02AlcanzadoPausada(boolean ovni02AlcanzadoPausada) {
		Audio.ovni02AlcanzadoPausada = ovni02AlcanzadoPausada;
	}

	public static boolean isOvni03AlcanzadoPausada() {
		return ovni03AlcanzadoPausada;
	}

	public static void setOvni03AlcanzadoPausada(boolean ovni03AlcanzadoPausada) {
		Audio.ovni03AlcanzadoPausada = ovni03AlcanzadoPausada;
	}

	public static boolean isSpaceshipPausada() {
		return spaceshipPausada;
	}

	public static void setSpaceshipPausada(boolean spaceshipPausada) {
		Audio.spaceshipPausada = spaceshipPausada;
	}

}

