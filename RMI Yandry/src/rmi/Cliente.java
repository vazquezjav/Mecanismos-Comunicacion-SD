/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author yandr
 */
public class Cliente {
    
    public static void main (String [] args){
        Scanner sc  = new Scanner (System.in);
        
        try {
            Registry miRegistro = LocateRegistry.getRegistry("localhost",1099);
            Calculadora c = (Calculadora)Naming.lookup("//localhost/Calculadora");
        
        while(true){
            String menu = JOptionPane.showInputDialog("Ejercicio calculadora  \n"+"Division ...........(1) /n Mensaje ............(2)");
            switch(menu){
                case "1":{
                    int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                    int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                    JOptionPane.showMessageDialog(null, "La division es: "+ c.div(x, y));
                    break;
                }
                case "2":{
                    String x =(JOptionPane.showInputDialog("Ingrese el mensaje"));
                    JOptionPane.showMessageDialog(null, "El mensaje es: "+ c.mensaje(x));
                    break;
                }
            }
        }
        }catch (Exception e){
            JOptionPane.showInputDialog("Servidor no conectado"+e);
        }
        
    }
    
}
