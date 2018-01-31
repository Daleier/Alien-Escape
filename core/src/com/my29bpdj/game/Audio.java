package com.my29bpdj.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.my29bpdj.pantallas.PantallaPresentacion;

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
	public static Music[] ovni_alcanzado = new Music[3];


	public static void iniciarAudio() {
		audioCoche01 = Gdx.audio.newSound(Gdx.files.internal("musica/coche01.mp3"));
		claxon[0] = audioCoche01;
		audioCoche02 = Gdx.audio.newSound(Gdx.files.internal("musica/coche02.mp3"));
		claxon[1] = audioCoche02;
		audioCoche03 = Gdx.audio.newSound(Gdx.files.internal("musica/coche03.mp3"));
		claxon[2] = audioCoche03;
		audioFin = Gdx.audio.newMusic(Gdx.files.internal("musica/fin.mp3"));
		audioInicio = Gdx.audio.newMusic(Gdx.files.internal("musica/inicio.mp3"));
		audioJuego = Gdx.audio.newMusic(Gdx.files.internal("musica/juego.mp3"));
		audioJuego.setLooping(true);
		audioMovimiento = Gdx.audio.newMusic(Gdx.files.internal("musica/movimiento.ogg"));
		audioMovimiento.setLooping(true);
		audioMuerte = Gdx.audio.newMusic(Gdx.files.internal("musica/muerte.mp3"));
		audioOvni01_alcanzado = Gdx.audio.newMusic(Gdx.files.internal("musica/ovni01_alcanzado.mp3"));
		audioOvni02_alcanzado = Gdx.audio.newMusic(Gdx.files.internal("musica/ovni02_alcanzado.mp3"));
		audioOvni03_alcanzado = Gdx.audio.newMusic(Gdx.files.internal("musica/ovni03_alcanzado.mp3"));
		audioOvni_contacto = Gdx.audio.newSound(Gdx.files.internal("musica/ovni_contacto.mp3"));
		audioPresentacion = Gdx.audio.newMusic(Gdx.files.internal("musica/presentacion.mp3"));
		audioPresentacion.setLooping(true);
		audioSpaceship = Gdx.audio.newMusic(Gdx.files.internal("musica/space_ship_floating_sound.mp3"));
		ovni_alcanzado[0] = Audio.audioOvni01_alcanzado;
		ovni_alcanzado[1] = Audio.audioOvni02_alcanzado;
		ovni_alcanzado[2] = Audio.audioOvni03_alcanzado;
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

	public static void setVolume() {
		if(PantallaPresentacion.musicaOn){
			audioFin.setVolume(0.5f);
			audioInicio.setVolume(0.5f);
			audioJuego.setVolume(0.5f);
			audioMovimiento.setVolume(0.5f);
			audioMuerte.setVolume(0.5f);
			audioOvni01_alcanzado.setVolume(0.5f);
			audioOvni02_alcanzado.setVolume(0.5f);
			audioOvni03_alcanzado.setVolume(0.5f);
			audioPresentacion.setVolume(0.5f);
			audioSpaceship.setVolume(0.3f);
		}else{
			audioFin.setVolume(0);
			audioInicio.setVolume(0);
			audioJuego.setVolume(0);
			audioMovimiento.setVolume(0);
			audioMuerte.setVolume(0);
			audioOvni01_alcanzado.setVolume(0);
			audioOvni02_alcanzado.setVolume(0);
			audioOvni03_alcanzado.setVolume(0);
			audioPresentacion.setVolume(0);
			audioSpaceship.setVolume(0);
		}
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

