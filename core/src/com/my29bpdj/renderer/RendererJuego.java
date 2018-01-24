package com.my29bpdj.renderer;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.my29bpdj.game.AssetsJuego;
import com.my29bpdj.modelo.Alien;
import com.my29bpdj.modelo.Controles;
import com.my29bpdj.modelo.ElementoMovil;
import com.my29bpdj.modelo.Mariposa;
import com.my29bpdj.modelo.Mundo;
import com.my29bpdj.modelo.Nave;

/**
 * Created by dam203 on 09/01/2018.
 */


public class RendererJuego implements InputProcessor{

	private SpriteBatch spritebatch;
	private OrthographicCamera camara2d;
	private Vector3 temporal;
	private boolean debugger=false;
	private ShapeRenderer shaperender;
	private Mundo meuMundo;
	private float crono;
	private float crono2;




	public RendererJuego(Mundo mundo) {
		this.meuMundo = mundo;
		camara2d = new OrthographicCamera();
		spritebatch = new SpriteBatch();
		shaperender = new ShapeRenderer();
		temporal = new Vector3();
		crono = 0;
		crono2=0;
		Gdx.input.setInputProcessor(this);

	}

    /**
     * Debuxa todos os elementos graficos da pantalla
     *
     * @param delta
     *            : tempo que pasa entre un frame e o seguinte.
     */
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spritebatch.begin();
		dibujarFondo();
		dibujarNave();
		dibujarCoches();
		dibujarRocas();
		dibujarTroncos();
		dibujarMariposa(delta);
		dibujarAlien();
		dibujarControles();
		dibujarVidas();
		spritebatch.end();

        if (debugger){
            debugger();
        }
    }
	private void dibujarFondo(){
		spritebatch.draw(AssetsJuego.textureFondo,
				0,0,Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
	}

	private void dibujarAlien(){
		Alien alien = meuMundo.getAlien();
		spritebatch.draw(AssetsJuego.textureAlien,
				alien.getPosicion().x,alien.getPosicion().y,alien.getTamano().x,alien.getTamano().y);
	}

	private void dibujarNave(){
		Nave nave = meuMundo.getNave();
		crono+=Gdx.graphics.getDeltaTime();
		TextureRegion currentFrame = (TextureRegion) AssetsJuego.naveAnimacion.getKeyFrame(crono, true);
		spritebatch.draw(currentFrame, nave.getPosicion().x,
						nave.getPosicion().y, nave.getTamano().x,
						nave.getTamano().y);
	}

	private void dibujarMariposa(float delta){
		Mariposa mariposa = meuMundo.getMariposa();
		crono2+=delta;
		TextureRegion currentFrame = (TextureRegion) AssetsJuego.mariposaAnimacion.getKeyFrame(crono2, true);
		spritebatch.draw(currentFrame, mariposa.getPosicion().x,
				mariposa.getPosicion().y, mariposa.getTamano().x,
				mariposa.getTamano().y);
	}

	private void dibujarCoches(){
		Texture textura=null;

		for (ElementoMovil coche : meuMundo.getCoches()){
			switch(coche.getTipo()){
				case COCHE:
					textura = AssetsJuego.textureCoche;
					break;
				default:
					textura = AssetsJuego.textureAutobus;
					break;
			}
			if (coche.getVelocidade()<0){
				spritebatch.draw(textura,coche.getPosicion().x+coche.getTamano().x,coche.getPosicion().y,-coche.getTamano().x,coche.getTamano().y);
			}
			else{
				spritebatch.draw(textura,coche.getPosicion().x,coche.getPosicion().y,coche.getTamano().x,coche.getTamano().y);
			}
		}
	}

	private void dibujarRocas() {
		for(ElementoMovil roca: meuMundo.getRocas()) {
			spritebatch.draw(AssetsJuego.textureRoca, roca.getPosicion().x, roca.getPosicion().y, roca.getTamano().x, roca.getTamano().y);
		}
	}

	private void dibujarTroncos(){
		for (ElementoMovil tronco : meuMundo.getTroncos()){
			spritebatch.draw(AssetsJuego.textureTronco,tronco.getPosicion().x,tronco.getPosicion().y,tronco.getTamano().x,tronco.getTamano().y);
		}

	}

	private void dibujarControles(){
		// Fondo negro
		spritebatch.draw(AssetsJuego.texturePuntoNegro, Controles.FONDO_NEGRO.x,Controles.FONDO_NEGRO.y,
				Controles.FONDO_NEGRO.width, Controles.FONDO_NEGRO.height);
//		if (Gdx.app.getType()== Application.ApplicationType.Android)
			spritebatch.draw(AssetsJuego.textureCursor,Controles.CONTROL.x,Controles.CONTROL.y,
					Controles.CONTROL.width, Controles.CONTROL.height);
	}

	private void dibujarVidas(){
		Texture textura;
		int posx=Controles.POSVIDAS;
		for(Alien.TIPOS_VIDA vida : meuMundo.getAlien().getNumVidas()){
			if(vida == Alien.TIPOS_VIDA.MUERTO)
				textura = AssetsJuego.textureAlienDead;
			else if(vida == Alien.TIPOS_VIDA.SALVADO)
				textura = AssetsJuego.textureAlienRescue;
			else
				textura = AssetsJuego.textureAlien;

			spritebatch.draw(textura,posx,0,10,10);
			posx+=12;
		}
	}

	public OrthographicCamera getCamara2d(){
		return this.camara2d;
	}

	/**
     * Debuxa os gráficos en forma de figuras xeométricas
     */
	private void debugger(){
        shaperender.begin(ShapeRenderer.ShapeType.Line);
        shaperender.setColor(Color.BLUE);
        shaperender.box(meuMundo.getMariposa().getRectangulo().getX(), meuMundo.getMariposa().getRectangulo().getY(),0,
				meuMundo.getMariposa().getRectangulo().getWidth(),meuMundo.getMariposa().getRectangulo().getHeight(),0);
        shaperender.end();
    }

    public void resize(int width, int height) {
		camara2d.setToOrtho(false,Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
		camara2d.update();
		spritebatch.setProjectionMatrix(camara2d.combined);
		shaperender.setProjectionMatrix(camara2d.combined);
    }

    public void dispose() {
        Gdx.input.setInputProcessor(null);
        spritebatch.dispose();
        shaperender.dispose();
    }



    @Override
    public boolean keyDown(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub

        temporal.set(screenX,screenY,0);
        camara2d.unproject(temporal);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }
}