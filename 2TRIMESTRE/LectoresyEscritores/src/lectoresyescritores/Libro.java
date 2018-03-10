/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectoresyescritores;

/**
 *
 * @author Ruben
 */
public class Libro {

    String texto;
    char char_aleatorio;
    int escribiendo, leyendo;
    boolean[] escritores = new boolean[10];
    boolean[] lectores = new boolean[20];
    boolean finlibro;

    public Libro() {
        texto = "En un lugar de la Mancha, ";
        finlibro = false;
    }

    public synchronized void escribir(int escritor) throws InterruptedException {
        System.out.println("Escritor " + escritor + " va a probar a escribir");
        // Al ser un método sincronizado, solo un escritor puede escribir
        // Miro si hay lectores leyendo
        
            notifyAll();
            leyendo = 0;
            for (int i = 0; i < 20; i++) {
                if (lectores[i] == true) {
                    leyendo++;
                    wait(); //Si encuentro a un lector, me detengo
                }
            }
        

        if (leyendo == 0) {  //Si nadie esta leyendo...
            //Verifico si está acabado el libro

            if (texto.length() > 150) {
                System.out.println("El libro está completado");
                System.out.println(this.mostrarLibro());
                this.finlibro(); //Detener hilos
            } else {
                // Añado una letra al azar en caso de no estar acabado
                escritores[escritor] = true;
                Thread.sleep(500);
                char_aleatorio = (char) (int) (Math.random() * 25 + 65);
                System.out.println("==>Escritor " + escritor + " escribe una: " + char_aleatorio);
                texto += char_aleatorio;
                escritores[escritor] = false;

            }
        } else {
            System.out.println("Escritor " + escritor + " no puede escribir, ya que hay " + leyendo + " lectores");
        }

    }

    public void leer(int lector) throws InterruptedException {
        System.out.println("Lector " + lector + " va a probar a leer");

        //Verificamos si hay escritores
        escribiendo = 0;
        for (int i = 0; i < 10; i++) {
            if (escritores[i] == true) {
                escribiendo++;
                try {
                    notifyAll(); //Si encuentro un escritor
                } catch (Exception e) {
                    System.out.println("Lector " + lector + " no puede leer (hay escritores escribiendo)");
                }

            }
        }

        if (escribiendo == 0) {        // Si nadie esta escribiendo

            if (lectores[lector] == false) {
                lectores[lector] = true;
                System.out.println("==>Lector " + lector + " está leyendo");
                lectores[lector] = true;

                Thread.sleep(450); // Está 0.5 segundos leyendo

                lectores[lector] = false;

            }
        }

    }

    public String mostrarLibro() {
        return texto;
    }

    public void finlibro() {
        // Método para parar escritores y lectores
        finlibro = true;

    }
}
