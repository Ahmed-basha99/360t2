package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Mediator {
    private ServerSocket serverSocket;
    private Socket senderSocket;
    private Socket receiverSocket;
    private Player initiator;
    private Player receiver;
    public Mediator(int port )throws IOException{
        serverSocket = new ServerSocket(port);
        Connect();
    }
    private void Connect()throws  IOException{
        System.out.println("waiting for connection");
//        senderSocket = serverSocket.accept();
        System.out.println("Sender connected");
//        receiverSocket = serverSocket.accept();
        ProcessBuilder p1 = new ProcessBuilder("java","Initiator");
        p1.inheritIO();
        p1.start();
//        initiator = new Initiator(senderSocket);
//        receiver = new Receiver(receiverSocket);
    }
    public void sendMessages() throws IOException {
        for (int i=0;i<10;i++){
            String msg = "Hey "+ String.valueOf(i+1);
            initiator.sendMessage(msg);
            receiver.receiveMessage();
            initiator.receiveMessage();
        }
    }
}
