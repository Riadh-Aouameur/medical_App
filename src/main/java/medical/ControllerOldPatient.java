package medical;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOldPatient implements Initializable {
    public ListView <Patient> list;
    ObservableList<Patient> observableList ;

    public ControllerOldPatient(ObservableList<Patient> observableList) {
        this.observableList = observableList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(observableList);
        list.setCellFactory(param -> new MyListCell_15());
    }

    public void onSelect(ActionEvent actionEvent) {
        Patient p =list.getSelectionModel().getSelectedItem();
        if(p!=null){
            listPatient.observableList.add(p);
        }

    }

}
