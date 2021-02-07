package github.JulianNSH.Buyers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BuyersModel {
    private final SimpleIntegerProperty buyerId;
    private final SimpleStringProperty buyerName;
    private final SimpleStringProperty buyerSurname;
    private final SimpleDoubleProperty buyerAcquisitions;
    private final SimpleIntegerProperty buyerDiscount;

    public BuyersModel(Integer buyerId, String buyerName, String buyerSurname, Double buyerAcquisitions, Integer buyerDiscount) {
        this.buyerId = new SimpleIntegerProperty(buyerId);
        this.buyerName = new SimpleStringProperty(buyerName);
        this.buyerSurname = new SimpleStringProperty(buyerSurname);
        this.buyerAcquisitions = new SimpleDoubleProperty(buyerAcquisitions);
        this.buyerDiscount = new SimpleIntegerProperty(buyerDiscount);
    }

    public int getBuyerId() {
        return buyerId.get();
    }

    public SimpleIntegerProperty buyerIdProperty() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId.set(buyerId);
    }

    public String getBuyerName() {
        return buyerName.get();
    }

    public SimpleStringProperty buyerNameProperty() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName.set(buyerName);
    }

    public String getBuyerSurname() {
        return buyerSurname.get();
    }

    public SimpleStringProperty buyerSurnameProperty() {
        return buyerSurname;
    }

    public void setBuyerSurname(String buyerSurname) {
        this.buyerSurname.set(buyerSurname);
    }

    public double getBuyerAcquisitions() {
        return buyerAcquisitions.get();
    }

    public SimpleDoubleProperty buyerAcquisitionsProperty() {
        return buyerAcquisitions;
    }

    public void setBuyerAcquisitions(double buyerAcquisitions) {
        this.buyerAcquisitions.set(buyerAcquisitions);
    }

    public int getBuyerDiscount() {
        return buyerDiscount.get();
    }

    public SimpleIntegerProperty buyerDiscountProperty() {
        return buyerDiscount;
    }

    public void setBuyerDiscount(int buyerDiscount) {
        this.buyerDiscount.set(buyerDiscount);
    }
}
