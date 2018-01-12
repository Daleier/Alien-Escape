/**
 *  Explica cales son os métodos que temos para mover a cámara.
 *   Carga un gráfico sinxelo no centro da pantalla
 */

package com.my29bpdj.renderer;
 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.my29bpdj.game.AssetsJuego;
import com.my29bpdj.game.Utiles;
import com.my29bpdj.modelo.Mundo;
 
public class Test03RendererJuego implements InputProcessor {
 
        private SpriteBatch spritebatch;
        private OrthographicCamera camara2d;
        private Vector3 temporal;
        private boolean debugger=true;
        private ShapeRenderer shaperender;

        public Test03RendererJuego() {
                camara2d = new OrthographicCamera();
                spritebatch = new SpriteBatch();
                shaperender = new ShapeRenderer();
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
                spritebatch.draw(AssetsJuego.textureAlienDead, Mundo.TAMANO_MUNDO_ANCHO/2+25,Mundo.TAMANO_MUNDO_ALTO/2+25, 15, 15);
                spritebatch.draw(AssetsJuego.textureAlienRescue, Mundo.TAMANO_MUNDO_ANCHO/2-25,Mundo.TAMANO_MUNDO_ALTO/2-25, 15, 15);
                spritebatch.draw(AssetsJuego.textureAutobus, Mundo.TAMANO_MUNDO_ANCHO/2+60,Mundo.TAMANO_MUNDO_ALTO/2+60, 15, 15);
                spritebatch.draw(AssetsJuego.textureCoche, Mundo.TAMANO_MUNDO_ANCHO/-60,Mundo.TAMANO_MUNDO_ALTO/-60, 15, 15);
                spritebatch.draw(AssetsJuego.textureFondo, Mundo.TAMANO_MUNDO_ANCHO/2+25,Mundo.TAMANO_MUNDO_ALTO/2+60, 15, 15);
                spritebatch.draw(AssetsJuego.textureNave, Mundo.TAMANO_MUNDO_ANCHO/2+60,Mundo.TAMANO_MUNDO_ALTO/2+25, 15, 15);
                spritebatch.draw(AssetsJuego.textureRoca, Mundo.TAMANO_MUNDO_ANCHO/2-25,Mundo.TAMANO_MUNDO_ALTO/2-60, 15, 15);
                spritebatch.draw(AssetsJuego.textureTronco, Mundo.TAMANO_MUNDO_ANCHO/2-60,Mundo.TAMANO_MUNDO_ALTO/2-25, 15, 15);
                spritebatch.draw(AssetsJuego.texturePuntoNegro, Mundo.TAMANO_MUNDO_ANCHO/2,Mundo.TAMANO_MUNDO_ALTO/2, 15, 15);
                spritebatch.end();

                if (debugger){
                        debugger();
                }
        }

        /**
         * Debuxa os gráficos en forma de figuras xeométricas
         */
        private void debugger(){
                shaperender.begin(ShapeRenderer.ShapeType.Line);
                shaperender.setColor(Color.BLUE);
                shaperender.rect(temporal.x,temporal.y,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2+25,Mundo.TAMANO_MUNDO_ALTO/2+25,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2-25,Mundo.TAMANO_MUNDO_ALTO/2-25,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2+60,Mundo.TAMANO_MUNDO_ALTO/2+60,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2-60,Mundo.TAMANO_MUNDO_ALTO/2-60,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2+25,Mundo.TAMANO_MUNDO_ALTO/2+60,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2+60,Mundo.TAMANO_MUNDO_ALTO/2+25,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2-25,Mundo.TAMANO_MUNDO_ALTO/2-60,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2-60,Mundo.TAMANO_MUNDO_ALTO/2-25,15,15);
                shaperender.rect(Mundo.TAMANO_MUNDO_ANCHO/2,Mundo.TAMANO_MUNDO_ALTO/2,15,15);
                shaperender.end();
        }
        public void resize(int width, int height) {

                camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO,
                                Mundo.TAMANO_MUNDO_ALTO);
                camara2d.update();

                spritebatch.setProjectionMatrix(camara2d.combined);
                shaperender.setProjectionMatrix(camara2d.combined);

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