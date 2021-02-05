package github.JulianNSH.Employees;

import github.JulianNSH.LogOut;
import github.JulianNSH.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Employees {
    public static void employeesScene(Button sceneButton)throws Exception{

        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Employees.class.getResource("employees.fxml"));
        stage.setTitle("Employees Data");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }

    @FXML Button logOutButton, backButton, refreshButton, addEmployeeButton, updateEmployeeButton, deleteEmployeeButton;
    public void handleEmployeesButtonsAction(ActionEvent buttonClick) throws Exception {
        if(buttonClick.getSource() == addEmployeeButton){
            AddEmployee.addEmployeeScene();
        }
        if(buttonClick.getSource() == updateEmployeeButton){
            UpdateEmployee.updateEmployeeScene();
        }
        if(buttonClick.getSource() == deleteEmployeeButton){
            DeleteEmployee.deleteEmployeeScene();
        }
        if (buttonClick.getSource()==logOutButton){
            LogOut.exit(logOutButton);
        }
        if (buttonClick.getSource()==backButton){
            Menu.menuScene(backButton);
        }
        if (buttonClick.getSource()==refreshButton){
            employeesScene(refreshButton);
        }
    }
}
