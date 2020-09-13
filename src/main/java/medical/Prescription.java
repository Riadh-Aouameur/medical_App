package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Prescription {
    SimpleIntegerProperty id;
    SimpleIntegerProperty doctorID;
    SimpleIntegerProperty patientID;
    SimpleObjectProperty<LocalDate> date;

    public Prescription(Integer id, LocalDate date) {
        this.id =  new  SimpleIntegerProperty(id);
        this.date = new SimpleObjectProperty<>(date);
        this.doctorID =  new  SimpleIntegerProperty();
        this.patientID =  new  SimpleIntegerProperty();
    }
    public Prescription(Integer id, LocalDate date,Integer doctorID,Integer patientID) {
        this.id =  new  SimpleIntegerProperty(id);
        this.doctorID =  new  SimpleIntegerProperty(doctorID);
        this.patientID =  new  SimpleIntegerProperty(patientID);
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
    public int getDoctorID() {
        return doctorID.get();
    }

    public SimpleIntegerProperty doctorIDProperty() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID.set(doctorID);
    }

    public int getPatientID() {
        return patientID.get();
    }

    public SimpleIntegerProperty patientIDProperty() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID.set(patientID);
    }
}
