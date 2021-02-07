package github.JulianNSH.Sales;

import github.JulianNSH.DatabaseConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void handleUpdateSaleButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || productIdField.getText().isEmpty() ||
                    saleField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //update data to Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "UPDATE sales SET id_product = ?, discount =? WHERE id_sale = ?";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    sqlStatement.setInt(1, Integer.parseInt(productIdField.getText()));
                    sqlStatement.setInt(2, Integer.parseInt(saleField.getText()));
                    sqlStatement.setInt(3, Integer.parseInt(idField.getText()));

                    sqlStatement.executeUpdate();
                    sqlStatement.close();
                    System.out.println("Row updated successfully");
                }
                //close scene
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
