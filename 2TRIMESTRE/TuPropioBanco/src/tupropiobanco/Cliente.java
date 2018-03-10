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
public class Cliente extends Thread {

    private int numero_cliente;
    private int numero_cuenta_corriente;
    private final CuentaCorriente cuenta;
    boolean finalizar = false;

    /**
     * Constructor del método cliente
     *
     * @param numero_cliente es la id del número de cliente
     * @param numero_cuenta_corriente es el número de cuenta
     * @param cuenta
     */
    public Cliente(int numero_cliente, int numero_cuenta_corriente, CuentaCorriente cuenta) {
        this.numero_cliente = numero_cliente;
        this.numero_cuenta_corriente = numero_cuenta_corriente;
        this.cuenta = cuenta;
        try {
            cuenta.imprimeSaldoInicio(numero_cliente, numero_cuenta_corriente);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que devuelve el número de Cliente
     *
     * @return devuelve número de cliente
     */
    public int numeroCliente() {
        return numero_cliente;
    }

    /**
     * Método que imprime el saldo de la cuenta
     *
     * @return devuelve saldo
     */
    public int verMisaldo() {
        return numero_cuenta_corriente;
    }

    /**
     * Metodo que da fin al proceso cliente
     */
    public void finalizar() {
        finalizar = true;
    }

    @Override
    public void run() {

        while (finalizar == false) { // fin de programa

            //Meter acciones que realizaran los clientes (aleatoriamente)
            int aleatorio = (int) (Math.random() * 4);

            switch (aleatorio) {
                case 0: {
                    try {
                        cuenta.imprimeSaldo(numero_cliente);
                    } catch (IOException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 1:
                    cuenta.ingresarSaldo(numero_cliente, Math.random() * 500);
                case 2:
                    cuenta.retirarSaldo(numero_cliente, Math.random() * 500);
                case 3: {
                    boolean c_azar = true;
                    int azar = 0;
                    while (c_azar == true) {
                        azar = (int) (Math.random() * 4);
                        if (azar != numero_cuenta_corriente) {
                            c_azar = false;
                        }
                    }
                    cuenta.transferenciaSaldo(numero_cliente, azar, Math.random() * 500);
                }
            }
        }
    }
}
