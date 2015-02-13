package HomeworkWeek4.MyChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    public synchronized void run() {

        try {
            OutputContainer oc = new OutputContainer();
            ServerSocket server = new ServerSocket(1002);

            while (true) {
                Socket socket = server.accept();
                oc.add(socket.getOutputStream());

                ClientThreads ct = new ClientThreads(socket.getInputStream(), oc);
                Thread td = new Thread(ct);
                td.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}