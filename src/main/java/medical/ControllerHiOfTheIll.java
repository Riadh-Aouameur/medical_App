package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHiOfTheIll implements Initializable {


    public TextArea text;
    Patient patient;

    public ControllerHiOfTheIll(Patient patient) {
        this.patient = patient;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Db db = new Db();
        ObservableList <String> observableList = FXCollections.observableArrayList(db.getHistoryOfThell(patient.getId()));

        if(observableList.isEmpty()){
            text.setText("no change");
        }else {
            StringBuilder s = new StringBuilder();
            for (int i =0 ; i<observableList.size();i++){
                s.append("Consultation ").append(i+1).append("\n").append(observableList.get(i)).append("\n");

            }
            text.setText(s.toString());
        }


    }
}
