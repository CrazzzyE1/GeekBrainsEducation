package company.lesson7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    public TextField login;
    public TextField password;

    public void enter(ActionEvent actionEvent) throws IOException {
        boolean reg = MockAuthServiceImpl.getInstance()
                .auth(login.getText(), password.getText());

        if (login.getText().trim().isEmpty() && password.getText().trim().isEmpty()) {
            login.clear();
            login.setPromptText("Empty Login or Password");
            password.clear();
        } else if (!reg) {
            MockAuthServiceImpl.getInstance().addUser(login.getText(), password.getText());
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
            login.setPromptText("This name already exists");
            password.clear();
        }
    }
}