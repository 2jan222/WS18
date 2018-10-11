package com.github._2jan222;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ManagementServer implements Runnable {
    private LinkedList<Socket> sockets = new LinkedList<Socket>();
    private LinkedList<ParkingSpot> parkingSpots = new LinkedList<ParkingSpot>();

    public ManagementServer() {

    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket accept = serverSocket.accept();
            sockets.add(accept);
            ObjectInputStream inputStream = new ObjectInputStream(accept.getInputStream());
            inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Protocol respond(Protocol protocol) {
        switch (protocol.getType()) {
            case FREE: return new Protocol(Protocol.ProtocolType.FREE, true);
            case GET_LIST: return new Protocol(Protocol.ProtocolType.GET_LIST, parkingSpots);
            case PUT_RESERVATION: return reservate((Long)protocol.getData());
            default: return new Protocol(Protocol.ProtocolType.ERROR, "NO RESPONSE");
        }

    }

    public Protocol reservate(long spotID) {
        return new Protocol(Protocol.ProtocolType.PUT_RESERVATION, true);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        while (true) {}
    }
}