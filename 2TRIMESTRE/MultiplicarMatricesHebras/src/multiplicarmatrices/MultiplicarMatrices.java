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
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int[][] resultado;
        //El tamaño de las matrices está fijado en 1000 x 1000 para que no tarde mucho
        //La diferencia de tiempo en resolverse (respecto a sin hilos) es mayor cuanto más grande sea su tamaño
        int x1 = 1000;
        int y1 = 1000;
        int x2 = 1000;
        int y2 = 1000;
        Matriz mimatriz = new Matriz(x1, y1, x2, y2);
        mimatriz.setValoresAuto(x1, y1, x2, y2);
        long startTime;

// Mostrar matrices
        startTime = System.currentTimeMillis();
        mimatriz.mostrarMatriz();

// multiplicar arrays en 4 fracciones (0,251, 501 y 751)
        resultado = new int[x1][y2];
        FilasHebras hebra1 = new FilasHebras(resultado, mimatriz, 0,250);
        FilasHebras hebra2 = new FilasHebras(resultado, mimatriz, 251, 500);
        FilasHebras hebra3 = new FilasHebras(resultado, mimatriz, 501, 750);
        FilasHebras hebra4 = new FilasHebras(resultado, mimatriz, 751, 1000);

        //1º inicio los hilos y 2º dejo que finalicen completamente
        hebra1.start();
        hebra2.start();
        hebra3.start();
        hebra4.start();
        hebra1.join();
        hebra2.join();
        hebra3.join();
        hebra4.join();

        System.out.println("Matriz resultado");
        
        //Calculado los hilos, imprimo el resultado
        for (int i = 0; i < x1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y2; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.print("]\n");
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("\nTiempo en milisegundos " + endTime);
    }
}
