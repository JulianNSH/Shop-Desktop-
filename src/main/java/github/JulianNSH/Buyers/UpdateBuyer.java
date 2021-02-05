package github.JulianNSH.Buyers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/*
Controller to Update 1 row in Database
 */
public class UpdateBuyer {
    //Creating new stage and scene over the previous one
    public static void updateBuyerScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddBuyer.class.getResource("updateBuyer.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }

    //get values from FXML
    @FXML
    Button updateButton;
    @FXML
    TextField idField, nameField, surnameField, acquisitionsField, discountField;
    @FXML
    Label errorLabel;

    //Check if all was inputted correctly
    public void handleUpdateBuyerButton(ActionEvent actionButton) {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty() ||
                    acquisitionsField.getText().isEmpty() || discountField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields ");
            } else {
                //apply query and exit
                //update data to Database

                //close scene
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
