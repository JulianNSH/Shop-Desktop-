package github.JulianNSH.ProductGroups;

import github.JulianNSH.LogOut;
import github.JulianNSH.Menu;
import github.JulianNSH.Sales.AddSale;
import github.JulianNSH.Sales.DeleteSale;
import github.JulianNSH.Sales.Sales;
import github.JulianNSH.Sales.UpdateSale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProductGroups {
    public static void productGroupsScene(Button sceneButton) throws Exception{
        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(ProductGroups.class.getResource("productGroups.fxml"));
        stage.setTitle("Product Groups Data");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    Button logOutButton, backButton, refreshButton, addPGButton, updatePGButton, deletePGButton;
    public void handleProductGroupsButtonsAction(ActionEvent buttonClick) throws Exception {
        if(buttonClick.getSource() == addPGButton){
            AddProductGroup.addPGScene();
        }
        if(buttonClick.getSource() == updatePGButton){
            UpdateProductGroup.updatePGScene();
        }
        if(buttonClick.getSource() == deletePGButton){
            DeleteProductGroup.deletePGScene();
        }
        if (buttonClick.getSource()==logOutButton){
            LogOut.exit(logOutButton);
        }
        if (buttonClick.getSource()==backButton){
            Menu.menuScene(backButton);
        }
        if (buttonClick.getSource()==refreshButton){
            productGroupsScene(refreshButton);
        }
    }
}
