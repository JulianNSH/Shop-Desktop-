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
Controller to Update 1 row in Database
 */
public class UpdateBuyer {
    //Creating new stage and scene over the previous one
    public static void updateBuyerScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddBuyer.class.getResource("updateBuyer.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }

    //get values from FXML
    @FXML
    Button updateButton;
    @FXML
    TextField idField, nameField, surnameField, acquisitionsField, discountField;
    @FXML
    Label errorLabel;

    //Check if all was inputted correctly
    public void handleUpdateBuyerButton(ActionEvent actionButton)throws SQLException {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty() ||
                    acquisitionsField.getText().isEmpty() || discountField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields ");
            } else {
                //apply query and exit
                //update data to Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "UPDATE buyerscc SET name_buyer= ?, surname_buyer= ?, acquisitions= ?, discount= ? WHERE id_buyer = ?";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    //set data from fxml fields to the query by index
                    sqlStatement.setString(1, nameField.getText());
                    sqlStatement.setString(2, surnameField.getText());
                    sqlStatement.setDouble(3, Double.parseDouble(acquisitionsField.getText()));
                    sqlStatement.setInt(4, Integer.parseInt(discountField.getText()));
                    sqlStatement.setInt(5, Integer.parseInt(idField.getText()));

                    sqlStatement.executeUpdate();
                    sqlStatement.close();
                    System.out.println("Row Updated successfully");
                }
                //close scene
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
            }
        }
    }
}
