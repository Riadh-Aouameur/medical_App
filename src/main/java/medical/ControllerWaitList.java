package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerWaitList implements Initializable {

    public Label tPatient;
    public Label tPhone;
    public Label tNb;
    public ImageView iStatus;
    public ImageView img;
    public AnchorPane root;
    APatientForWaitingRoom patientForWaitingRoom;

    public ControllerWaitList(APatientForWaitingRoom patientForWaitingRoom) {
        this.patientForWaitingRoom = patientForWaitingRoom;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (patientForWaitingRoom.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            img.setImage(imProfile);
        }
        if (patientForWaitingRoom.getStatus().equals("Waiting")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/dot2.png"));
            iStatus.setImage(imProfile);
        }else if (patientForWaitingRoom.getStatus().equals("Consult")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/dot3.png"));
            iStatus.setImage(imProfile);
        }else {
            Image imProfile = new Image(getClass().getResourceAsStream("img/dot.png"));
            iStatus.setImage(imProfile);
        }


        tPatient.setText("Patient : "+patientForWaitingRoom.getFirstName()+" "+patientForWaitingRoom.getLastName());
        tPhone.setText("Phone : "+patientForWaitingRoom.getPhone());
        tNb.setText("Number : "+String.valueOf(patientForWaitingRoom.getNumber()));


    }
}
