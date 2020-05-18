package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

 AnchorPane root;
 Medicament medicament;

 public MedicamentController(Medicament medicament){
this.medicament = medicament;

 }

    public void onDelete(ActionEvent actionEvent) {
        ((VBox) root.getParent()).getChildren().remove(root);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l1.setText(medicament.getNameMedicament());
        l3.setText("QSP : "+medicament.getQsp());
        l2.setText("Dosage : "+medicament.getDosage());

    }
}
