package medical;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Patient {
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty children;
    private SimpleStringProperty lastName;
    private SimpleStringProperty firstName;
    private SimpleObjectProperty birthday;
    private  SimpleStringProperty gender ;
    private  SimpleStringProperty profession ;
    private  SimpleStringProperty phone ;
    private  SimpleStringProperty marritalStatus ;
    private  SimpleStringProperty status;

    public Patient(int id, String lastName, String firstName, int children, LocalDate birthday, String gender, String profession, String phone, String marritalStatus, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.children = new SimpleIntegerProperty(children);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.birthday = new SimpleObjectProperty(birthday);
       this.gender = new SimpleStringProperty(gender);
        this.profession = new SimpleStringProperty( profession);
        this.phone = new SimpleStringProperty(phone);
        this.marritalStatus = new SimpleStringProperty(marritalStatus);
        this.status = new SimpleStringProperty(status);
    }

    public Patient( String lastName, String firstName,int children, LocalDate birthday, String gender, String profession,String phone, String marritalStatus, String status) {
        this.id = new SimpleIntegerProperty(0);
        this.children = new SimpleIntegerProperty(children);
        this.lastName = new SimpleStringProperty(lastName);
        this.firstName = new SimpleStringProperty(firstName);
        this.birthday = new SimpleObjectProperty(birthday);
        this.gender = new SimpleStringProperty(gender);
        this.profession = new SimpleStringProperty( profession);
        this.phone = new SimpleStringProperty(phone);
        this.marritalStatus = new SimpleStringProperty(marritalStatus);
        this.status = new SimpleStringProperty(status);
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

    public Patient() {
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public int getChildren() {
        return children.get();
    }

    public void setChildren(int children) {
        this.children.set(children);
    }

    public SimpleIntegerProperty childrenProperty() {
        return children;
    }

    public String getProfession() {
        return profession.get();
    }

    public void setProfession(String profession) {
        this.profession.set(profession);
    }

    public SimpleStringProperty professionProperty() {
        return profession;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public String getMarritalStatus() {
        return marritalStatus.get();
    }

    public void setMarritalStatus(String marritalStatus) {
        this.marritalStatus.set(marritalStatus);
    }

    public SimpleStringProperty marritalStatusProperty() {
        return marritalStatus;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public Object getBirthday() {
        return birthday.get();
    }



    public void setBirthday(Object birthday) {
        this.birthday.set(birthday);
    }

    public SimpleObjectProperty birthdayProperty() {
        return birthday;
    }






}
