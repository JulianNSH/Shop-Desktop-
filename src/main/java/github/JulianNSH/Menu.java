package github.JulianNSH;

import github.JulianNSH.Buyers.Buyers;
import github.JulianNSH.Employees.Employees;
import github.JulianNSH.ProductGroups.ProductGroups;
import github.JulianNSH.Products.Products;
import github.JulianNSH.Sales.Sales;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/*
Main Menu Controller
 */
public class Menu  {

    //Creating Menu window in the same stage (App)
    public static void menuScene(Button originButton) throws  Exception {
        Stage stage = (Stage)originButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Menu.class.getResource("menu.fxml"));
        stage.setTitle("Menu");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }
//getting buttons from fxml to check which one was clicked
    @FXML
    private Button logOutButton, employeesButton, productGroupsButton, productsButton, buyersButton, salesButton;

    //Creates the respective scene of the entity according to the key button
    @FXML
    protected void handleMenuButtonsAction(ActionEvent buttonClick) throws Exception {
        if (buttonClick.getSource()==logOutButton){
            LogOut.exit(logOutButton);
        }
        if (buttonClick.getSource()==employeesButton){
            Employees.employeesScene(employeesButton);
        }
        if (buttonClick.getSource()==productGroupsButton){
            ProductGroups.productGroupsScene(productGroupsButton);
        }
        if (buttonClick.getSource()==productsButton){
            Products.productsScene(productsButton);
        }
        if (buttonClick.getSource()==buyersButton){
            Buyers.buyersScene(buyersButton);
        }
        if (buttonClick.getSource()==salesButton){
            Sales.salesScene(salesButton);
        }
    }

}
