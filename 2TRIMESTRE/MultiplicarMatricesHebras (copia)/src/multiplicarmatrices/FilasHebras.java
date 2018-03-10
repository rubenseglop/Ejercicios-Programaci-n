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
public class FilasHebras extends Thread {

    int y1, y2;
    int[][] Resultado;
    Matriz mimatriz;
    int i;

    public FilasHebras(int y1, int y2, int[][] Resultado, Matriz mimatriz, int i) {
        this.y1 = y1;
        this.y2 = y2;
        this.mimatriz = mimatriz;
        this.Resultado = Resultado;
        this.i = i;

    }

    @Override
    public void run() {

        for (int j = 0; j < y2; j++) {

            for (int h = 0; h < y1; h++) {

                Resultado[i][j] += mimatriz.matriz1()[i][h] * mimatriz.matriz2()[h][j];
            }
        }
    }
}
