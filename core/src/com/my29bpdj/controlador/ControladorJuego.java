package com.my29bpdj.controlador;

import com.my29bpdj.modelo.ElementoMovil;
import com.my29bpdj.modelo.Mundo;

public class ControladorJuego {
        Mundo meuMundo;
       
        public ControladorJuego(Mundo mundo){
                this.meuMundo=mundo;
               
         }

        private void controlarCoches(float delta) {

                for (ElementoMovil coche : meuMundo.getCoches()) {
                        coche.update(delta);
                }
        }

        public void update(float delta){
                controlarCoches(delta);
        }
 
}