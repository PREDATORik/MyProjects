package HomeworkWeek4.MyChat;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class OutputContainer {

    private List<OutputStream> list = new LinkedList<OutputStream>();

    public void add(OutputStream o) {
        list.add(o);
    }

    public void push(String message) {

        for (OutputStream o : list) {
            try {
                DataOutputStream dos = new DataOutputStream(o);
                dos.writeUTF(message);
                dos.flush();

            /*   ObjectOutputStream oos = new ObjectOutputStream(o);
                oos.writeObject(message);
                oos.flush();*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
