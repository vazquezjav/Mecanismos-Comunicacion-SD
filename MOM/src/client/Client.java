package client;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public  void conexion(String mensaje) {
        try
              {
                  //
                  try ( 
                      Socket socket = new Socket( "192.168.2.243", 9991 ))
                  {
                      DataOutputStream flujoSalida= new DataOutputStream(socket.getOutputStream());
                      
                      //Mensaje envia al server
                      flujoSalida.writeUTF(mensaje);
                      System.out.println("envio exitoso");
                      flujoSalida.close();
              
                     
                  }
              }
              catch( Exception e )
              {
                  System.out.println(e.getMessage());
                  e.printStackTrace();
              }
          }
    
}
