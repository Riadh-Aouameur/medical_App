package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class PatientForAppointment extends Patient
{

    SimpleStringProperty firstName;
    SimpleStringProperty lastName;
    SimpleStringProperty gender;
    SimpleStringProperty phone;
    private SimpleObjectProperty <LocalDate>dateOne;
    private SimpleObjectProperty <LocalDate>dateTwo;
    SimpleStringProperty status;
    SimpleIntegerProperty id;



    public PatientForAppointment(String firstName, String lastName, String gender, String phone, LocalDate dateOne, LocalDate dateTwo, String status) {
        this.firstName =  new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
        this.phone = new SimpleStringProperty(phone);
        this.dateOne =new SimpleObjectProperty<>( dateOne);
        this.dateTwo =  new SimpleObjectProperty<>(dateTwo);
        this.status= new SimpleStringProperty(status);
        this.id = new SimpleIntegerProperty();
    }
    public PatientForAppointment(int id, String firstName, String lastName, String gender, String phone, LocalDate dateOne, LocalDate dateTwo, String status) {
        this.firstName =  new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.gender = new SimpleStringProperty(gender);
        this.phone = new SimpleStringProperty(phone);
        this.dateOne =new SimpleObjectProperty<>( dateOne);
        this.dateTwo =  new SimpleObjectProperty<>(dateTwo);
        this.status= new SimpleStringProperty(status);
        this.id = new SimpleIntegerProperty(id);
    }

    @Override
    public String getFirstName() {
        return firstName.get();
    }

    @Override
    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    @Override
    public String getLastName() {
        return lastName.get();
    }

    @Override
    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    @Override
    public String getGender() {
        return gender.get();
    }

    @Override
    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    @Override
    public String getPhone() {
        return phone.get();
    }

    @Override
    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
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

    public LocalDate getDateOne() {
        return dateOne.get();
    }

    public SimpleObjectProperty<LocalDate> dateOneProperty() {
        return dateOne;
    }

    public void setDateOne(LocalDate dateOne) {
        this.dateOne.set(dateOne);
    }

    public LocalDate getDateTwo() {
        return dateTwo.get();
    }

    public SimpleObjectProperty<LocalDate> dateTwoProperty() {
        return dateTwo;
    }

    public void setDateTwo(LocalDate dateTwo) {
        this.dateTwo.set(dateTwo);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
