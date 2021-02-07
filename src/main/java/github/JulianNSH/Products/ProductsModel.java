package github.JulianNSH.Products;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductsModel {
    private final SimpleIntegerProperty productId;
    private final SimpleStringProperty productName;
    private final SimpleStringProperty productGroup;
    private final SimpleDoubleProperty productPrice;

    public ProductsModel(Integer productId, String productName, String productGroup, Double productPrice) {
        this.productId = new SimpleIntegerProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.productGroup = new SimpleStringProperty(productGroup);
        this.productPrice = new SimpleDoubleProperty(productPrice);
    }

    public int getProductId() {
        return productId.get();
    }

    public SimpleIntegerProperty productIdProperty() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId.set(productId);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getProductGroup() {
        return productGroup.get();
    }

    public SimpleStringProperty productGroupProperty() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup.set(productGroup);
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public SimpleDoubleProperty productPriceProperty() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice.set(productPrice);
    }
}
