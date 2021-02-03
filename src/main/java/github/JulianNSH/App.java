package github.JulianNSH;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
/*
*               SHOP APPLICATION
*                  (Desktop)
*                  PHASE IV
*
*   Add an interface to application, by replacing the console app with GUI
*/
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        stage.setTitle("Authentication");
        stage.setScene(new Scene(root, 600,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    protected void handleSubmitButtonAction(){
        if (passwordField.getText().isEmpty()){
            System.out.println("Empty");
            return;
        }
            System.out.println(passwordField.getText());


    }
}
