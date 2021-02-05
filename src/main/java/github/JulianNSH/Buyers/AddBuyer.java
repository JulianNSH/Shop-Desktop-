package github.JulianNSH.Buyers;

import github.JulianNSH.Employees.AddEmployee;
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
Controller to add 1 row in Database
 */
public class AddBuyer {
    //Creating new stage and scene over the previous one
    public static void addBuyerScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddBuyer.class.getResource("addBuyer.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    //get values from FXML
    @FXML
    Button addButton;
    @FXML
    TextField idField, nameField, surnameField, acquisitionsField, discountField;
    @FXML
    Label errorLabel;

    //Check if all was inputted correctly
    public void handleAddBuyerButton(ActionEvent actionButton) {
        if(actionButton.getSource() == addButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty() ||
                    acquisitionsField.getText().isEmpty() || discountField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //apply query and exit
                //add data to Database

                //close scene
                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
