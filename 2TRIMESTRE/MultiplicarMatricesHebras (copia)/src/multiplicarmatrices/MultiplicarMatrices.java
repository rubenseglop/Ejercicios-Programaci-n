/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicarmatrices;



/**
 *
 * @author ruben
 */
public class MultiplicarMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] Resultado;
        int x1 = 1000;
        int y1 = 1000;
        int x2 = 1000;
        int y2 = 1000;
        Matriz mimatriz = new Matriz(x1, y1, x2, y2);
        mimatriz.setValoresAuto(x1, y1, x2, y2);

// Mostrar matrices
        mimatriz.mostrarMatriz();

// multiplicar arrays
        Resultado = new int[x1][y2];

        if (y1 == x2) {

            FilasHebras[] filas = new FilasHebras[x1];
            int bucle_de_hebras = 0;
            for (int i = 0; i < x1; i++) {

                filas[i] = new FilasHebras(y1, y2, Resultado, mimatriz, i); //le envio los datos a cada hebra "filas[i]"
                filas[i].start();
                
                while (bucle_de_hebras == 0) { // con todos los hilos iniciados, comparador para ver cuando finalizan
                    int contadorhebras = 0;
                    for (int j = 0; j < x1; j++) {    //miro si estan acabados los hilos de procesar, uno a uno
                        if (filas[i].isAlive() == false) {
                            contadorhebras++;        //sumo hilos acabados

                        }
                        if (contadorhebras == x1) {
                            bucle_de_hebras++;  // ¿acabaron todos los hilos? salgo del bucle y continúo ejecución
                        }
                    }
                }
            }
        } else {
            System.out.println("Rangos incorrectos");

        }
        System.out.println("Matriz resultado");
        for (int i = 0; i < x1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y2; j++) {
                System.out.print(Resultado[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }
}
