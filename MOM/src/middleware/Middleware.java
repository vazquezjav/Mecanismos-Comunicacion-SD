package middleware;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Middleware implements Runnable {

	@Override
	public void run() {

		System.out.println("Middleware activo");
		try {

			ServerSocket cola = new ServerSocket(9991);
			Hashtable<String, Integer> datos = new Hashtable<>();
			while (true) {
				Socket misocket = cola.accept();
				DataInputStream flujoentrada = new DataInputStream(misocket.getInputStream());
				String mensaje = flujoentrada.readUTF();

				
				datos.put(mensaje, 0);
				System.out.println(datos.toString());
				envioserver(datos);
				misocket.close();

			}
		} catch (IOException ex) {
			Logger.getLogger(Middleware.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void envioserver(Hashtable<String, Integer> cola) {
		try {
			try (
					// Conexion al server
					Socket socket = new Socket("192.168.2.243", 9990)) {
				DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
				//
				// Mensaje se envia al server
				flujoSalida.writeUTF(cola.toString());
				flujoSalida.close();
			}
		} catch (Exception e) {
			envioserver(cola);
		}
	}

}
