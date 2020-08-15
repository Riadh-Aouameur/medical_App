package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {
    SimpleIntegerProperty id;
    SimpleObjectProperty<LocalDate> date;

    public Prescription(Integer id, LocalDate date) {
        this.id =  new  SimpleIntegerProperty(id);
        this.date = new SimpleObjectProperty<>(date);
    }

    ObservableList <Medicament> observableList =FXCollections.observableArrayList();

    public Prescription( LocalDate date,ObservableList<Medicament>observableList) {
        this.id = new SimpleIntegerProperty();
        this.date = new SimpleObjectProperty<LocalDate>(date);
        this.observableList.setAll(observableList);
    }



    public ObservableList<Medicament> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<Medicament> observableList) {
        this.observableList = observableList;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Object getDate() {
        return date.get();
    }

    public int getId() {
        return id.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }
}
