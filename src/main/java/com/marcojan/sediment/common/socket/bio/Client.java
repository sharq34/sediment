package com.marcojan.sediment.common.socket.bio;

import java.io.*;
import java.net.Socket;

/**
 * Created by Marco on 11/03/2018.
 */
public class Client {

    private static final int PORT = 9876;
    private static final String ADDRESS = "127.0.0.1";

    void connect() throws IOException {
        Socket s = new Socket(ADDRESS, PORT);
        System.out.println("attempting to send request to SocketServer..");

        PrintWriter writer = new PrintWriter(s.getOutputStream(), true);
        writer.println("via bio send socket request.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(reader.readLine());

    }

    public static void main(String[] args) throws IOException {
        new Client().connect();
    }
}
