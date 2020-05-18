package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Medicament {

SimpleStringProperty dosage;
SimpleIntegerProperty entityNumber;
SimpleStringProperty qsp;
SimpleStringProperty nameMedicament;

    public Medicament(String nameMedicament,String dosage, Integer entityNumber, String qsp) {
        this.dosage =new SimpleStringProperty( dosage);
        this.entityNumber = new SimpleIntegerProperty(entityNumber);
        this.qsp = new SimpleStringProperty(qsp);
        this.nameMedicament = new SimpleStringProperty(nameMedicament);
    }

    public String getDosage() {
        return dosage.get();
    }

    public SimpleStringProperty dosageProperty() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage.set(dosage);
    }

    public int getEntityNumber() {
        return entityNumber.get();
    }

    public SimpleIntegerProperty entityNumberProperty() {
        return entityNumber;
    }

    public void setEntityNumber(int entityNumber) {
        this.entityNumber.set(entityNumber);
    }

    public String getQsp() {
        return qsp.get();
    }

    public SimpleStringProperty qspProperty() {
        return qsp;
    }

    public void setQsp(String qsp) {
        this.qsp.set(qsp);
    }

    public String getNameMedicament() {
        return nameMedicament.get();
    }

    public SimpleStringProperty nameMedicamentProperty() {
        return nameMedicament;
    }

    public void setNameMedicament(String nameMedicament) {
        this.nameMedicament.set(nameMedicament);
    }
}