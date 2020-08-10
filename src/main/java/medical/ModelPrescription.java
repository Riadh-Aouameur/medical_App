package medical;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelPrescription {
    SimpleStringProperty name;

    public ObservableList<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(ObservableList<Medicament> medicaments) {
        this.medicaments.addAll( medicaments);
    }

    ObservableList <Medicament> medicaments ;


    public ModelPrescription(String name) {
        this.name = new SimpleStringProperty( name);
        medicaments = FXCollections.observableArrayList();
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


}
