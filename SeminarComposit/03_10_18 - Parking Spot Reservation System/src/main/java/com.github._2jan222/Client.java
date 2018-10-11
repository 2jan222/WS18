package com.github._2jan222;

import org.jetbrains.annotations.Contract;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

/**
 * @author Janik Mayr on 10.10.2018
 */
public class Client {
    Socket socket;
    public void connect(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<ParkingSpot> getSpotList() {
        return (LinkedList<ParkingSpot>) send(new Protocol(Protocol.ProtocolType.GET_LIST, null)).getData();
    }

    public boolean reserve(long spotID) {
        return (Boolean) send(new Protocol(Protocol.ProtocolType.PUT_RESERVATION, spotID)).getData();
    }

    public Protocol send(Protocol protocol) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(protocol);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            return (Protocol) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Stream Exception");
    }

    @Contract("null -> fail")
    public void nullityCheck(Object notNull) {
        if (notNull == null) {
            throw new RuntimeException("Null Socket");
        }
    }
}
