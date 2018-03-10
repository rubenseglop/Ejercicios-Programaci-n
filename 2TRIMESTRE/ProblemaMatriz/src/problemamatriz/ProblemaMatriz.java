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
public class ProblemaMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObjetoMatriz miobjeto1 = new ObjetoMatriz(3,3);
        ObjetoMatriz miobjeto2 = new ObjetoMatriz(3,3);
        
        miobjeto1.imprimeMatriz();
        miobjeto2.imprimeMatriz();
    }
    
}
