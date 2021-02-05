package github.JulianNSH.Sales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSale {
    public static void updateSaleScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(UpdateSale.class.getResource("updateSale.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }

    @FXML
    Button updateButton;
    @FXML
    TextField idField, productIdField, saleField;
    @FXML
    Label errorLabel;

    public void handleUpdateSaleButton(ActionEvent actionButton) {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || productIdField.getText().isEmpty() ||
                    saleField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //add data to Database

                //close scene
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
