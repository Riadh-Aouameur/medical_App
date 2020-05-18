package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PatientForWattingRoom {
    SimpleIntegerProperty id;
    SimpleIntegerProperty nb;
    SimpleStringProperty firstName;
    SimpleStringProperty lastName;
    SimpleStringProperty gender;
    SimpleStringProperty etat;
    SimpleStringProperty rndv;

    public PatientForWattingRoom() {
    }

    public void setNb(int nb) {
        this.nb.set(nb);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public void setEtat(String etat) {
        this.etat.set(etat);
    }

    public void setRndv(String rndv) {
        this.rndv.set(rndv);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public int getNb() {
        return nb.get();
    }

    public SimpleIntegerProperty nbProperty() {
        return nb;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public String getEtat() {
        return etat.get();
    }

    public SimpleStringProperty etatProperty() {
        return etat;
    }

    public String getRndv() {
        return rndv.get();
    }

    public SimpleStringProperty rndvProperty() {
        return rndv;
    }

    public PatientForWattingRoom(Integer id, Integer nb, String firstName, String lastName, String gender , String etat, String rndv) {
        this.id = new SimpleIntegerProperty(id);
        this.nb =new SimpleIntegerProperty(nb);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName =  new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
        this.etat = new SimpleStringProperty(etat);
        this.rndv = new SimpleStringProperty(rndv);


    }


}
