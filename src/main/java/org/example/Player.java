package org.example;

import java.io.IOException;

public interface Player {
    public void sendMessage(String msg);
    public void receiveMessage() throws IOException;
}
