package dk.hungarian;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Bog: Avanceret Java
 * Kapitel # - Netværk - Multitråds Server - Server.java
 * @author Sonny Sandberg
 */
public class ThreadedServer
{
    public static void main(String[] args)
    {
        // ServerSocket oprettes og port 8001 angives som den der skal lyttes på
        ServerSocket ss;
        try
        {
            ss = new ServerSocket(8001);

            System.out.println("Server kører...");
            while(true)
            {
                // Så længe der ikke er oprettet en forbindelse, venter serveren her
                // Så snart der anmodes om en forbindelse accepteres den med accept()
                Socket s = ss.accept();
                /*
                Den nye forbindelse sendes til vores ClientConnection object,
                hvor al logik for serveren bliver håndteret.
                Der oprettes en ny tråd, som modtager ClientConnection objektet
                og tråden startes.
                */
                Runnable r = new ClientConnection(s);
                Thread t = new Thread(r);
                t.start();

            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
