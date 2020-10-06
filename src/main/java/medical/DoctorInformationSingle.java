package medical;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import medical.DataBase.Db;

public class DoctorInformationSingle{


    private static DoctorInformationSingle doctor = null;
 SimpleStringProperty doctorID;
   SimpleStringProperty firstName;
 SimpleStringProperty lastName;
 SimpleStringProperty birthday;
 SimpleStringProperty address;
    SimpleStringProperty emailOrPhone;
SimpleStringProperty gender;
SimpleStringProperty specialties;

    private DoctorInformationSingle(int a) {
        Db db = new Db();
        ObservableList <String>observableList = db.getDoctorData(a);


        this.firstName = new SimpleStringProperty(observableList.get(0));
        this.lastName = new SimpleStringProperty(observableList.get(1));
        this.birthday = new SimpleStringProperty(observableList.get(2));
        this.address = new SimpleStringProperty(observableList.get(6));
        this.emailOrPhone =new SimpleStringProperty( observableList.get(4));
        this.gender =new SimpleStringProperty( observableList.get(3));
        this.specialties = new SimpleStringProperty(observableList.get(5));
        this.doctorID = new SimpleStringProperty(String.valueOf(a));
        //firstName,lastName,birthday,gender,emailOrPhone,specialty,address
    }

    public synchronized static DoctorInformationSingle getInstance(int x) {

        if(doctor == null)
            doctor = new DoctorInformationSingle(x);

        return doctor;
    }

    public String getDoctorID() {
        return doctorID.get();
    }

    public void setDoctorID(String doctorID) {
        this.doctorID.set(doctorID);
    }

    public SimpleStringProperty doctorIDProperty() {
        return doctorID;
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

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getBirthday() {
        return birthday.get();
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public String getSpecialties() {
        return specialties.get();
    }

    public void setSpecialties(String specialties) {
        this.specialties.set(specialties);
    }

    public SimpleStringProperty specialtiesProperty() {
        return specialties;
    }



    public String getEmailOrPhone() {
        return emailOrPhone.get();
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone.set(emailOrPhone);

    }

    public SimpleStringProperty emailOrPhoneProperty() {
        return emailOrPhone;
    }
}
