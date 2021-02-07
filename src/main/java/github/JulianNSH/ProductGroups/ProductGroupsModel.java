package github.JulianNSH.ProductGroups;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductGroupsModel {
    private final SimpleIntegerProperty PGId;
    private final SimpleStringProperty productGroup;
    private final SimpleIntegerProperty numberOfUnits;

    public ProductGroupsModel(Integer PGId, String productGroup, Integer numberOfUnits) {
        this.PGId = new SimpleIntegerProperty(PGId);
        this.productGroup = new SimpleStringProperty(productGroup);
        this.numberOfUnits = new SimpleIntegerProperty(numberOfUnits);
    }

    public int getPGId() {
        return PGId.get();
    }

    public SimpleIntegerProperty PGIdProperty() {
        return PGId;
    }

    public void setPGId(int PGId) {
        this.PGId.set(PGId);
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

    public int getNumberOfUnits() {
        return numberOfUnits.get();
    }

    public SimpleIntegerProperty numberOfUnitsProperty() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits.set(numberOfUnits);
    }
}
