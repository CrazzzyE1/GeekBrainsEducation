package company.lesson7;

import javafx.scene.control.TextArea;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client implements Closeable {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    byte[] buffer;
    int bytesRead;

    public Client() throws IOException {
        this.socket = new Socket("localhost", 8189);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.buffer = new byte[256];
    }


    public void write(String msg) {
        Thread writeThread = new Thread(() -> {
            try {
                out.write(msg.getBytes(StandardCharsets.UTF_8));
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        writeThread.start();
    }

    public void read(TextArea output) throws IOException {
        Thread readThread = new Thread(() -> {
            while (true) {
                try {
                    bytesRead = in.read(buffer);
                    String msg = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    output.appendText(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        readThread.start();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }
}


