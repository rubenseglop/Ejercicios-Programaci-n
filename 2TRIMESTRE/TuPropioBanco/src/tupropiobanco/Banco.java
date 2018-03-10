/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupropiobanco;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruben
 */
public class Banco {

    public Banco() {
        Ficheros fichero = new Ficheros();
        // elimino archivo de contabilidad y lo genero de cero
        fichero.eliminaArchivo(); 
        fichero.crearArchivo();
        
        //tenemos 8 clientes y 5 cuentas
        Cliente[] cliente = new Cliente[8]; 
        CuentaCorriente[] cuenta = new CuentaCorriente[5];
        
        // inicio las cuentas con dinero al azar entre 3.000 y 10.000
        for (int i = 0; i < cuenta.length; i++) {
            cuenta[i] = new CuentaCorriente(Math.random() * 7000 + 3000); 
        }
        
        // inicio los clientes con sus cuentas
        cliente[0] = new Cliente(0, 0, cuenta[0]);
        cliente[1] = new Cliente(1, 0, cuenta[0]);
        cliente[2] = new Cliente(2, 1, cuenta[1]);
        cliente[3] = new Cliente(3, 1, cuenta[1]);
        cliente[4] = new Cliente(4, 2, cuenta[2]);
        cliente[5] = new Cliente(5, 3, cuenta[3]);
        cliente[6] = new Cliente(6, 4, cuenta[4]);
        cliente[7] = new Cliente(7, 4, cuenta[4]);

        for (int i = 0; i < cuenta.length; i++) {
            cliente[i].start();
//            try {
//                cliente[i].join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }
        for (int i = 0; i < 6; i++) { //emulacion de tiempo (6 meses)
            for (int j = 0; j < 31; j++) { //emulacion de tiempo (31 dias/mes aprox.)
                fichero.escribeArchivo("==== Mes " + i + " día " + j + "====");
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (CuentaCorriente cuenta1 : cuenta) {
                // aplico depositos/intereses al mes
                cuenta1.depositos();
                cuenta1.intereses();
            }
        }
        for (Cliente cliente1 : cliente) {
            //elimino tareas
            cliente1.finalizar();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        fichero.escribeArchivo("===========================================================");

        for (int i = 0; i < cuenta.length; i++) {
            try {
                //imprimo el saldo final de cada cuenta
                fichero.escribeArchivo("El saldo final de la cuenta " + i + " es de: " + cuenta[i].imprimeSaldoFinal(i));
            } catch (IOException ex) {
                Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Abro bloc de notas con el contenido del archivo de contabilidad.txt
        try {
            Process p = Runtime.getRuntime().exec("notepad contabilidad.txt");
        } catch (Exception e) {
            System.out.println("No encuentro el bloc de notas de Windows");
        }
    }
}
