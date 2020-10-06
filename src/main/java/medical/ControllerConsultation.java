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
    public TextField fMaritalStatus;
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




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        fName.setText(patient.getFirstName()+" "+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");
        fPhone.setText(patient.getPhone());
        fMaritalStatus.setText(patient.getMarritalStatus());
        fProfession.setText(patient.getProfession());
        fChildren.setText(String.valueOf(patient.getChildren()));
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
        if(!(historyOfTheIllness.equals("no change")&&physicalActivity.equals("no change")&&addictions.equals("no change")&&diagnosis.equals("no change")&&treatment.equals("no change")&&reasons.equals("no change")&&clinicalExamination.equals("no change")&&resultsOfTest.equals("no change")&&diet.equals("no change")&&familyHistory.equals("no change")&&surgicalHistory.equals("no change")&&medicalHistory.equals("no change")&&allergies.equals("no change"))){
            int doctorID = Integer.parseInt(DoctorInformationSingle.getInstance(0).getDoctorID());
            Consultation consultation = new Consultation(historyOfTheIllness,physicalActivity,addictions,diagnosis,treatment,reasons,clinicalExamination,resultsOfTest,diet,LocalDate.now(),familyHistory,surgicalHistory,medicalHistory,allergies,doctorID,patient.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Are you sure to save ?");
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("");
            ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getDialogPane().getButtonTypes().add(buttonCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                Db db = new Db();
                db.InsertConsultation(consultation);
                historyOfTheIllness = "no change";
               physicalActivity= "no change";
              addictions= "no change";
                diagnosis= "no change";
                 treatment= "no change";
              reasons= "no change";
                clinicalExamination= "no change";
                resultsOfTest= "no change";
                 diet= "no change";
                familyHistory= "no change";
                 surgicalHistory= "no change";
                medicalHistory= "no change";
                 allergies= "no change";

               tHistoryOfTheIllness.clear();
                 tPhysicalActivity.clear();
                 tAddictions.clear();
               tDiagnosis.clear();
                 tTreatment.clear();
                tReasons.clear();
               tClinicalExamination.clear();
                tResultsOfTest.clear();
                tDiet.clear();
                tFamilyHistory.clear();
                tSurgicalHistory.clear();
               tMedicalHistory.clear();
               tAllergies.clear();

            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Must Fill Empty Fields");
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("");
            alert.show();

        }



    }

    public void onHistoryOfIllness(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("historyoftheillness.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerHiOfTheIll(patient);

        });

        Parent root = loader.load();
        primaryStage.setTitle("History Of The Illness");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onClinicalExamination(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("clinicalExamination.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerClinicalExamination(patient);

        });

        Parent root = loader.load();
        primaryStage.setTitle("Clinical Examination");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onMedicalRecord(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("medicalRecord.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerMedicalRecord(patient);

        });

        Parent root = loader.load();
        primaryStage.setTitle("Medical Record");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onTestResults(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("testAndResults.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerTestResults(patient);

        });

        Parent root = loader.load();
        primaryStage.setTitle("Test Results");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onDiagnosisAndTreatment(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("diagnosisAndTreatment.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerDiagnosisAndTreatment(patient);

        });

        Parent root = loader.load();
        primaryStage.setTitle("Diagnosis And Treatment");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void onLifeStyle(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lifeStyle.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerLifeStyle(patient);

        });

        Parent root = loader.load();
        primaryStage.setTitle("Life Style");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
