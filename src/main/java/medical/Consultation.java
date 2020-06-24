package medical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Consultation  implements Initializable {
    @FXML
    ImageView imgeGander;
    @FXML
    TextField fBirthday;
    @FXML
    TextField fPhone;
    @FXML
    TextField fAge;
    @FXML
    TextField fDate;
    @FXML
    TextField fName;
    Patient patient;

    public Consultation(Patient patient)
    {

        this.patient = patient;


    }
    public Consultation(PatientForAllPatients patient,Boolean test)
    {
        this.patient = new Patient();

        this.patient.setId(patient.getId());
        this.patient.setFirstName(patient.getFirstName());
        this.patient.setLastName(patient.getLastName());
        this.patient.setGender(patient.getGender());
        this.patient.setBirthday(patient.getBirthday());


    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        fName.setText(patient.getFirstName()+"\t"+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");










        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fDate.setText(formatter.format(LocalDate.now()));

    }
}
