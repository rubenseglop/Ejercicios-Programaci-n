/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tupropiobanco;

import java.io.IOException;

/**
 *
 * @author Ruben
 */
public class CuentaCorriente {

    private double saldoCuenta;
    int id_cuenta;
    Ficheros fichero = new Ficheros();
    String imprimir;

    public CuentaCorriente(double saldoInicio) {

        saldoCuenta = saldoInicio;
    }

    /*Estos clientes podrán, lógicamente, tratar de acceder a su cuenta en cualquier momento, ya
sea para consultar cuánto dinero tienen, hacer un ingreso, retirar efectivo o realizar una
transferencia a otra cuenta. Además, las cuentas podrán tener más de un cliente como titular.*/
    public double imprimeSaldoInicio(int cliente, int numero_cuenta) throws IOException {

        id_cuenta = numero_cuenta;

        imprimir = String.valueOf(Math.round(saldoCuenta * 100d) / 100d);
        fichero.escribeArchivo("El saldo de inicio del cliente " + cliente + " en su cuenta es de: " + imprimir);
        return Math.round(saldoCuenta * 100d) / 100d;
    }

    public double imprimeSaldo(int cliente) throws IOException {

        imprimir = String.valueOf(Math.round(saldoCuenta * 100d) / 100d);
        fichero.escribeArchivo("Cliente " + cliente + " pidió su saldo que es de: " + imprimir);
        return Math.round(saldoCuenta * 100d) / 100d;
    }

    public double imprimeSaldoFinal(int cliente) throws IOException {

        imprimir = String.valueOf(Math.round(saldoCuenta * 100d) / 100d);       
        return Math.round(saldoCuenta * 100d) / 100d;
    }    

    public void ingresarSaldo(int cuenta, double saldo) {
        saldoCuenta += saldo;
        saldo =(Math.round(saldo * 100d) / 100d);
        imprimir = String.valueOf(Math.round(saldoCuenta * 100d) / 100d);
        fichero.escribeArchivo("Se ingresaron " + saldo + " en la cuenta " + cuenta + ". El saldo de la cuenta es de " + imprimir);
    }

    public boolean retirarSaldo(int cliente, double saldo) {
        if (saldoCuenta - saldo > 3000) {  //si hay efectivo (mas de 3000)
            saldoCuenta -= saldo;
            saldo =(Math.round(saldo * 100d) / 100d);
            imprimir = String.valueOf(Math.round(saldoCuenta * 100d) / 100d);
            fichero.escribeArchivo("El cliente " + cliente + " ha retirado " + saldo + " en su cuenta. El saldo de la cuenta es de " + imprimir);
            return true;
        } else {
            saldo =(Math.round(saldo * 100d) / 100d);
            fichero.escribeArchivo("El cliente " + cliente + " intentó retirar " + saldo + " en su cuenta y no pudo. El saldo de la cuenta es de " + imprimir);
            return false;
        }

    }
    public void transferenciaSaldo(int clienteOrigen, int clienteDestino, double saldo) {
        if (this.retirarSaldo(clienteOrigen, saldo) == true) {
            System.out.println("trans");
            this.ingresarSaldo(clienteDestino, saldo);
        }
    }

    public void depositos() {
        //no puedan ser retirados antes de 12 meses de la creación 
        //sume 1.1% por cada mes
       saldoCuenta=saldoCuenta*1.1; 
        System.out.println("dep");
       fichero.escribeArchivo("Hemos aplicado un incremento de 10% en la cuenta " + id_cuenta);

    }

    public void intereses() {
        //cada mes 1.25%
        saldoCuenta=saldoCuenta*1.25;
        System.out.println("int");
        fichero.escribeArchivo("Hemos aplicado un incremento de 25% en la cuenta " + id_cuenta);

    }

}
