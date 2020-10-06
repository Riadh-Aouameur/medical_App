package medical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerMedicament implements Initializable {
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;
    @FXML
    Label l4;

 AnchorPane root;

 Medicament medicament;

 public ControllerMedicament(Medicament medicament){
this.medicament = medicament;


 }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l1.setText(medicament.getNameMedicament());
        l3.setText("QSP : "+medicament.getQsp());
        l4.setText("Number : "+medicament.getEntityNumber());
        l2.setText("Dosage : "+medicament.getDosage());

    }



}
