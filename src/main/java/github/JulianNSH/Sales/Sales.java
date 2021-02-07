package github.JulianNSH.Sales;

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

public class Sales implements Initializable {

    @FXML private TableView<SalesModel> tableView;
    @FXML private TableColumn<SalesModel, Integer> saleId;
    @FXML private TableColumn<SalesModel, String> saleProduct;
    @FXML private TableColumn<SalesModel, Integer> sale;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        saleId.setCellValueFactory(new PropertyValueFactory<>("SaleId"));
        saleProduct.setCellValueFactory(new PropertyValueFactory<>("SaleProduct"));
        sale.setCellValueFactory(new PropertyValueFactory<>("Sale"));

        tableView.setItems(saleModels);
    }

    private ObservableList<SalesModel> saleModels;

    {
        try {
            saleModels = FXCollections.observableArrayList(parserList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<SalesModel> parserList () throws SQLException {

        List<SalesModel> data= new ArrayList<>();
        //select all fields from table and creates statement and resultSet
        Connection connector = DatabaseConnector.connect();
        if(connector!=null){
            String sqlQuery = "SELECT * from sales JOIN products p on p.id_product = sales.id_product";
            Statement sqlStatement = connector.createStatement();
            ResultSet sqlResult = sqlStatement.executeQuery(sqlQuery);

            while (sqlResult.next()){
                data.add(new SalesModel(
                        sqlResult.getInt("id_sale"),
                        sqlResult.getString("name_product"),
                        sqlResult.getInt("discount")));
            }
        }
        return data;
    }
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
