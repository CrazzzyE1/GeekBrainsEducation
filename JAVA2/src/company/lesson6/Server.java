package company.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started");

            Socket socket = server.accept();
            System.out.println("Client connected");
            new Thread(new ClientHandler(socket)).start();
            new Thread(new ServerOutMessage(socket)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
