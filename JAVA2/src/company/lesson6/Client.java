package company.lesson6;

import java.io.IOException;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8189);

        new  Thread(new ClientReadServerMessage(socket)).start();
        new  Thread(new ClientOutMessage(socket)).start();

    }
}
