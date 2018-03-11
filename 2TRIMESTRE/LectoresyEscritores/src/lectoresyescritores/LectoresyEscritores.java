/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectoresyescritores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruben
 */
public class LectoresyEscritores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Libro milibro=new Libro();
        Escritor[] escritor = new Escritor[10];
        
        
        Lector[] lector = new Lector[20];

        for (int i = 0; i < lector.length; i++) {
            lector[i] = new Lector(i,milibro);
            lector[i].start();
        }
        
        for (int i = 0; i < escritor.length; i++) {
            escritor[i] = new Escritor(i,milibro);
            escritor[i].start();
        }
    }
}
