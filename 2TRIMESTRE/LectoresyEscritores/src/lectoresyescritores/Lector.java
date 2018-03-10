/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectoresyescritores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruben
 */
public class Lector extends Thread {

    int lector;
    Libro milibro;

    public Lector(int lector, Libro milibro) {
        super();
        this.lector = lector;
        this.milibro = milibro;
    }

    @Override
    public void run() {
        boolean bucleinfinito = false;
        while (!bucleinfinito) {
            try {
                sleep((int) (Math.random() * 4000 + 1000));  // Reloj pausa entre 1 y 5 seg.
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                milibro.leer(lector); //Escribe
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
