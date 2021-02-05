package github.JulianNSH.Products;

import github.JulianNSH.Employees.AddEmployee;
import github.JulianNSH.Employees.DeleteEmployee;
import github.JulianNSH.Employees.Employees;
import github.JulianNSH.Employees.UpdateEmployee;
import github.JulianNSH.LogOut;
import github.JulianNSH.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Products {
    public static void productsScene(Button sceneButton) throws Exception{
        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Products.class.getResource("products.fxml"));
        stage.setTitle("Products Data");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    Button logOutButton, backButton, refreshButton, addProductButton, updateProductButton, deleteProductButton;
    public void handleProductsButtonsAction(ActionEvent buttonClick) throws Exception {
        if(buttonClick.getSource() == addProductButton){
            AddProduct.addProductScene();
        }
        if(buttonClick.getSource() == updateProductButton){
            UpdateProduct.updateProductScene();
        }
        if(buttonClick.getSource() == deleteProductButton){
            DeleteProduct.deleteProductScene();
        }
        if (buttonClick.getSource()==logOutButton){
            LogOut.exit(logOutButton);
        }
        if (buttonClick.getSource()==backButton){
            Menu.menuScene(backButton);
        }
        if (buttonClick.getSource()==refreshButton){
            productsScene(refreshButton);
        }
    }
}
