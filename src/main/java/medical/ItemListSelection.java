package medical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import medical.Patient;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemListSelection implements Initializable {
    public ItemListSelection(Patient patient) {
        this.patient = patient;
    }

    Patient patient;
    @FXML
    ImageView img;
    @FXML
    public Label name;
    @FXML
    public Label id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(patient.getFirstName()+" " + patient.getLastName());
        id.setText(String.valueOf(patient.getId()));
        if (patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            img.setImage(imProfile);
        }

    }
}
