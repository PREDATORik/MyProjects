package HomeworkWeek4.MyChat;

import java.io.*;

public class ClientThreads implements Runnable {

    private InputStream input;
    private OutputContainer oc;

    ClientThreads(InputStream input, OutputContainer oc) {
        this.input = input;
        this.oc = oc;
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = new DataInputStream(input);
        while (true) {
            String str = null;
            try {
                str = dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            oc.push(str);
        }
    }
}
