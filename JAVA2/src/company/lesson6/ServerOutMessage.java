package company.lesson6;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerOutMessage implements Runnable, Closeable {
    Socket socket;
    DataInputStream is;
    DataOutputStream os;
    Scanner scanner;

    public ServerOutMessage(Socket socket) throws IOException {
        this.socket = socket;
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (scanner.hasNext()) {
            String serverMassage = scanner.nextLine();
            try {
                os.writeUTF("Server: " + serverMassage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws IOException {
        is.close();
        os.close();
    }


}
