/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubbyhole;

/**
 *
 * @author ruben
 */
class CubbyHole {

    private int contents;
    private boolean tictac = false;

    public synchronized int mueveL() {
        while (tictac == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        tictac = false;
        notify();
        return contents;
    }

    public synchronized void mueveT(int value) {
        while (tictac == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        contents = value;
        tictac = true;
        notify();
    }
}
