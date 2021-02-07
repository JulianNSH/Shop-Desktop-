package github.JulianNSH.Employees;

import github.JulianNSH.DatabaseConnector;
import github.JulianNSH.LogOut;
import github.JulianNSH.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Employees implements Initializable {

    @FXML private TableView<EmployeesModel> tableView;
    @FXML private TableColumn<EmployeesModel, Integer> employeeId;
    @FXML private TableColumn<EmployeesModel, String> employeeName;
    @FXML private TableColumn<EmployeesModel, String> employeeSurname;
    @FXML private TableColumn<EmployeesModel, String> employeePosition;
    @FXML private TableColumn<EmployeesModel, Integer> employeeAge;
    @FXML private TableColumn<EmployeesModel, Double> employeeSalary;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        employeeId.setCellValueFactory(new PropertyValueFactory<>("EmployeeId"));
        employeeName.setCellValueFactory(new PropertyValueFactory<>("EmployeeName"));
        employeeSurname.setCellValueFactory(new PropertyValueFactory<>("EmployeeSurname"));
        employeePosition.setCellValueFactory(new PropertyValueFactory<>("EmployeePosition"));
        employeeAge.setCellValueFactory(new PropertyValueFactory<>("EmployeeAge"));
        employeeSalary.setCellValueFactory(new PropertyValueFactory<>("EmployeeSalary"));

        tableView.setItems(employeesModels);
    }

    private ObservableList<EmployeesModel> employeesModels;

    {
        try {
            employeesModels = FXCollections.observableArrayList(parserList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<EmployeesModel> parserList () throws SQLException {

        List<EmployeesModel> data= new ArrayList<>();
        //select all fields from table and creates statement and resultSet
        Connection connector = DatabaseConnector.connect();
        if(connector!=null){
            String sqlQuery = "SELECT * from employees";
            Statement sqlStatement = connector.createStatement();
            ResultSet sqlResult = sqlStatement.executeQuery(sqlQuery);

            while (sqlResult.next()){
                data.add(new EmployeesModel(
                        sqlResult.getInt("id_employee"),
                        sqlResult.getString("name_empl"),
                        sqlResult.getString("surname_empl"),
                        sqlResult.getString("position"),
                        sqlResult.getInt("age"),
                        sqlResult.getDouble("salary")));
            }
        }
        return data;
    }

    public static void employeesScene(Button sceneButton)throws Exception {

        //System.out.println(parserList());
        ///////
        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Employees.class.getResource("employees.fxml"));
        stage.setTitle("Employees Data");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
        ///////

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
