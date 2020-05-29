package medical;

import javafx.beans.property.SimpleStringProperty;

public class MedicamentName {

    SimpleStringProperty name;
    SimpleStringProperty dosage;

    public MedicamentName(String name) {
        this.name = new SimpleStringProperty(name);
        this.dosage = new SimpleStringProperty("");
    }

    public MedicamentName(String name, String dosage) {
        this.name =new SimpleStringProperty( name);
        this.dosage = new SimpleStringProperty(dosage);
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
