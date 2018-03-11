/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

import java.util.logging.*;

/**
 * 
 * @author ruben
 */
public class Tortuga extends Thread {

    private int casilla;
    private Carrera carrera1;
    private int poscarrera = 1;

    /**
     * Método sobreescrito de la clase Thread para indicar el inicio del hilo
     */
    @Override
    public void run() {

        do {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Cálculo de las casillas a moverse
            int azar = (int) (Math.random() * 100);
            if (azar <= 50) {
                casilla = this.AvanceRapido();
            }

            if (azar > 51 && azar <= 70) {
                casilla = this.Resbalar();
            }
            if (azar > 71) {
                casilla = this.AvanceLento();
            }
            poscarrera += casilla;

            if (poscarrera < 1) {
                poscarrera = 1;
            }

            carrera1.turnoT(casilla);

        } while (poscarrera <= 70);

    }

    /**
     * Constructor de la tortuga
     * @param carrera 
     */
    public Tortuga(Carrera carrera) {
        casilla = 1;
        this.carrera1 = carrera;

    }
    
    // Movimientos de la tortuga
    private int AvanceRapido() {
        return 3;
    }

    private int Resbalar() {
        return -6;
    }

    private int AvanceLento() {
        return 1;
    }
}
