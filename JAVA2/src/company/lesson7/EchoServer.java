package company.lesson7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
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
                new Thread(handler).start();
            }
        } catch (Exception e) {
            System.out.println("Server crashed");
        }
    }

    public void addUser(ClientHandler handler){
        clients.add(handler);
    }

    public void broadCast(String msg) throws IOException {
        if (msg.equals("")) return;
        System.out.println("Я сервер и я реально броткастю: " + msg);
        for (ClientHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public void kickMe(ClientHandler client) {
        System.out.println("Я сервер - я кикнул: " + client.getUserName());
        clients.remove(client);
    }

    public static void main(String[] args){
        new EchoServer();
    }

}
