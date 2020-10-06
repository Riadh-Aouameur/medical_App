package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerItemSearch implements Initializable {

    public Label tPatient;
    public Label tPhone;


    public ImageView img;
    public AnchorPane root;
    public Label tBirthday;
    public Label tId;
    Patient patient;

    public ControllerItemSearch(Patient patientForWaitingRoom) {
        this.patient = patientForWaitingRoom;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (patient.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            img.setImage(imProfile);
        }
        tPatient.setText("Patient : "+patient.getFirstName()+" "+patient.getLastName());
        tPhone.setText("Phone : "+patient.getPhone());
        tBirthday.setText("Birthday : "+patient.getBirthday());
        tId.setText("ID : "+patient.getId());



    }
}
