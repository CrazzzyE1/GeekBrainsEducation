package company.lesson7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea output;
    public TextField input;
    public Client client;
    public SplitMenuButton comMenu;
    public MenuItem m1;
    public MenuItem m2;
    public MenuItem m3;


    public void send(ActionEvent actionEvent) {
        if(!input.getText().isEmpty()){
            client.write(input.getText());
            input.clear();
        }
    }

    public void read(TextArea output) throws IOException {
        client.read(output);
    }

    public void change(){
        input.appendText(m1.getText());
    }
    public void change2(){
        input.appendText(m2.getText());
    }

    public void change3() {
        input.appendText(m3.getText());
    }


    public void quit(ActionEvent actionEvent) throws IOException {

        Parent chat = FXMLLoader.load(getClass().getResource("fxml/auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Welcome to the GeekChat");
        stage.getIcons().add(new Image("company/lesson7/icon.png"));
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        client.close();
        input.getScene().getWindow().hide();
        FileHistoryService.getInstance().save(
                Arrays.asList(output.getText().split("\n").clone()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FileHistoryService.getInstance().load().forEach(historyLine -> {
            output.appendText(historyLine + "\n");
        });

        try {
            client = new Client();
            client.write("/loginuser " + MockAuthServiceImpl.getInstance().getName());
            read(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}