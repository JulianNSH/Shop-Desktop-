package github.JulianNSH.ProductGroups;

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

public class UpdateProductGroup {
    public static void updatePGScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(UpdateProductGroup.class.getResource("updateProductGroup.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }

    @FXML
    Button updateButton;
    @FXML
    TextField idField, productGroupField, unitsField;
    @FXML
    Label errorLabel;
    public void handleUpdatePGButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || productGroupField.getText().isEmpty() ||
                    unitsField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //update data from Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "UPDATE product_groups SET group_name = ?, units_number =? WHERE id_group = ?";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    sqlStatement.setString(1, productGroupField.getText());
                    sqlStatement.setInt(2, Integer.parseInt(unitsField.getText()));
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
