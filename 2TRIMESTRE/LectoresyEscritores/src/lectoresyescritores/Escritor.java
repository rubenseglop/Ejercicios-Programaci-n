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
public class Escritor extends Thread {

    int escritor;
    Libro milibro;

    public Escritor(int escritor, Libro milibro) {

        super();
        this.escritor = escritor;
        this.milibro = milibro;
    }

    @Override
    public void run() {

        boolean bucleinfinito = false;
        while (!bucleinfinito) {
            try {
                sleep((int) (Math.random() * 4000 + 1000));  // Reloj pausa entre 1 y 5 seg.
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                milibro.escribir(escritor);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
