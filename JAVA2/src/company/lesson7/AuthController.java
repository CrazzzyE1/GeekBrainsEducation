package company.lesson7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {

    public TextField login;
    public TextField password;

    public void enter(ActionEvent actionEvent) throws IOException {
        boolean auth = MockAuthServiceImpl.getInstance()
                .auth(login.getText(), password.getText());
        if (auth) {
            MockAuthServiceImpl.getInstance().setName(login.getText());
            Parent chat = FXMLLoader.load(getClass().getResource("fxml/chat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Chat");
            stage.getIcons().add(new Image("company/lesson7/icon.png"));

            stage.setScene(new Scene(chat));
            stage.setResizable(false);
            stage.show();
            login.getScene().getWindow().hide();
        } else {
            login.clear();
            login.setPromptText("Wrong login or password");
            password.clear();
        }
    }

    public void reg(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("fxml/registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.getIcons().add(new Image("company/lesson7/icon.png"));
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        login.getScene().getWindow().hide();
    }


}