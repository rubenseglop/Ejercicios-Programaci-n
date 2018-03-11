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
     * @param args the command line arguments
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
     

        String imprimir = "";
        for (int i = 0; i <= 70; i++) {
            imprimir = imprimir + "-";

        }
        int fincarrera = 0; // Determino cuando acabar con la carrera 
        while (fincarrera == 0) { // los if determinan a un sólo ganador y sale del bucle


            if (liebre.isAlive() == false) {
          
                tortuga.finProceso();
                     System.out.println(imprimir + "METAAAAA!!! para la Liebre");

                fincarrera++;
            }
          
            if (tortuga.isAlive() == false) {

                liebre.finProceso();
                
                System.out.println(imprimir + "METAAAAA!!! para la Tortuga");

                fincarrera++;
            }
        }
        System.out.println(" Fin carrera");
    }
}
