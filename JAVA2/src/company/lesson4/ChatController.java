package company.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    public TextArea output;
    public TextField input;

    public void send(ActionEvent actionEvent) {
        if(!input.getText().isEmpty()){
            output.appendText(input.getText() + "\n");
            input.clear();
        }

    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("fxml/auth.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Welcome to the GeekChat");
        stage.getIcons().add(new Image("company/lesson4/icon.png"));
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        input.getScene().getWindow().hide();
        FileHistoryService.getInstance().save(
                Arrays.asList(output.getText().split("\n").clone()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FileHistoryService.getInstance().load().forEach(historyLine -> {
            output.appendText(historyLine + "\n");
        });
    }
}