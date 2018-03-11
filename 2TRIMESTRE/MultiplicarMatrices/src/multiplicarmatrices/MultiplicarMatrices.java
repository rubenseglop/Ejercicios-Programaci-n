/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicarmatrices;

import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class MultiplicarMatrices {

    /**
     * Clase main que inicia la ejecución del programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] Resultado;
        long startTime = 0;

        Scanner sc = new Scanner(System.in);
//Introducir los parámetros de la matriz 1 y 2
        System.out.println("Tamaño de matriz 1 (eje x, eje y)");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println("Tamaño de matriz 2 (eje x, eje y)");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        Matriz mimatriz = new Matriz(x1, y1, x2, y2);
        mimatriz.setValoresAuto(x1, y1, x2, y2);

// Mostrar matrices
        startTime = System.currentTimeMillis();
        mimatriz.mostrarMatriz();

// multiplicar arrays
        x1 = mimatriz.devolverx1();
        y1 = mimatriz.devolvery1();
        x2 = mimatriz.devolverx2();
        y2 = mimatriz.devolvery2();
        Resultado = new int[x1][y2];

        if (y1 == x2) { // si están en el mismo rango, entonces...
            System.out.println("La matriz resultante es: ");
            // Cáculo de la multiplicación de las dos matrices
            for (int i = 0; i < x1; i++) {
                System.out.print("[ ");
                for (int j = 0; j < y2; j++) {

                    for (int h = 0; h < y1; h++) {
                        Resultado[i][j] += mimatriz.matriz1()[i][h] * mimatriz.matriz2()[h][j];
                    }
                    System.out.print(Resultado[i][j] + " ");
                }
                //Resultado de la multiplicación
                System.out.print("]\n");

            }
            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("\nTiempo en milisegundos " + endTime);
        } else { // devuelvo error
            System.out.println("Rangos incorrectos, imposible multiplicar");
        }
    }
}
