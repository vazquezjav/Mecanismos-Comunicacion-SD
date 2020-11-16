package client;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client cl= new Client();
		
		while(1==1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("***Escriba su mensaje***");
			String mensaje = sc.nextLine();
			cl.conexion(mensaje);
		}
	}

}
