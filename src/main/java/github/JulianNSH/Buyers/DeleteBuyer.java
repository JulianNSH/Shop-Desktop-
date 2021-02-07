package github.JulianNSH.Buyers;

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

/*
Controller to remove 1 row in Database
 */
public class DeleteBuyer {
    //Creating new stage and scene over the previous one
    public static void deleteBuyerScene()throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddBuyer.class.getResource("deleteBuyer.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }

    //get values from FXML
    @FXML
    Button deleteButton;
    @FXML
    TextField idField;
    @FXML
    Label errorLabel;

    //Check if all was inputted correctly
    public void handleDeleteBuyerButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == deleteButton){
            if(idField.getText().isEmpty()){

                errorLabel.setText("Empty field. Write ID to delete");
            } else {
                //apply query and exit
                //delete from Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null) {
                    //prepare SQL query and statement
                    String sqlQuery = "DELETE FROM buyerscc WHERE id_buyer = ?";
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
