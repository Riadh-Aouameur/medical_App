package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerItemOld implements Initializable {
    public ImageView img1;
    public Label id;
    public Label iPatient;
    public Label birthday;
    public Label marritalStatus;
    public Label profession;
    public Label phone;
    Patient patient;

    public ControllerItemOld(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (patient.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            img1.setImage(imProfile);
        }


        iPatient.setText("Patient : "+patient.getFirstName()+" "+patient.getLastName());

        phone.setText("Phone : "+patient.getPhone());
        id.setText("ID : "+patient.getId());
        marritalStatus.setText("Marrital Status : "+patient.getMarritalStatus());
        profession.setText("Profession : "+patient.getProfession());
        birthday.setText("Birthday : "+patient.getBirthday().toString());
    }
}
