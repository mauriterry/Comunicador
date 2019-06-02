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
    public Protocolo() throws IOException{
        super("cliente");
    } //Se usa el constructor para cliente de Conexion
    
    public static void pausa(){
        try {
        Thread.sleep(3000);
        } catch (Exception ignored) {}
    }
    private String res, res1;
    public void startProtocolo() //Método para iniciar el cliente
    {
        try{
            //creamos los canales de entrada/salida para comunicarnos con el servidor
            reader = new BufferedReader (new InputStreamReader (client.getInputStream()));
            writer = new PrintWriter (new OutputStreamWriter (client.getOutputStream()), true);
            //para ver el funcionamiento, enviamos los comandos
            System.out.println ("Enviando el rol que va a tener");
            int a = (int) (Math.random() * 2 + 1);
            if(a==1){
                String num = "OPONENTE";
                writer.println(num);
                System.out.println ("YO SOY EL RETADOR");
                client.close();
                Cliente cli = new Cliente(); //Se crea el cliente
                System.out.println("Iniciando cliente\n");
                cli.startClient(); //Se inicia el cliente
            }else{
                String num = "RETADOR";
                writer.println(num);
                client.close();
                System.out.println ("YO SOY EL OPONENTE");
                Servidor cli = new Servidor(); //Se crea el servidor
                System.out.println("Iniciando servidor\n");
                cli.startServer();//Se inicia el servidor
            }
            
         }catch (Exception e){}
        
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {}
    }
    
    public static void main(String[] args) throws IOException{  
        Protocolo cli = new Protocolo(); //Se crea el cliente
        
        System.out.println("Iniciando cliente\n");
        cli.startProtocolo(); //Se inicia el cliente
        
    }
    
}
