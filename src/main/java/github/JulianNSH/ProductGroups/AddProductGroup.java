package github.JulianNSH.ProductGroups;

import github.JulianNSH.Sales.AddSale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductGroup {
    public static void addPGScene() throws Exception {
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddProductGroup.class.getResource("addProductGroup.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button addButton;
    @FXML
    TextField idField, productGroupField, unitsField;
    @FXML
    Label errorLabel;
    public void handleAddPGButton(ActionEvent actionButton) {
        if(actionButton.getSource() == addButton){
            if(idField.getText().isEmpty() || productGroupField.getText().isEmpty() ||
                    unitsField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //add data to Database

                //close scene
                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
