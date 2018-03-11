/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class LiebreyTortuga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creo el reloj que sincronizará a los competidores
        Carrera carrera = new Carrera();

        //Creando a los competidores
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta el número de Liebres y Tortugas");
        int nLie = sc.nextInt();
        int nTor = sc.nextInt();

        Liebre liebre[] = new Liebre[nLie];
        for (int i = 0; i >= nLie; i++) {

            liebre[i] = new Liebre(carrera, i);
            liebre[1].start();

        }

        Tortuga tortuga[] = new Tortuga[nTor];
        for (int i = 0; i >= nTor; i++) {

            tortuga[i] = new Tortuga(carrera, i);
            tortuga[i].start();
        }
//        
//        

        int fincarrera = 0; // Determino cuando acabar con la carrera 
        while (fincarrera == 0) {
            for (int i = 0; i <= nLie; i++) {
                if (liebre[i].isAlive() == false) {
                    fincarrera++;
                }

            }
            for (int i = 0; i <= nTor; i++) {
                if (tortuga[i].isAlive() == true) {
                    fincarrera++;
                }

            }
        }

        //detengo todos los procesos
        for (int i = 0; i <= nLie; i++) {
            liebre[i].stop();
        }
        for (int i = 0; i <= nTor; i++) {
            tortuga[i].stop();

        }
//        
        System.out.println("Fin carrera");

    }
}
