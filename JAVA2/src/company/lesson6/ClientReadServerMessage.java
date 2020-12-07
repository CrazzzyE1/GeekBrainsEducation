package company.lesson6;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReadServerMessage implements Runnable, Closeable {
    Socket socket;
    DataInputStream is;

    public ClientReadServerMessage(Socket socket) throws IOException {
        this.socket = socket;
        is = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                String serverMassage;
                serverMassage = is.readUTF();
                System.out.println(serverMassage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() throws IOException {
        is.close();
    }
}
