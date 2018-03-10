/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

/**
 *
 * @author ruben
 */
public class Carrera {

    public Carrera(){
       
    
}
    private int contents;
    private boolean available = false;

    public synchronized int turnoL(int casillasAMover) {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        //Muevo mi Liebre
       
        
        available = false;
        notify();
        return contents;
    }

    public synchronized void turnoT(int casillasAMover) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        //Muevo mi tortuga
        contents = value;
        available = true;
        notify();
    }
    public void fincarrera(){
      
    }
    
}
