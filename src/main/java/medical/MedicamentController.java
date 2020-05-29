package medical;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class MedicamentController implements Initializable {
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;
    @FXML
   Button btn;
 AnchorPane root;

 Medicament medicament;

 public MedicamentController(Medicament medicament){
this.medicament = medicament;


 }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l1.setText(medicament.getNameMedicament());
        l3.setText("QSP : "+medicament.getQsp());
        l2.setText("Dosage : "+medicament.getDosage());

    }



}
