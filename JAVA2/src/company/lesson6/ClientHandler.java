package company.lesson6;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable, Closeable {
    DataInputStream is;
    DataOutputStream os;
    Socket socket;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            os.writeUTF("Welcome to Chat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                String clientMessage = is.readUTF();
                System.out.println("Client:" + clientMessage);
                os.writeUTF("Client:" + clientMessage);
                os.flush();
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
