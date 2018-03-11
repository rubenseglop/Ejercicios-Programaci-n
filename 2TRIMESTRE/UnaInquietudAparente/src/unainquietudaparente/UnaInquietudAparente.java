/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unainquietudaparente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Ruben
 */
public class UnaInquietudAparente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Fichero del que queremos leer
        File fichero = new File("ciudades.txt");
        Scanner s = null;
        // Al desconocer el número de líneas a almacenar en un array, usamos ArrayList y asi no desbordaremos la capacidad
        ArrayList<String> ciudades = new ArrayList<>();
        
        try {
            // Leemos el contenido del fichero

            s = new Scanner(fichero);
            
            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                String linea = s.nextLine(); 	// Guardamos la linea en un String                
                ciudades.addAll(Arrays.asList(linea.split(" ")));                
                Collections.sort(ciudades); // Método sort para ordenar alfabéticamente

                // Ordenamos por tamaño de caracteres 
                int[] ordenados= new int[ciudades.size()];
                int[] indice= new int[ciudades.size()];
                
                for (int i = 0; i < ciudades.size(); i++) {
                    ordenados[i]= ciudades.get(i).length();
                    indice[i]=i;                   
                }
                // Bucle que ordena por método de burbuja el índice
                int i, j, aux1,aux2;
                for (i = 0; i < ordenados.length - 1; i++) {
                    for (j = 0; j < ordenados.length - i - 1; j++) {
                        if (ordenados[j + 1]  < ordenados[j]) {
                            aux1 = ordenados[j + 1];
                            ordenados[j + 1] = ordenados[j];
                            aux2= indice[j+1];
                            indice[j+1] = indice[j];
                           
                            ordenados[j]= aux1;
                            indice[j]=aux2;
                        }
                    }
                }
                // imprimimos
                for (int k = 0; k < ordenados.length; k++) {
                    System.out.println(ciudades.get(indice[k]));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.err.println("Error: " + ex2.getMessage());
            }
        }
    }
}
