package github.JulianNSH.Employees;

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

public class UpdateEmployee {

    public static void updateEmployeeScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(UpdateEmployee.class.getResource("updateEmployee.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }
    @FXML
    Button updateButton;
    @FXML
    TextField idField, nameField, surnameField, positionField, ageField, salaryField;
    @FXML
    Label errorLabel;
    public void handleUpdateEmployeeButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == updateButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty() ||  positionField.getText().isEmpty() ||
                    ageField.getText().isEmpty() || salaryField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields!");
            } else {
                //update data to Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "UPDATE employees SET name_empl= ?, surname_empl= ?, position= ?, age = ?, salary = ?  WHERE id_employee = ?";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    sqlStatement.setString(1, nameField.getText());
                    sqlStatement.setString(2, surnameField.getText());
                    sqlStatement.setString(3, positionField.getText());
                    sqlStatement.setInt(4, Integer.parseInt(ageField.getText()));
                    sqlStatement.setDouble(5, Double.parseDouble(salaryField.getText()));
                    sqlStatement.setInt(6, Integer.parseInt(idField.getText()));

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
