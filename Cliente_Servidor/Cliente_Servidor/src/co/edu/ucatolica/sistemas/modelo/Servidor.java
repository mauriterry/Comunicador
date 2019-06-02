/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.sistemas.modelo;

import co.edu.ucatolica.sistemas.controlador.Conexion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author Maru
 */
public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try{ 
            System.out.println("Esperando..."); //Esperando conexión

            client = server.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");
            
            reader = new BufferedReader (new InputStreamReader (client.getInputStream()));
            writer = new PrintWriter (new OutputStreamWriter (client.getOutputStream()), true);

            // En cuanto se establece una conexión por parte del cliente, enviamos un saludo
            writer.println ("Bienvenido al Servidor: " + new Date() + "/n");
        
            while (true) {
                try {
                    // leemos del canal de entrada la petición del cliente
                    clientRequest = reader.readLine();

                    // Sacamos por pantalla la peticion del cliente
                    System.out.println ("Recibido :" + clientRequest);

                    // El protocolo de nuestro servidor solo acepta ordenes : HELP, QUIT,NAME,DATE
                    if (clientRequest.startsWith("OPONENTE")){
                        writer.println("Ha Ganado el Oponente");
                        System.out.println("Ha Ganado el Oponente");
                    } else {
                        if (clientRequest.startsWith ("QUIT")) {
                            System.exit(0);
                        }else {
                            if (clientRequest.startsWith("RETADOR")){
                                writer.println("Ha Ganado el Retador");
                                System.out.println("Ha Ganado el Retador");
                            }else {
                                if (clientRequest.startsWith("2")){
                                    Num_prim a = new Num_prim(Integer.parseInt(clientRequest));
                                    System.out.println(a.getResultado());
                                    writer.println (a.getResultado());
                                }else{
                                    if (clientRequest.startsWith("3")){
                                        Num_prim a = new Num_prim(Integer.parseInt(clientRequest));
                                        System.out.println(a.getResultado());
                                        writer.println (a.getResultado());
                                    }else{
                                        if (clientRequest.startsWith("4")){
                                            Num_prim a = new Num_prim(Integer.parseInt(clientRequest));
                                            System.out.println(a.getResultado());
                                            writer.println (a.getResultado());
                                        }else{
                                            if (clientRequest.startsWith("5")){
                                                Num_prim a = new Num_prim(Integer.parseInt(clientRequest));
                                                System.out.println(a.getResultado());
                                                writer.println (a.getResultado());
                                            }else{
                                                if (clientRequest.startsWith("6")){
                                                    Num_prim a = new Num_prim(Integer.parseInt(clientRequest));
                                                    System.out.println(a.getResultado());
                                                    writer.println (a.getResultado());
                                                }else{
                                                    writer.println ("ERROR: Comando :'" + clientRequest +"' no reconocido, use HELP");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println ("Excepción en el servidor " + e);
                    System.exit(0);
                }
            }
        }
        catch (Exception e){}
    }
}
