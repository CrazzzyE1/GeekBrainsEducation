package company.lesson7;

import javafx.scene.control.TextArea;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client implements Closeable {

    private static Client instance;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private byte[] buffer;
    private int bytesRead;
    private boolean flag;
    Thread readThread;

    public static Client getInstance() throws IOException {
        if (instance == null) {
            instance = new Client();
        }
        return instance;
    }

    private Client() throws IOException {
        this.socket = new Socket("localhost", 8189);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.buffer = new byte[256];
        this.flag = true;

    }

    public void write(String msg) {

        try {
            out.write(msg.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isAuthSuccess() throws IOException {
        System.out.println("Внутри авторизации на клиенте");
        bytesRead = in.read(buffer);
        System.out.println("Внутри авторизации на клиенте");
        String msg = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
        System.out.println("Ответ от сервера при авторизации: " + msg);
        return msg.equals("/success");
    }

    public void readThreadStop(){
        flag = false;
        System.out.println("TreadStop Flag = false");
    }
    public void readThreadStart(){
        flag = true;
        System.out.println("ThreadStart");
        readThread.start();
    }

    public void read(TextArea output) throws IOException {
        System.out.println(flag);
        readThread = new Thread(() -> {
            while (flag) {
                System.out.println("Я есть поток чтения");
                try {
                    bytesRead = in.read(buffer);
                    String msg = new String(buffer, 0, bytesRead, StandardCharsets.UTF_8);
                    System.out.println("Поток на клиенте вход сообщение: " + msg);
                    output.appendText(msg);
                } catch (IOException e) {
                    System.out.println("User leave!");
                }
            }
        });
    }

    @Override
    public void close() throws IOException {
        flag = false;
        in.close();
        out.close();
    }
}


