/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

/**
 *
 * @author ruben
 */
public class LiebreyTortuga {

    /**
     * Inicio de programa
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        //Creo el reloj que sincronizará a los competidores
        Carrera carrera = new Carrera();

        //Creando a los competidores
        Liebre liebre = new Liebre(carrera);
        Tortuga tortuga = new Tortuga(carrera);

        // Añadiendo competidores a la carrera
        liebre.start();
        tortuga.start();
    }
}
