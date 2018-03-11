/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicarmatrices;

/**
 * Método para calcular la multiplicacion fila a fila
 * @author ruben
 */
public class FilasHebras extends Thread {

    int inicio, fin;
    int[][] Resultado;
    Matriz mimatriz;
    int i;

    /**
     * Constructor de las filas
     * @param Resultado introduzco la matriz resultado para guardar posteriormente los datos
     * @param mimatriz introduzco las dos matrices
     * @param inicio introduzco el rango de inicio de las filas a calcular
     * @param fin introduzco el final del rango de las filas calcular
     */
    public FilasHebras(int[][] Resultado, Matriz mimatriz, int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
        this.mimatriz = mimatriz;
        this.Resultado = Resultado;
        this.i = i;

    }

    /**
     * Metodo run de la clase Thread sobreescrito
     * Multiplico la matriz 1 con la 2 en el rango especificado
     */
    @Override
    public void run() {

        if (mimatriz.devolvery1() == mimatriz.devolverx2()) {
            for (int i = inicio; i < fin; i++) {

                for (int j = 0; j < mimatriz.devolvery2(); j++) {
                    for (int h = 0; h < mimatriz.devolvery1(); h++) {
                        Resultado[i][j] += mimatriz.matriz1()[i][h] * mimatriz.matriz2()[h][j];

                    }
                }
            }
        }
    }
}
