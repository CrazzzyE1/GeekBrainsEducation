package company.lesson7;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CommandController {
    private String[] tmp;
    private String oldName;
    ConcurrentLinkedDeque<ClientHandler> clTmp;

    public String giveAnswer(String clientMessage, ClientHandler clientHandler, EchoServer server) throws IOException {
        tmp = clientMessage.split(" ");
        oldName = clientHandler.getUserName();
        String command = tmp[0];
        clientMessage = clientMessage.substring(command.length()).trim();
        switch (command) {
            case "/loginuser": {
                clientHandler.changeName(clientMessage);
                clientMessage = "--- " + clientMessage + " --- Joined to Chat! \n";
                break;
            }
            case "/changename": {
                clientHandler.changeName(clientMessage);
                clientMessage = "*** " + oldName + " - change name to " + clientMessage + "*** \n";
                break;
            }
            case "/private": {
                String nameTo = tmp[1].trim();
                clientMessage = clientMessage.substring(nameTo.length());
                clTmp = server.getClients();
                for (ClientHandler client : clTmp) {
                    if (client.getUserName().equals(nameTo) || client.getUserName().equals(clientHandler.getUserName())) {
                        client.sendMessage("PRIVAT MESSAGE!!! FROM " + clientHandler.getUserName() + ": " + clientMessage + "\n");
                    }
                }
                break;
            }
            case "/online": {
                clTmp = server.getClients();
                StringBuilder online = new StringBuilder();
                online.append("NOW ONLINE: \n");
                for (ClientHandler client : clTmp) {
                    online.append(client.getUserName() + "\n");
                }
                for (ClientHandler client : clTmp) {
                    if (client.getUserName().equals(clientHandler.getUserName())) {
                        client.sendMessage(online + "\n");
                    }

                }
                break;
            }
            default: {
                clTmp = server.getClients();
                for (ClientHandler client : clTmp) {
                    if (client.getUserName().equals(clientHandler.getUserName())) {
                        client.sendMessage("All commands:\n /changename .. - change your name \n/private .. - privat message" +
                                "\n/online .. - Who is online\n");
                    }

                }
                break;
            }
        }
        return clientMessage;
    }


}
