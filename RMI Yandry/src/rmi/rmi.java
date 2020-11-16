/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author yandr
 */
public class rmi extends UnicastRemoteObject implements Calculadora{
    public rmi() throws RemoteException{
        int a, b;
    }
    
    public int div (int a, int b ) throws RemoteException{
        return a/b;
    }
    
    public String mensaje (String mensaje) throws RemoteException{
        return mensaje;
    }
}
