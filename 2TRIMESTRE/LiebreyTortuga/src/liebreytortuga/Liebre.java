/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

/**
 * Clase Liebre
 * @author ruben
 */
public class Liebre extends Thread {

    private int casilla;
    private final Carrera carrera;
    private int poscarrera;
    
    /**
     * Método sobreescrito de la clase Thread para indicar el inicio del hilo
     */
    @Override
    public void run() {

        do {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {

            }
            int azar = (int) (Math.random() * 100);

            if (azar <= 20) {
                casilla = this.Duerme();
            }

            if (azar > 21 && azar <= 40) {
                casilla = this.GranSalto();
            }
            if (azar > 41 && azar <= 50) {
                casilla = this.ResbalonGrande();

            }
            if (azar > 51 && azar <= 80) {
                casilla = this.PequenoSalto();

            }
            if (azar > 81) {
                casilla = this.Resbalonpequeno();
            }
            poscarrera += casilla;
            if (poscarrera < 1) {
                poscarrera = 1;
            }

            carrera.turnoL(casilla);
          
        } while (poscarrera <= 70);
    }

    public Liebre(Carrera carrera) {
        this.poscarrera = 1;
        casilla = 1;
        this.carrera = carrera;
    }

    public int Duerme() {
        return 0;
    }

    public int GranSalto() {
        return 9;
    }

    public int ResbalonGrande() {
        return -12;
    }

    public int PequenoSalto() {
        return 1;
    }

    public int Resbalonpequeno() {
        return -2;
    }
}
