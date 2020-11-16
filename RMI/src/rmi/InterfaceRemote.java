/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author javier
 */
public interface InterfaceRemote extends Remote {
    
    
    // INTERFAZ REMOTA
    public String ejemplo(String input) throws RemoteException;
    public int suma(int a, int b) throws RemoteException;
    public String validarCedula(String cedula) throws RemoteException;
}
