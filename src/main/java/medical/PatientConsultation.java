package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

public class PatientConsultation implements Initializable {
    @FXML
    TextField textFirstLastName ;
    @FXML
    TextField textId ;
    @FXML
    TextField textAge;
    @FXML
    TextField textGender;
    @FXML
    TextField textSocial;
    @FXML
    TextField textJob;
//---------------------------------------------------------------------------------------------
    @FXML
    TextArea textDosage ;
    @FXML
    TextArea textQsp ;
    @FXML
    TextArea textMedi;
    @FXML
    TextField textEntityNumber  ;
    @FXML
    Label date;



    @FXML
    VBox vBox;
    @FXML
    AnchorPane paneLIstOFMedicament;


    Patient patient;

    public PatientConsultation(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFirstLastName.setText(patient.getFirstName()+" "+patient.getLastName());
        textAge.setText(patient.getBirthday().toString());
        textGender.setText(patient.getGender());
        textId.setText(String.valueOf(patient.getId()));
        textJob.setText("teacher");
        textSocial.setText("marred");


        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        date.setText(formatter.format(LocalDate.now()));
        //--------------------------------------------------------------






    }

    public void onAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("midicament.fxml"));

        loader.setControllerFactory(c -> {

            Medicament medicament = new Medicament(textMedi.getText(),textDosage.getText(),Integer.parseInt(textEntityNumber.getText()),textQsp.getText());

            return new MedicamentController(medicament);
        });

        AnchorPane anchorPane = loader.load();
        vBox.getChildren().add(anchorPane);
    }

    public void onModify(ActionEvent actionEvent) {
    }

    public void onSave(ActionEvent actionEvent) {
    }

    public void onPrinted(ActionEvent actionEvent) {
    }

    public void onClicked(MouseEvent mouseEvent) {
        if(paneLIstOFMedicament.isVisible())
             paneLIstOFMedicament.setVisible(false);
        else
            paneLIstOFMedicament.setVisible(true);
    }

    public void onSelectOld(ActionEvent actionEvent) {

    }
}
