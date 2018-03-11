/*
 * He realizado cambios en esta parte del código
 * 
 * 
 */
package liebreytortuga;

/**
 * Clase Carrera que controla los turnos de cada participante
 *
 * @author ruben
 */
public class Carrera {

    private int posicionL;
    private int posicionT;
    private boolean reloj;
    private boolean meta;

    /**
     * Constructor en donde pongo las posiciones de los participantes a 1
     */
    public Carrera() {
        this.meta = false;
        this.reloj = false;
        posicionL = 1;
        posicionT = 1;
    }
    private int casillaL, casillaT;

    /**
     * Método sincronizado que invoca el turno de la liebre
     *
     * @param casillasAMover introduzco el número de casilla a mover en la
     * carrera
     */
    public synchronized void turnoL(int casillasAMover) {

        while (reloj == true && meta == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        //Muevo mi Liebre

        posicionL = posicionL + casillasAMover;
        if (posicionL < 1) {
            posicionL = 1;
        }
        reloj = false;
    }

    /**
     * Método sincronizado que invoca el turno de la tortuga
     *
     * @param casillasAMover
     */
    public synchronized void turnoT(int casillasAMover) {
        String linea = "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>";
        while (reloj == true && meta == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        //Muevo mi tortuga
        posicionT = posicionT + casillasAMover;
        if (posicionT < 1) {
            posicionT = 1;
        }
        if (posicionL <= 70 && meta == false) {
            for (int i = 1; i <= posicionL; i++) {
                System.out.print(" ");
                if (posicionL == i) {
                    System.out.println("L");
                }
            }
            if (posicionT <= 70 && meta == false) {
                for (int i = 1; i <= posicionT; i++) {
                    System.out.print(" ");
                    if (posicionT == i) {
                        System.out.println("T");
                    }
                }
            }
        }

        if (posicionL <= 70 && posicionT <= 70 && meta == false) {
            System.out.println(linea);
            reloj = false;
        }

        // Llegada a la meta, pongo la variable meta = true para indicar que finalice los hilos
        if (posicionL >= 70 && posicionT >= 70 && meta == false) {
            System.out.println("Han acabado en empate!!");
            meta = true;
        } else if (posicionL >= 70 && posicionT < 70 && meta == false) {
            System.out.println("Ha ganado la liebre");
            meta = true;
        } else if (posicionT >= 70 && posicionL < 70 && meta == false) {
            System.out.println("Ha ganado la tortuga");
            meta = true;
        }
    }
}
