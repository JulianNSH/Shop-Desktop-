package github.JulianNSH.Products;

import github.JulianNSH.Buyers.AddBuyer;
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

public class AddProduct {
    public static void addProductScene()throws Exception {
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddProduct.class.getResource("addProduct.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button addButton;
    @FXML
    TextField idField, nameField, groupIdField, priceField;
    @FXML
    Label errorLabel;
    public void handleAddProductButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == addButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() ||
                    groupIdField.getText().isEmpty() || priceField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //add data to Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "INSERT INTO products(id_product, name_product, id_group, price) VALUES(?,?,?,?)";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    sqlStatement.setInt(1, Integer.parseInt(idField.getText()));
                    sqlStatement.setString(2, nameField.getText());
                    sqlStatement.setInt(3, Integer.parseInt(groupIdField.getText()));
                    sqlStatement.setDouble(4, Double.parseDouble(priceField.getText()));

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
