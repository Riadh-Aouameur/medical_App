package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class PatientForAllPatients {
    private SimpleIntegerProperty id;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleObjectProperty birthday;
    private  SimpleStringProperty gender;

    public PatientForAllPatients(Integer id, String lastName, String firstName,Object birthday, String gender) {
        this.id = new SimpleIntegerProperty(id);
        this.lastName = new SimpleStringProperty(lastName) ;
        this.firstName = new SimpleStringProperty(firstName);
        this.birthday = new SimpleObjectProperty(birthday);
        this.gender = new SimpleStringProperty(gender);

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

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public Object getBirthday() {
        return birthday.get();
    }

    public SimpleObjectProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday.set(birthday);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }



}
