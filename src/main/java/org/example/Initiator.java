package org.example;

import java.io.*;
import java.net.Socket;

public class Initiator implements Player {
    private BufferedReader input;
    private PrintWriter output;
    File file = new File("log.txt");
    public Initiator (Socket socket) throws IOException {
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream());
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);
        System.out.println("initiator");

    }
    @Override
    public void sendMessage(String msg) {
        output.println(msg);
    }
    public void start(){
        System.out.println("started");
    }
    @Override
    public void receiveMessage() throws IOException{
        String rcvMsg  = input.readLine();
        System.out.println("Sender received back msg : "+rcvMsg);
    }
}
