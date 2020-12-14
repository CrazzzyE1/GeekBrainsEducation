package company.lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedDeque;

public class EchoServer {

    private boolean running;
    private ConcurrentLinkedDeque<ClientHandler> clients = new ConcurrentLinkedDeque<>();

    public ConcurrentLinkedDeque<ClientHandler> getClients() {
        return clients;
    }

    public EchoServer() {
        running = true;
        try(ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started!");
            while (running) {
                System.out.println("Server is waiting connection");
                Socket socket = server.accept();
                System.out.println("Client accepted!");
                ClientHandler handler = new ClientHandler(socket, this);
                clients.add(handler);
                new Thread(handler).start();
                System.out.println("Client info: " + socket.getInetAddress());
            }
        } catch (Exception e) {
            System.out.println("Server crashed");
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void broadCast(String msg) throws IOException {
        for (ClientHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public void kickMe(ClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        new EchoServer();
    }

}
