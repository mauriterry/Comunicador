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

/**
 *
 * @author Maru
 */
public class Protocolo extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Protocolo() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startProtocolo()//Método para iniciar el servidor
    {
        try{ 
            System.out.println("Esperando..."); //Esperando conexión

            client = server.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");
            
            reader = new BufferedReader (new InputStreamReader (client.getInputStream()));
            writer = new PrintWriter (new OutputStreamWriter (client.getOutputStream()), true);
            
            while (true) {
                try {
                    // leemos del canal de entrada la petición del cliente
                    clientRequest = reader.readLine();

                    // Sacamos por pantalla la peticion del cliente
                    System.out.println ("Recibido :" + clientRequest);
                    
                     // El protocolo de nuestro servidor solo acepta ordenes : HELP, QUIT,NAME,DATE
                    if (clientRequest.startsWith ("OPONENTE")){
                        System.out.println ("YO SOY EL OPONENTE");
                        server.close();
                        Servidor cli = new Servidor(); //Se crea el servidor
                        System.out.println("Iniciando servidor\n");
                        cli.startServer();//Se inicia el servidor
                    } else {
                        if (clientRequest.startsWith ("RETADOR")){
                            System.out.println ("YO SOY EL RETADOR");
                            server.close();
                            Cliente cli = new Cliente(); //Se crea el cliente
                            System.out.println("Iniciando cliente\n");
                            cli.startClient(); //Se inicia el cliente
                        }else{
                            writer.println ("ERROR: Comando :'" + clientRequest +"' no reconocido, use HELP");
                        }
                    }
                }catch (IOException e) {
                    System.out.println ("Excepción en el servidor " + e);
                    System.exit(0);
                }
            }
         }
        catch (Exception e){}
    }
    
    public static void main(String[] args) throws IOException{  
        Protocolo cli = new Protocolo(); //Se crea el servidor
        
        System.out.println("Iniciando servidor\n");
        cli.startProtocolo(); //Se inicia el servidor
        
    }
}
