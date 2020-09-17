package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerListItemPatients implements Initializable {

    public ImageView img;
    public Label id;
    public Label firstName;
    public Label lastName;

    public Label phone;
    public ImageView img1;
    public ImageView img2;
   
    public Label birthday;
    public Label marritalStatus;
    public Label profession;
    Patient patient;

    public ControllerListItemPatients(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (patient.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            img1.setImage(imProfile);
        }
        if (patient.getStatus().equals("Active")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/dot2.png"));
            img2.setImage(imProfile);
        }

        firstName.setText(patient.getFirstName());
        lastName.setText(patient.getLastName());
        phone.setText(patient.getPhone());
        id.setText(String.valueOf(patient.getId()));
        marritalStatus.setText(patient.getMarritalStatus());
        profession.setText(patient.getProfession());
        birthday.setText(patient.getBirthday().toString());



    }
}
