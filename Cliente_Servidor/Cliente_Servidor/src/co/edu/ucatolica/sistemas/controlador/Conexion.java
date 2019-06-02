/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.sistemas.controlador;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Maru
 */
public class Conexion
{
    private final int PUERTO = 5000; //Puerto para la conexión
    private final String ip = "192.168.56.1"; //Host para la conexión
    protected String mensajeServidor, welcome, response; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket server; //Socket del servidor
    protected Socket client; //Socket del cliente
    protected DataInputStream entradaServidor, entradaCliente; //Flujo de datos de entrada
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida
    protected String clientRequest;
    protected BufferedReader reader;
    protected PrintWriter writer;
    
    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            server = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 5000
            client = new Socket(); //Socket para el cliente
        }
        else
        {
            client = new Socket(ip, PUERTO); //Socket para el cliente en localhost en puerto 5000
        }
    }
}