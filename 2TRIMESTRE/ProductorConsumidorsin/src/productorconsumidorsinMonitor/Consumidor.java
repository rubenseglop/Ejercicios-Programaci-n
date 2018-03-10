/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidorsinMonitor;

import static java.lang.Thread.sleep;

/**
 *
 * @author ruben
 */
public class Consumidor extends Thread {

    private CubbyHole cubbyhole;
    private final int numero;

    public Consumidor(CubbyHole c, int numero) {
        cubbyhole = c;
        this.numero = numero;
    }

    @Override
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = cubbyhole.get();
            System.out.println("Consumidor saca:" + value);
            try {
                sleep(numero);
            } catch (InterruptedException e) {
            }
        }
    }
}
