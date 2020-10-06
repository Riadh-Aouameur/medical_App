package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class DoctorInformation {
    SimpleIntegerProperty id;
    SimpleStringProperty firstName;
    SimpleStringProperty LastName;
    SimpleObjectProperty<Object> birthday ;
    SimpleStringProperty specialty ;
    SimpleStringProperty address ;
    SimpleStringProperty emailOrPhone ;
    SimpleStringProperty pass ;
    SimpleStringProperty gender ;


    public DoctorInformation(String firstName, String lastName, LocalDate birthday, String specialty, String address, String emailOrPhone, String pass,String gender) {
        this.id = new SimpleIntegerProperty();
        this.firstName =new SimpleStringProperty( firstName);
        LastName =new SimpleStringProperty( lastName);
        this.birthday =new SimpleObjectProperty( birthday);
        this.specialty = new SimpleStringProperty(specialty);
        this.address = new SimpleStringProperty(address);
        this.emailOrPhone = new SimpleStringProperty(emailOrPhone);
        this.pass = new SimpleStringProperty(pass);

        this.gender = new SimpleStringProperty(gender);
    }
    public DoctorInformation(String firstName, String lastName, LocalDate birthday, String specialty, String address, String emailOrPhone, int id,String gender) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName =new SimpleStringProperty( firstName);
        LastName =new SimpleStringProperty( lastName);
        this.birthday =new SimpleObjectProperty( birthday);
        this.specialty = new SimpleStringProperty(specialty);
        this.address = new SimpleStringProperty(address);
        this.emailOrPhone = new SimpleStringProperty(emailOrPhone);
        this.pass = new SimpleStringProperty();
        this.gender = new SimpleStringProperty(gender);
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



    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public String getLastName() {
        return LastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName.set(lastName);
    }

    public Object getBirthday() {
        return birthday.get();
    }

    public SimpleObjectProperty<Object> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday.set(birthday);
    }

    public String getSpecialty() {
        return specialty.get();
    }

    public SimpleStringProperty specialtyProperty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty.set(specialty);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getEmailOrPhone() {
        return emailOrPhone.get();
    }

    public SimpleStringProperty emailOrPhoneProperty() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone.set(emailOrPhone);
    }

    public String getPass() {
        return pass.get();
    }

    public SimpleStringProperty passProperty() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass.set(pass);
    }
}
