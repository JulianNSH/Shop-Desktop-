package github.JulianNSH.Sales;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SalesModel {
    private final SimpleIntegerProperty saleId;
    private final SimpleStringProperty saleProduct;
    private final SimpleIntegerProperty sale;

    public SalesModel(Integer saleId, String saleProduct, Integer sale) {
        this.saleId = new SimpleIntegerProperty(saleId);
        this.saleProduct = new SimpleStringProperty(saleProduct);
        this.sale = new SimpleIntegerProperty(sale);
    }

    public int getSaleId() {
        return saleId.get();
    }

    public SimpleIntegerProperty saleIdProperty() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId.set(saleId);
    }

    public String getSaleProduct() {
        return saleProduct.get();
    }

    public SimpleStringProperty saleProductProperty() {
        return saleProduct;
    }

    public void setSaleProduct(String saleProduct) {
        this.saleProduct.set(saleProduct);
    }

    public int getSale() {
        return sale.get();
    }

    public SimpleIntegerProperty saleProperty() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale.set(sale);
    }
}
