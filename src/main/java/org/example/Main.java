package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] command = {"java", "-cp", ".", "Initiator"};
        ProcessBuilder p1 = new ProcessBuilder("java",Initiator.class.getName());
        Process process = p1.start();
        try {
            process.waitFor();
            int exitCode = process.exitValue();
            System.out.println("Process exited with codex: " + exitCode);
        } catch (InterruptedException e ) {
            e.printStackTrace();
        } catch ( IllegalArgumentException e2) {
            System.out.println(e2.toString());
        }
//        ProcessBuilder p2 = new ProcessBuilder("echo","Initiator");

    }
}