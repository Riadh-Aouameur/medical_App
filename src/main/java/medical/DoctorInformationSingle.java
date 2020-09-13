package medical;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import medical.DataBase.Db;

public class DoctorInformationSingle{


 SimpleStringProperty doctorID;
   SimpleStringProperty firstName;
 SimpleStringProperty lastName;
 SimpleStringProperty birthday;

 SimpleStringProperty address;

    public String getDoctorID() {
        return doctorID.get();
    }

    public SimpleStringProperty doctorIDProperty() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID.set(doctorID);
    }


    SimpleStringProperty emailOrPhone;
SimpleStringProperty gender;
SimpleStringProperty specialties;
  SimpleStringProperty  idOfApproval;


    private DoctorInformationSingle(int a) {
        Db db = new Db();
        ObservableList <String>observableList = db.getDoctorData(a);


        this.firstName = new SimpleStringProperty(observableList.get(0));
        this.lastName = new SimpleStringProperty(observableList.get(1));
        this.birthday = new SimpleStringProperty(observableList.get(2));
        this.address = new SimpleStringProperty(observableList.get(7));
        this.emailOrPhone =new SimpleStringProperty( observableList.get(5));
        this.gender =new SimpleStringProperty( observableList.get(3));
        this.specialties = new SimpleStringProperty(observableList.get(6));
        this.idOfApproval = new SimpleStringProperty(observableList.get(4));
        this.doctorID = new SimpleStringProperty(String.valueOf(a));
    }
    private static DoctorInformationSingle doctor = null;

    public synchronized static DoctorInformationSingle getInstance(int x) {

        if(doctor == null)
            doctor = new DoctorInformationSingle(x);

        return doctor;
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



    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
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
    public String getEmailOrPhone() {
        return emailOrPhone.get();
    }

    public SimpleStringProperty emailOrPhoneProperty() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone.set(emailOrPhone);

    }
}
