/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

//import java.util.logging.*;
/**
 *
 * @author ruben
 */
public class Liebre extends Thread {

    private int fin;
    private int casilla = 1;

    private Carrera c;

    @Override
    public void run() {

    }

    public Liebre(Carrera c) {
        casilla = 1;
        this.c = c;
        fin = 0;

    }

    public void mueveL() {
        while (casilla <= 70 && fin == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
            }
            int azar = (int) (Math.random() * 100);
            if (azar <= 20) {
                casilla = casilla + this.Duerme();
            }

            if (azar > 21 && azar <= 40) {
                casilla = casilla + this.GranSalto();
            }
            if (azar > 41 && azar <= 50) {
                casilla = casilla - this.ResbalonGrande();
                if (casilla < 1) {
                    casilla = 1;
                }
            }
            if (azar > 51 && azar <= 80) {
                casilla = casilla + this.PequenoSalto();

            }
            if (azar > 81) {
                casilla = casilla - this.Resbalonpequeno();
                if (casilla < 1) {
                    casilla = 1;
                }
            }
            String imprimir = "";

            for (int i = 0; i < this.getCasilla(); i++) {
                imprimir = imprimir + " ";

            }
            System.out.println(imprimir + "L");
        }
    }

    private int Duerme() {
        return 0;

    }

    private int GranSalto() {
        return 9;
    }

    private int ResbalonGrande() {
        return 12;
    }

    private int PequenoSalto() {
        return 1;

    }

    private int Resbalonpequeno() {
        return 2;
    }

    public int getCasilla() {
        return casilla;
    }

    public void finProceso() {
        fin++;
    }
}
