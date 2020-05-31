package medical;

import javafx.beans.property.SimpleStringProperty;

public class DoctorInformationSingle{

   SimpleStringProperty firstName;
 SimpleStringProperty lastName;
 SimpleStringProperty birthday;
 SimpleStringProperty phone;
 SimpleStringProperty address;
SimpleStringProperty email;
SimpleStringProperty gender;
SimpleStringProperty specialties;
  SimpleStringProperty  idOfApproval;


  DoctorInformationSingle(String firstName, String lastName, String birthday, String phone, String address, String email,String gender, String specialties, String idOfApproval) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.birthday = new SimpleStringProperty(birthday);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.email =new SimpleStringProperty( email);
        this.gender =new SimpleStringProperty( gender);
        this.specialties = new SimpleStringProperty(specialties);
        this.idOfApproval = new SimpleStringProperty(idOfApproval);
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
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
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

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
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

    public String getSpecialties() {
        return specialties.get();
    }

    public SimpleStringProperty specialtiesProperty() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties.set(specialties);
    }

    public String getIdOfApproval() {
        return idOfApproval.get();
    }

    public SimpleStringProperty idOfApprovalProperty() {
        return idOfApproval;
    }

    public void setIdOfApproval(String idOfApproval) {
        this.idOfApproval.set(idOfApproval);
    }
}
