package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerT1  implements Initializable {
    public Label index;
    public Label midi;
    public Label dosage;
    public Label qsp;
    public Label nb;
    int a;
    Medicament medicament;

    public ControllerT1(Medicament medicament  ,int index) {
        this.medicament = medicament;
        this.a= index;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        index.setText(a+"/ ");
        midi.setText(medicament.getNameMedicament());
        dosage.setText("dosage : "+medicament.getDosage());
        qsp.setText("QSP : "+medicament.getQsp());
        nb.setText("Number : "+medicament.getEntityNumber());

    }
}
