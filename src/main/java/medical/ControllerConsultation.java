package medical;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import medical.DataBase.Db;
import org.controlsfx.control.textfield.AutoCompletionBinding;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ControllerConsultation implements Initializable {
    public TextField fChildren;
    public ComboBox <String> fMaritalStatus;
    public TextField fProfession;
    public TextArea tHistoryOfTheIllness;
    public TextArea tPhysicalActivity;
    public TextArea tAddictions;
    public TextArea tDiagnosis;
    public TextArea tTreatment;
    public TextArea tReasons;
    public TextArea tClinicalExamination;
    public TextArea tResultsOfTest;
    public TextArea tDiet;
    public String historyOfTheIllness = "no change";
    public String physicalActivity= "no change";
    public String addictions= "no change";
    public String diagnosis= "no change";
    public String treatment= "no change";
    public String reasons= "no change";
    public String clinicalExamination= "no change";
    public String resultsOfTest= "no change";
    public String diet= "no change";
    public String familyHistory= "no change";
    public String surgicalHistory= "no change";
    public String medicalHistory= "no change";
    public String allergies= "no change";

    public TextArea tFamilyHistory;
    public TextArea tSurgicalHistory;
    public TextArea tMedicalHistory;
    public TextArea tAllergies;

    @FXML
    ListView <Parameters>list;
    @FXML
    ImageView imgeGander;
    @FXML
    TextField fBirthday;
    @FXML
    TextField fPhone;
    @FXML
    TextField fAge;
    @FXML
    TextField fDate;
    ObservableList <Parameters> observableList;
    @FXML
    TextField fName;
    Patient patient;
    Set<String> possibleWordSet= new HashSet<>();
    private AutoCompletionBinding<String> autoCompletionBinding;

    public ControllerConsultation(Patient patient)
    {

        this.patient = patient;


    }
    public ControllerConsultation(PatientForAllPatients patient, Boolean test)
    {
        this.patient = new Patient();
        this.patient.setId(patient.getId());
        this.patient.setFirstName(patient.getFirstName());
        this.patient.setLastName(patient.getLastName());
        this.patient.setGender(patient.getGender());
        this.patient.setBirthday(patient.getBirthday());




    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        fName.setText(patient.getFirstName()+"\t"+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");

        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fDate.setText(formatter.format(LocalDate.now()));
        






    }

    public void onSave(ActionEvent actionEvent) {
        if (!(tHistoryOfTheIllness.getText().isEmpty())){
            historyOfTheIllness= tHistoryOfTheIllness.getText();
        }
        if (!(tDiet.getText().isEmpty())){
            diet= tDiet.getText();
        }
        if (!(tPhysicalActivity.getText().isEmpty())){
            physicalActivity= tPhysicalActivity.getText();
        }
        if (!(tAddictions.getText().isEmpty())){
            addictions= tAddictions.getText();
        }
        if (!(tReasons.getText().isEmpty())){
            reasons = tReasons.getText();
        }
        if (!(tClinicalExamination.getText().isEmpty())){
            clinicalExamination= tClinicalExamination.getText();
        }
        if (!(tDiagnosis.getText().isEmpty())){
            diagnosis= tDiagnosis.getText();
        }
        if (!(tTreatment.getText().isEmpty())){
            treatment= tTreatment.getText();
        }
        if (!(tResultsOfTest.getText().isEmpty())){
            resultsOfTest= tResultsOfTest.getText();
        }
        if (!(tAllergies.getText().isEmpty())){
            allergies= tAllergies.getText();
        }
        if (!(tFamilyHistory.getText().isEmpty())){
            familyHistory= tFamilyHistory.getText();
        }
        if (!(tSurgicalHistory.getText().isEmpty())){
            surgicalHistory= tSurgicalHistory.getText();
        }
        if (!(tMedicalHistory.getText().isEmpty())){
            medicalHistory= tMedicalHistory.getText();
        }

        Consultation consultation = new Consultation(historyOfTheIllness,physicalActivity,addictions,diagnosis,treatment,reasons,clinicalExamination,resultsOfTest,diet,LocalDate.now(),familyHistory,surgicalHistory,medicalHistory,allergies);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("");
        alert.setTitle("");
        alert.setHeaderText("");

        ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(buttonCancel);
        Optional <ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            Db db = new Db();
            db.InsertConsultation(consultation,patient.getId());
            System.out.println("save");

            //TODO database
        }
        System.out.println("NOT save");

    }

    public void onHistoryOfIllness(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("historyoftheillness.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
