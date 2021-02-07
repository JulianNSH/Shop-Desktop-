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

public class AddEmployee {

    public static void addEmployeeScene() throws Exception{
        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(282);
        stage.setMaxWidth(600);
        stage.setMinHeight(282);
        Parent root = FXMLLoader.load(AddEmployee.class.getResource("addEmployee.fxml"));
        stage.setScene(new Scene(root, 600,282));
        stage.show();
    }

    @FXML
    Button addButton;
    @FXML
    TextField idField, nameField, surnameField, positionField, ageField, salaryField;
    @FXML
    Label errorLabel;
    public void handleAddEmployeeButton(ActionEvent actionButton) throws SQLException {
        if(actionButton.getSource() == addButton){
            if(idField.getText().isEmpty() || nameField.getText().isEmpty() ||
                    surnameField.getText().isEmpty() ||  positionField.getText().isEmpty() ||
                    ageField.getText().isEmpty() || salaryField.getText().isEmpty()){

                errorLabel.setText("Empty data. Complete all fields");
            } else {
                //insert data to Database
                Connection connector = DatabaseConnector.connect();
                if(connector!=null){
                    String sqlQuery = "INSERT INTO employees(id_employee, name_empl, surname_empl, position, age, salary) VALUES(?,?,?,?,?,?)";
                    PreparedStatement sqlStatement = connector.prepareStatement(sqlQuery);

                    sqlStatement.setInt(1, Integer.parseInt(idField.getText()));
                    sqlStatement.setString(2, nameField.getText());
                    sqlStatement.setString(3, surnameField.getText());
                    sqlStatement.setString(4, positionField.getText());
                    sqlStatement.setInt(5, Integer.parseInt(ageField.getText()));
                    sqlStatement.setDouble(6, Double.parseDouble(salaryField.getText()));

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
