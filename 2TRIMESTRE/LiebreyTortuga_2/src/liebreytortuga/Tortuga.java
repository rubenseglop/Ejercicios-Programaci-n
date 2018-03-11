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
public class Tortuga extends Thread {

    private int fin;
    private int casilla = 1;
    private final int numero; //Id de participante

    @Override
    public void run() {
        if (fin == 0) {
            while (casilla <= 70) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(Liebre.class.getName()).log(Level.SEVERE, null, ex);
                }
                int azar = (int) (Math.random() * 100);
                if (azar <= 50) {
                    casilla = casilla + this.AvanceRapido();
                }

                if (azar > 51 && azar <= 70) {
                    casilla = casilla - this.Resbalar();
                    if (casilla < 1) {
                        casilla = 1;
                    }
                }
                if (azar > 71) {
                    casilla = casilla + this.AvanceLento();
                }
                String imprimir = "";
                for (int i = 0; i < this.getCasilla(); i++) {
                    imprimir = imprimir + " ";

                }

                System.out.println(imprimir + "T" + numero);
            }
            String imprimir = "";
            for (int i = 0; i <= 70; i++) {
                imprimir = imprimir + "-";

            }
            System.out.println("METAAAAA!!!Para la Tortuga " + numero);
            fin++;
        }

    }

    public Tortuga(Carrera c, int numero) {
        casilla = 1;
        this.numero = numero;
        fin=0;

    }

    public int AvanceRapido() {
        return 3;
    }

    public int Resbalar() {
        return 6;
    }

    public int AvanceLento() {
        return 1;
    }

    public int getCasilla() {
        return casilla;

    }

    public void finProceso() {
        fin++;
    }
}
