package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import medical.DataBase.Db;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ControllerH3 implements Initializable {

    public Label t1;
    public Label t2;
    public Label t3;
    public Label t4;
    public Label i1;
    public Label i2;
    public Label i3;
    public Label i4;

    public TextArea content;
    public Label type;
  Checkup checkup;

    public ControllerH3(Checkup checkup) {
        this.checkup = checkup;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        Db db = new Db() ;
        DoctorInformation doctorInformation = db.getDoctor(checkup.getDoctorID());
        t1.setText("Dr."+doctorInformation.getFirstName()+" "+doctorInformation.getLastName());
        t2.setText(doctorInformation.getSpecialty().toUpperCase());
        t3.setText("Address : "+doctorInformation.getAddress());
        t4.setText("Phone : "+doctorInformation.getEmailOrPhone());
        Patient patient = db.getPatient(checkup.getPatientID());
        i1.setText("Date : "+ checkup.getDate().toString());
        i2.setText("ID : "+patient.getId());
        i3.setText("Patient : "+patient.getFirstName()+" "+patient.getLastName());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        i4.setText("Age : "+i);
        type.setText("MEDICAL TESTS");
        content.setText(checkup.getContent());










    }
}
