/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemamatriz;

/**
 *
 * @author ruben
 */
public class ObjetoMatriz {

    int x, y;
    int[][] matriz;

    public ObjetoMatriz(int x, int y) {
        this.x=x;
        this.y=y;
        matriz = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public void imprimeMatriz() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.println(matriz[i][j]);
                
            }
        }
    }

}
