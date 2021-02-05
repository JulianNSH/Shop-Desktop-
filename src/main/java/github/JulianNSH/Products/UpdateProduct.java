package github.JulianNSH.Products;

import github.JulianNSH.Buyers.AddBuyer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateProduct {
    public static void updateProductScene()throws Exception {
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(UpdateProduct.class.getResource("updateProduct.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button updateButton;
    @FXML
    TextField idField, nameField, groupIdField, priceField;
    @FXML
    Label errorLabel;
    public void handleUpdateProductButton(ActionEvent actionButton) {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() ||
                    groupIdField.getText().isEmpty() || priceField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields ");
            } else {
                //add data to Database

                //close scene
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
