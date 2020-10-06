package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MedicamentName {
    SimpleIntegerProperty id;
    SimpleStringProperty name;
    SimpleStringProperty dosage = new SimpleStringProperty("");;

    public MedicamentName(String name) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleIntegerProperty();

    }

    public MedicamentName(String name, String dosage) {
        this.name =new SimpleStringProperty( name);
        this.dosage.setValue(dosage);
        this.id = new SimpleIntegerProperty();
    }
    public MedicamentName(int id,String name, String dosage) {
        this.name =new SimpleStringProperty(name);
        this.dosage.setValue(dosage);
        this.id = new SimpleIntegerProperty(id);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDosage() {
        return dosage.get();
    }
    public String getNameDosage() {
        return name.get()+"\t"+dosage.get();
    }

    public SimpleStringProperty dosageProperty() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage.set(dosage);
    }
}
