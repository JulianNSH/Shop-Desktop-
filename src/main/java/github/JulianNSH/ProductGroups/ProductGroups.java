package github.JulianNSH.ProductGroups;

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

public class ProductGroups implements Initializable {
    @FXML private TableView<ProductGroupsModel> tableView;
    @FXML private TableColumn<ProductGroupsModel, Integer> pgId;
    @FXML private TableColumn<ProductGroupsModel, String> productGroup;
    @FXML private TableColumn<ProductGroupsModel, Integer> numberOfUnits;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pgId.setCellValueFactory(new PropertyValueFactory<>("PGId"));
        productGroup.setCellValueFactory(new PropertyValueFactory<>("ProductGroup"));
        numberOfUnits.setCellValueFactory(new PropertyValueFactory<>("NumberOfUnits"));

        tableView.setItems(pgModels);
    }

    private ObservableList<ProductGroupsModel> pgModels;

    {
        try {
            pgModels = FXCollections.observableArrayList(parserList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private List<ProductGroupsModel> parserList () throws SQLException {

        List<ProductGroupsModel> data= new ArrayList<>();
        //select all fields from table and creates statement and resultSet
        Connection connector = DatabaseConnector.connect();
        if(connector!=null){
            String sqlQuery = "SELECT * from product_groups";
            Statement sqlStatement = connector.createStatement();
            ResultSet sqlResult = sqlStatement.executeQuery(sqlQuery);

            while (sqlResult.next()){
                data.add(new ProductGroupsModel(
                        sqlResult.getInt("id_group"),
                        sqlResult.getString("group_name"),
                        sqlResult.getInt("units_number")));
            }
        }
        return data;
    }
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
