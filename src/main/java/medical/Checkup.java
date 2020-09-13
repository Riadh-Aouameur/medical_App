package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Checkup {
    SimpleIntegerProperty id;
    SimpleStringProperty content;
    SimpleIntegerProperty doctorID;
    SimpleIntegerProperty patientID;
    SimpleObjectProperty<LocalDate> date;


    public Checkup( String content, LocalDate date,Integer doctorID,Integer patientID) {
        this.id = new SimpleIntegerProperty();
        this.content =  new SimpleStringProperty(content);
        this.doctorID = new SimpleIntegerProperty(doctorID);
        this.patientID = new SimpleIntegerProperty(patientID);
        this.date = new SimpleObjectProperty<>(date);
    }
    public Checkup( String content, LocalDate date,Integer doctorID,Integer patientID,int id) {
        this.id = new SimpleIntegerProperty(id);
        this.content =  new SimpleStringProperty(content);
        this.doctorID = new SimpleIntegerProperty(doctorID);
        this.patientID = new SimpleIntegerProperty(patientID);
        this.date = new SimpleObjectProperty<>(date);
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

    public String getContent() {
        return content.get();
    }

    public SimpleStringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
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

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }
}