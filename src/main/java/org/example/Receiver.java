package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Receiver implements Player {
    private BufferedReader input;
    private PrintWriter output;
    static int counter = 0;
    public Receiver(Socket socket) throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
    }
    @Override
    public void sendMessage(String msg) {
        output.println(msg);
    }

    @Override
    public void receiveMessage() throws IOException {
        String rcvMsg = input.readLine();
        System.out.println("Receiver received the msg : " + rcvMsg);
        String rmsg  = String.valueOf(++counter) + " " + rcvMsg;
        sendMessage(rmsg);
    }
}
