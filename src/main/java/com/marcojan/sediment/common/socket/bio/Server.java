package com.marcojan.sediment.common.socket.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Marco on 11/03/2018.
 */

public class Server {

    private final static int PORT = 9876;
    private final static String ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        new Server().startServer();
    }

    void startServer() {
        try {
            ServerSocket ss = new ServerSocket(PORT);

            System.out.println("SocketServer start...");
            Socket socket = ss.accept();

            ExecutorService pool = Executors.newCachedThreadPool();

            pool.submit(()->{
                System.out.println("start thread to process request..");
                PrintWriter writer = null;
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println(reader.readLine());

                    writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("sent response");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

