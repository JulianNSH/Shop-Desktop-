package github.JulianNSH.Sales;

import github.JulianNSH.Products.DeleteProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteSale {
    public static void deleteSaleScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(DeleteSale.class.getResource("deleteSale.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button deleteButton;
    @FXML
    TextField idField;
    @FXML
    Label errorLabel;

    public void handleDeleteSaleButton(ActionEvent actionButton) {
        if(actionButton.getSource() == deleteButton){
            if(idField.getText().isEmpty()){

                errorLabel.setText("Empty field. Write ID to delete");
            } else {
                //delete from Database

                //close scene
                Stage stage = (Stage) deleteButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
