package Medical;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowInformation implements Initializable {
    @FXML
   TextField textFirstLastName ;
    @FXML
   TextField textId ;
    @FXML
   TextField textAge;
    @FXML
   TextField textGender;
    @FXML
   TextField textSocial;
    @FXML
   TextField textJob;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    textFirstLastName.setText(Patients.listPatient.get(0).getFirstName()+" "+Patients.listPatient.get(0).getLastName());
    textAge.setText(Patients.listPatient.get(0).getBirthday().toString());
    textGender.setText(Patients.listPatient.get(0).getGender());
    textId.setText(String.valueOf(Patients.listPatient.get(0).getId()));
    textJob.setText("teacher");
    textSocial.setText("marred");
    }













}
