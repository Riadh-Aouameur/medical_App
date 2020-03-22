package Medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class PatientForAppointement {


    SimpleIntegerProperty id;
    SimpleStringProperty lastName;
    SimpleStringProperty firstName;
    SimpleObjectProperty appointmentdate;
    SimpleObjectProperty todaydate;
    public PatientForAppointement(int id , String firstName , String lastName, LocalDate appointmentdate, LocalDate todaydate) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName =new  SimpleStringProperty(firstName);
        this.lastName =new SimpleStringProperty(lastName);
        this.appointmentdate = new SimpleObjectProperty(appointmentdate);
        this.todaydate = new SimpleObjectProperty(todaydate);
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

    public void setAppointmentdate(Object appointmentdate) {
        this.appointmentdate.set(appointmentdate);
    }

    public void setTodaydate(Object todaydate) {
        this.todaydate.set(todaydate);
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

    public Object getAppointmentdate() {
        return appointmentdate.get();
    }

    public SimpleObjectProperty appointmentdateProperty() {
        return appointmentdate;
    }

    public Object getTodaydate() {
        return todaydate.get();
    }

    public SimpleObjectProperty todaydateProperty() {
        return todaydate;
    }
}
