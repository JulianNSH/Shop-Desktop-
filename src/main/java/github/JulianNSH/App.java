package github.JulianNSH;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
/*
*               SHOP APPLICATION
*                  (Desktop)
*                  PHASE IV
*
*   Add an interface to application, by replacing the console app with GUI
*/

public class App extends Application {

    //Create stage for Logging In window
    @Override
    public void start(Stage stage) throws Exception {
        stage.setMinHeight(440);//setting default min dimensions for window
        stage.setMinWidth(800);
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));//load the fxml markup
        stage.setTitle("Logging In");//set title
        stage.setScene(new Scene(root, 800,440)); //creating scene with specified parameters
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Get values of controls from fxml
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label errorLabel;
    @FXML
    public Button submitButton;

    @FXML
    protected void handleSubmitButtonAction() throws Exception {
        //check if input fields are correct completted
        if (usernameField.getText().isEmpty()){
            errorLabel.setTextFill(Paint.valueOf("#d63031"));
            errorLabel.setText("Empty Username Field");
            return;
        }
        if (passwordField.getText().isEmpty()){
            errorLabel.setTextFill(Paint.valueOf("#d63031"));
            errorLabel.setText("Empty Password Field");
            return;
        }

        if(DatabaseConnector.connect(usernameField.getText(), passwordField.getText()) == null){
            errorLabel.setTextFill(Paint.valueOf("#d63031"));
            errorLabel.setText("Can't connect to Database: Wrong 'Username' or 'Password'");
        } else {
            //continue to menu if all is correct
            Menu.menuScene(submitButton);
        }

    }
}
