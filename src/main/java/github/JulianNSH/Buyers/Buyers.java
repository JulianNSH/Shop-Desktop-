package github.JulianNSH.Buyers;

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
/*
Controller that shows Buyers entity data and allow to Add, Update or Delete some data
 */


public class Buyers implements Initializable {

    //get table and columns from FXML
    @FXML private TableView<BuyersModel> tableView;
    @FXML private TableColumn<BuyersModel, Integer> buyerId;
    @FXML private TableColumn<BuyersModel, String> buyerName;
    @FXML private TableColumn<BuyersModel, String> buyerSurname;
    @FXML private TableColumn<BuyersModel, Double> buyerAcquisitions;
    @FXML private TableColumn<BuyersModel, Integer> buyerDiscount;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //initialize rows for each columns
        buyerId.setCellValueFactory(new PropertyValueFactory<>("BuyerId"));
        buyerName.setCellValueFactory(new PropertyValueFactory<>("BuyerName"));
        buyerSurname.setCellValueFactory(new PropertyValueFactory<>("BuyerSurname"));
        buyerAcquisitions.setCellValueFactory(new PropertyValueFactory<>("BuyerAcquisitions"));
        buyerDiscount.setCellValueFactory(new PropertyValueFactory<>("BuyerDiscount"));

        //apply list of model items
        tableView.setItems(buyersModels);
    }


    private ObservableList<BuyersModel> buyersModels;
    {
        try {
            //get list from parseList() method
            buyersModels = FXCollections.observableArrayList(parserList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //get data from the database and add it to a model list
    private List<BuyersModel> parserList () throws SQLException {

        List<BuyersModel> data= new ArrayList<>();
        //select all fields from table and creates statement and resultSet
        Connection connector = DatabaseConnector.connect();
        if(connector!=null){
            String sqlQuery = "SELECT * from buyerscc";
            Statement sqlStatement = connector.createStatement();
            ResultSet sqlResult = sqlStatement.executeQuery(sqlQuery);

            while (sqlResult.next()){
                data.add(new BuyersModel(
                        sqlResult.getInt("id_buyer"),
                        sqlResult.getString("name_buyer"),
                        sqlResult.getString("surname_buyer"),
                        sqlResult.getDouble("acquisitions"),
                        sqlResult.getInt("discount")));
            }
        }
        return data;
    }

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
