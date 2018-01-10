/**
 *  Explica cales son os métodos que temos para mover a cámara.
 *   Carga un gráfico sinxelo no centro da pantalla
 */

package com.my29bpdj.renderer;
 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.my29bpdj.game.AssetsJuego;
import com.my29bpdj.game.Utiles;
import com.my29bpdj.modelo.Mundo;
 
public class Test03RendererJuego implements InputProcessor {
 
        private SpriteBatch spritebatch;
 
        private OrthographicCamera camara2d;
       
        private Vector3 temporal;
 
        public Test03RendererJuego() {
                camara2d = new OrthographicCamera();
                spritebatch = new SpriteBatch();
 
                temporal = new Vector3();
               
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
                spritebatch.draw(AssetsJuego.textureAlien, temporal.x,temporal.y, 15, 15);
                spritebatch.end();
 
        }
 
        public void resize(int width, int height) {
 
                camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO,
                                Mundo.TAMANO_MUNDO_ALTO);
                camara2d.update();
 
                spritebatch.setProjectionMatrix(camara2d.combined);
 
        }
 
        public void dispose() {
 
                Gdx.input.setInputProcessor(null);
                spritebatch.dispose();
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