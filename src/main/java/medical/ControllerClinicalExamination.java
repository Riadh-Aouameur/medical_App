package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerClinicalExamination implements Initializable {


    public TextArea text;
    public TextArea text2;
    Patient patient;

    public ControllerClinicalExamination(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Db db = new Db();
        ObservableList <String> observableList = FXCollections.observableArrayList(db.getHistoryOfReasons(patient.getId()));

        if(observableList.isEmpty()){
            text.setText("no change");
        }else {
            StringBuilder s = new StringBuilder();
            for (int i =0 ; i<observableList.size();i++){
                s.append("Consultation ").append(i+1).append("\n").append(observableList.get(i)).append("\n");

            }
            text.setText(s.toString());
        }

        ObservableList <String> observableList2 = FXCollections.observableArrayList(db.getClinicalExamination(patient.getId()));

        if(observableList2.isEmpty()){
            text2.setText("no change");
        }else {
            StringBuilder s = new StringBuilder();
            for (int i =0 ; i<observableList.size();i++){
                s.append("Consultation ").append(i+1).append("\n").append(observableList2.get(i)).append("\n");

            }
            text2.setText(s.toString());
        }


    }
}
