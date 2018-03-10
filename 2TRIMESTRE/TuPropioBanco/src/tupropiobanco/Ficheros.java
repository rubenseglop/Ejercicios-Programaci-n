/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupropiobanco;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruben
 */
public class Ficheros {

    File fichero;
    BufferedWriter bw;
    FileWriter fw;

    public Ficheros() {
        this.fw = null;
        this.bw = null;
        fichero = new File("contabilidad.txt");
        // Si el archivo no existe, se crea!

    }

    public void escribeArchivo(String contenido) {
        FileWriter TextOut = null;
        try {

            TextOut = new FileWriter(fichero, true);
            TextOut.write(contenido);
            TextOut.write(13);TextOut.write(10);
            TextOut.close();
        } catch (IOException ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                TextOut.close();
            } catch (IOException ex) {
                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void crearArchivo() {
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
                fw = new FileWriter(fichero.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                System.out.println("El archivo contabilidad.txt fue creado.");
            } catch (IOException ex) {
                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void eliminaArchivo() {
        if (!fichero.exists()) {
            System.out.println("El archivo contabilidad.txt no existe.");
        } else {
            fichero.delete();
            System.out.println("El archivo contabilidad.txt fue eliminado.");
        }
    }
}
