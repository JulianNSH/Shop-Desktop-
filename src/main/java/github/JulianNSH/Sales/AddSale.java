package github.JulianNSH.Sales;

import github.JulianNSH.DatabaseConnector;
import github.JulianNSH.Products.AddProduct;
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

public class AddSale {
    public static void addSaleScene() throws Exception {
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddSale.class.getResource("addSale.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button addButton;
    @FXML
    TextField idField, productIdField, saleField;
    @FXML
    Label errorLabel;

    public void handleAddPSaleButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == addButton){
            if(idField.getText().isEmpty() || productIdField.getText().isEmpty() ||
                    saleField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //add data to Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "INSERT INTO sales(id_sale, id_product, discount) VALUES(?,?,?)";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    sqlStatement.setInt(1, Integer.parseInt(idField.getText()));
                    sqlStatement.setInt(2, Integer.parseInt(productIdField.getText()));
                    sqlStatement.setInt(3, Integer.parseInt(saleField.getText()));

                    sqlStatement.executeUpdate();
                    sqlStatement.close();
                    System.out.println("Row added successfully");
                }
                //close scene
                Stage stage = (Stage) addButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
