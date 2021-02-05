package github.JulianNSH.Sales;

import github.JulianNSH.LogOut;
import github.JulianNSH.Menu;
import github.JulianNSH.Products.AddProduct;
import github.JulianNSH.Products.DeleteProduct;
import github.JulianNSH.Products.Products;
import github.JulianNSH.Products.UpdateProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Sales {
    public static void salesScene(Button sceneButton) throws Exception{
        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Sales.class.getResource("sales.fxml"));
        stage.setTitle("Sales Data");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    Button logOutButton, backButton, refreshButton, addSaleButton, updateSaleButton, deleteSaleButton;
    public void handleSalesButtonsAction(ActionEvent buttonClick) throws Exception {
        if(buttonClick.getSource() == addSaleButton){
            AddSale.addSaleScene();
        }
        if(buttonClick.getSource() == updateSaleButton){
            UpdateSale.updateSaleScene();
        }
        if(buttonClick.getSource() == deleteSaleButton){
            DeleteSale.deleteSaleScene();
        }
        if (buttonClick.getSource()==logOutButton){
            LogOut.exit(logOutButton);
        }
        if (buttonClick.getSource()==backButton){
            Menu.menuScene(backButton);
        }
        if (buttonClick.getSource()==refreshButton){
            salesScene(refreshButton);
        }
    }
}
