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
public class Matriz {

    private int x1, x2;
    private int y1, y2;
    private final int[][] matriz1;
    private final int[][] matriz2;

    public Matriz(int x1, int y1, int x2, int y2) {
        matriz1 = new int[x1][y1];
        matriz2 = new int[x2][y2];
    }

    public void setValoresAuto(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < y1; j++) {

                matriz1[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < x2; i++) {
            for (int j = 0; j < y2; j++) {

                matriz2[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public void mostrarMatriz() {
        System.out.println("Matriz 1: "+x1+" "+y1);
        for (int i = 0; i < x1; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y1; j++) {
                System.out.print(matriz1[i][j] + " ");
            }
            System.out.print("]\n");
        }

        System.out.println("Matriz 2: "+x2+" "+y2);
        for (int i = 0; i < x2; i++) {
            System.out.print("[ ");
            for (int j = 0; j < y2; j++) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }
    public int devolverx1() {
        return x1;
    }
    public int devolvery1() {
        return y1;
    }
    public int devolverx2() {
        return x2;
    }
    public int devolvery2() {
        return y2;
    }
    public int[][] matriz1(){
        return matriz1;
    }
    public int[][] matriz2(){
        return matriz2;
    }
}