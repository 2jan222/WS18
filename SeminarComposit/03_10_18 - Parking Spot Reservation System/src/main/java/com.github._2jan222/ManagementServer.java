package com.github._2jan222;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ManagementServer {
    private LinkedList<Socket> sockets = new LinkedList<Socket>();
    public ManagementServer() {

    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket accept = serverSocket.accept();
            sockets.add(accept);
            //TODO CALL THREADCLass
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}