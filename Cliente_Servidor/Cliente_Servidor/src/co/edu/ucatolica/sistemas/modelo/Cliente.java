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
public class Cliente extends Conexion 
{
    
    public Cliente() throws IOException{
        super("cliente");
    } //Se usa el constructor para cliente de Conexion
    
    public static void pausa(){
        try {
        Thread.sleep(3000);
        } catch (Exception ignored) {}
    }
    private String res, res1, num;
    public void startClient() //Método para iniciar el cliente
    {
        try{
            //creamos los canales de entrada/salida para comunicarnos con el servidor
            reader = new BufferedReader (new InputStreamReader (client.getInputStream()));
            writer = new PrintWriter (new OutputStreamWriter (client.getOutputStream()), true);
            //leemos la bienvenida que nos da el servidor
            welcome = reader.readLine();
            pausa();
            System.out.println ("Mensaje procedente del servidor: '"+ welcome +"'");
            //para ver el funcionamiento, enviamos los comandos
            System.out.println ("Enviando numero al azar del 2 al 6");
            num = Integer.toString((int) (Math.random()*5+2));
            writer.println(num);
            System.out.println ("Numero al azar enviado: '"+ num +"'");
            response = reader.readLine();
            System.out.println ("Respuesta del servidor: '"+ response +"'");
            this.res = response;
            Num_prim a = new Num_prim(Integer.parseInt(num));
            this.res1 = a.getResultado();
            System.out.println ("Cliente en tiempo de ejecucion: '"+ res1 +"'");
            //pausa
            pausa();

            System.out.println ("Enviando Ganador");
            if(res1.compareTo(res) < 0){
               writer.println("RETADOR");
            }else{
               writer.println("OPONENTE");
            }
            
            response = reader.readLine();
            System.out.println ("Respuesta del servidor: '"+ response +"'");
            pausa();

            System.out.println ("Enviando comando QUIT");
            writer.println("QUIT");
            
        } catch (IOException e) {
        System.out.println ("IOException en client.in.readln()");
        System.out.println(e);
        }
    
        try {
            Thread.sleep(2000);
        } catch (Exception ignored) {}
    }
}
    
