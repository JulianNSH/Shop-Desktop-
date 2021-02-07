package github.JulianNSH.Employees;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeesModel {
    private final SimpleIntegerProperty employeeId;
    private final SimpleStringProperty employeeName;
    private final SimpleStringProperty employeeSurname;
    private final SimpleStringProperty employeePosition;
    private final SimpleIntegerProperty employeeAge;
    private final SimpleDoubleProperty employeeSalary;

    public EmployeesModel(Integer employeeId, String employeeName, String employeeSurname, String employeePosition, Integer employeeAge, Double employeeSalary) {
        this.employeeId = new SimpleIntegerProperty(employeeId);
        this.employeeName = new SimpleStringProperty(employeeName);
        this.employeeSurname = new SimpleStringProperty(employeeSurname);
        this.employeePosition = new SimpleStringProperty(employeePosition);
        this.employeeAge = new SimpleIntegerProperty(employeeAge);
        this.employeeSalary = new SimpleDoubleProperty(employeeSalary);
    }

    public int getEmployeeId() {
        return employeeId.get();
    }

    public SimpleIntegerProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getEmployeeName() {
        return employeeName.get();
    }

    public SimpleStringProperty employeeNameProperty() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName.set(employeeName);
    }

    public String getEmployeeSurname() {
        return employeeSurname.get();
    }

    public SimpleStringProperty employeeSurnameProperty() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname.set(employeeSurname);
    }

    public String getEmployeePosition() {
        return employeePosition.get();
    }

    public SimpleStringProperty employeePositionProperty() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition.set(employeePosition);
    }

    public int getEmployeeAge() {
        return employeeAge.get();
    }

    public SimpleIntegerProperty employeeAgeProperty() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge.set(employeeAge);
    }

    public double getEmployeeSalary() {
        return employeeSalary.get();
    }

    public SimpleDoubleProperty employeeSalaryProperty() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary.set(employeeSalary);
    }
}