package github.JulianNSH.Buyers;

import github.JulianNSH.LogOut;
import github.JulianNSH.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/*
Controller that shows Buyers entity data and allow to Add, Update or Delete some data
 */


public class Buyers {
    //Create new scene on same stage
    public static void buyersScene(Button sceneButton)throws Exception{
        Stage stage = (Stage)sceneButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Buyers.class.getResource("buyers.fxml"));
        stage.setTitle("Buyers Data");
        Scene scene = new Scene(root,800,440);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    Button logOutButton, backButton, refreshButton, addBuyerButton, updateBuyerButton, deleteBuyerButton;
//Assure interaction menu options
    public void handleBuyersButtonsAction(ActionEvent buttonClick) throws Exception {
        if(buttonClick.getSource() == addBuyerButton){
            AddBuyer.addBuyerScene();                           //Add to DB
        }
        if(buttonClick.getSource() == updateBuyerButton){
            UpdateBuyer.updateBuyerScene();                     //Update from DB
        }
        if(buttonClick.getSource() == deleteBuyerButton){
            DeleteBuyer.deleteBuyerScene();                     //Delete from DB
        }
        if (buttonClick.getSource()==logOutButton){
            LogOut.exit(logOutButton);                          //LogOut (go back to App for logging in)
        }
        if (buttonClick.getSource()==backButton){
            Menu.menuScene(backButton);                         //Go back to main menu
        }
        if (buttonClick.getSource()==refreshButton){
            buyersScene(refreshButton);                         //refresh scene
        }
    }
}
