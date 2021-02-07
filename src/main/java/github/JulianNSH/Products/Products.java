package github.JulianNSH.Products;

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

public class Products implements Initializable {
    @FXML private TableView<ProductsModel> tableView;
    @FXML private TableColumn<ProductsModel, Integer> productId;
    @FXML private TableColumn<ProductsModel, String> productName;
    @FXML private TableColumn<ProductsModel, String> productGroup;
    @FXML private TableColumn<ProductsModel, Double> productPrice;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        productId.setCellValueFactory(new PropertyValueFactory<>("ProductId"));
        productName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        productGroup.setCellValueFactory(new PropertyValueFactory<>("ProductGroup"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));

        tableView.setItems(buyersModels);
    }

    private ObservableList<ProductsModel> buyersModels;

    {
        try {
            buyersModels = FXCollections.observableArrayList(parserList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<ProductsModel> parserList () throws SQLException {

        List<ProductsModel> data= new ArrayList<>();
        //select all fields from table and creates statement and resultSet
        Connection connector = DatabaseConnector.connect();
        if(connector!=null){
            String sqlQuery = "SELECT * from products JOIN product_groups pg on products.id_group = pg.id_group";
            Statement sqlStatement = connector.createStatement();
            ResultSet sqlResult = sqlStatement.executeQuery(sqlQuery);

            while (sqlResult.next()){
                data.add(new ProductsModel(
                        sqlResult.getInt("id_product"),
                        sqlResult.getString("name_product"),
                        sqlResult.getString("group_name"),
                        sqlResult.getDouble("price")));
            }
        }
        return data;
    }
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
