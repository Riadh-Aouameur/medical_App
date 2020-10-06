package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHistoryConsultation implements Initializable {
    Patient patient;
    public AnchorPane root;
    private double x;
    private double y;

    public ControllerHistoryConsultation(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(e->{
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX()-x);
            stage.setY(e.getScreenY()-y);
        });

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
    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();

    }

}
