package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Document {
    SimpleIntegerProperty id;
     SimpleStringProperty content;
    SimpleIntegerProperty doctorID;
    SimpleIntegerProperty patientID;
     SimpleStringProperty type;
     SimpleObjectProperty <LocalDate>date;

    public Document( String content, String type, LocalDate date,Integer doctorID,Integer patientID) {
        this.id = new SimpleIntegerProperty();
        this.content =  new SimpleStringProperty(content);
        this.type = new SimpleStringProperty( type);
        this.doctorID = new SimpleIntegerProperty(doctorID);
        this.patientID = new SimpleIntegerProperty(patientID);
        this.date = new SimpleObjectProperty<>(date);
    }

    public Document(int id , String content, String type, LocalDate date,Integer doctorID,Integer patientID) {
        this.id = new SimpleIntegerProperty(id);
        this.content =  new SimpleStringProperty(content);
        this.type = new SimpleStringProperty( type);
        this.date = new SimpleObjectProperty<>(date);
        this.patientID = new SimpleIntegerProperty(patientID);
        this.doctorID = new SimpleIntegerProperty(doctorID);
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

    public int getDoctorID() {
        return doctorID.get();
    }

    public SimpleIntegerProperty doctorIDProperty() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID.set(doctorID);
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

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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
