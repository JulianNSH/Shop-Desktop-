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

public class DeleteProduct {
    public static void deleteProductScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(DeleteProduct.class.getResource("deleteProduct.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button deleteButton;
    @FXML
    TextField idField;
    @FXML
    Label errorLabel;

    public void handleDeleteProductButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == deleteButton){
            if(idField.getText().isEmpty()){

                errorLabel.setText("Empty field. Write ID to delete");
            } else {
                //delete from Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null) {
                    //prepare SQL query and statement
                    String sqlQuery = "DELETE FROM products WHERE id_product = ?";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    //apply query to statement
                    sqlStatement.setInt(1, Integer.parseInt(idField.getText()));

                    //update and close table
                    sqlStatement.executeUpdate();
                    sqlStatement.close();

                    System.out.println("Row deleted successfully");
                }
                //close scene
                Stage stage = (Stage) deleteButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
