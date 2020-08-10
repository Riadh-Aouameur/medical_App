package medical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import medical.Patient;
import medical.Prescription;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.ResourceBundle;

public class  ControllerShowPrescription  implements Initializable {

    @FXML
    VBox vbox;
    @FXML TextField fpatient;
    @FXML TextField fPhone;
    @FXML TextField fAge;
    @FXML TextField fPrescriptionId;
    @FXML TextField fdate;
    Patient patient;
    Prescription prescription;

    public ControllerShowPrescription(Patient patient, Prescription prescription) {
        this.patient = patient;
        this.prescription = prescription;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fPrescriptionId.setText(String.valueOf(prescription.getId()));
        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fdate.setText(formatter.format((TemporalAccessor) prescription.getDate()));




    }
}
