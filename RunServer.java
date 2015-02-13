package HomeworkWeek4.MyChat;

public class RunServer {

    public static void main(String[] args) {
        Runnable server = new Server();
        Thread td = new Thread(server);
        td.start();
    }
}
