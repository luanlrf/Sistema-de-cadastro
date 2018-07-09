/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testserver;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.net.ServerSocket;

import java.net.Socket;

/**
 *
 * @author Luan
 */
public class testServer {
     public static void main(String args[])    {       

System.out.println("Aguardando conexões");       

try {                     

ServerSocket server = new ServerSocket(3309);                         

 Socket socket= server.accept();             
                ObjectOutputStream x= new ObjectOutputStream(socket.getOutputStream());   

            ObjectInputStream y= new ObjectInputStream(socket.getInputStream());                                

  System.out.println(y.readUTF());                                 

      x.writeUTF("Ok");                                   

    x.flush();               

} catch (Exception ex) {            System.out.println("Erro"+ex);        }    }

    
}
