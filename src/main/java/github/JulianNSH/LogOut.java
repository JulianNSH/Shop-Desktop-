package github.JulianNSH;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/*
Controller that assure exit from application to log in page
 */
public class LogOut {
    public static void exit(Button sceneButton) throws Exception {
        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Menu.class.getResource("app.fxml"));
        stage.setTitle("Logging In");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }
}
