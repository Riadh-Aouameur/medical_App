package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLifeStyle implements Initializable {



    public TextArea text1;
    public TextArea text2;

    public TextArea text4;
    public AnchorPane r1;
    public AnchorPane r2;
    Patient patient;

    public ControllerLifeStyle(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Db db = new Db();
        ObservableList <String> observableList = FXCollections.observableArrayList(db.getPhysicalActivity(patient.getId()));

        if(observableList.isEmpty()){
            text1.setText("no change");
        }else {
            StringBuilder s = new StringBuilder();
            for (int i =0 ; i<observableList.size();i++){
                s.append("Consultation ").append(i+1).append("\n").append(observableList.get(i)).append("\n");

            }
            text1.setText(s.toString());
        }

        ObservableList <String> observableList4 = FXCollections.observableArrayList(db.getAllergies(patient.getId()));

        if(observableList4.isEmpty()){
            text4.setText("no change");
        }else {
            StringBuilder s = new StringBuilder();
            for (int i =0 ; i<observableList4.size();i++){
                s.append("Consultation ").append(i+1).append("\n").append(observableList4.get(i)).append("\n");

            }
            text4.setText(s.toString());
        }

        ObservableList <String> observableList2 = FXCollections.observableArrayList(db.getDiet(patient.getId()));

        if(observableList2.isEmpty()){
            text2.setText("no change");
        }else {
            StringBuilder s = new StringBuilder();
            for (int i =0 ; i<observableList2.size();i++){
                s.append("Consultation ").append(i+1).append("\n").append(observableList2.get(i)).append("\n");

            }
            text2.setText(s.toString());
        }


    }

    public void onSetPane(ActionEvent actionEvent) {
            r1.toFront();
    }
    public void onSetPane1(ActionEvent actionEvent) {
            r2.toFront();
    }
}
