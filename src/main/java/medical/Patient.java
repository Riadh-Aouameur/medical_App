package medical;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Patient {
    private SimpleIntegerProperty id;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleObjectProperty birthday;
    private  SimpleStringProperty gender;
    public Patient() {
        this.id =new SimpleIntegerProperty(-1) ;
        this.lastName = new SimpleStringProperty("demo") ;
        this.firstName = new SimpleStringProperty("demo");
        this.birthday = new SimpleObjectProperty(LocalDate.of(2000,01,01));
        this.gender = new SimpleStringProperty("demo");
    }


    public Patient(int id, String lastName, String firstName, LocalDate birthday, String gender) {
        this.id =new SimpleIntegerProperty(id) ;
        this.lastName = new SimpleStringProperty(lastName) ;
        this.firstName = new SimpleStringProperty(firstName);
        this.birthday = new SimpleObjectProperty(birthday);
        this.gender = new SimpleStringProperty(gender);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setBirthday(Object birthday) {
        this.birthday.set(birthday);
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public Object getBirthday() {
        return birthday.get();
    }

    public SimpleObjectProperty birthdayProperty() {
        return birthday;
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }




}
