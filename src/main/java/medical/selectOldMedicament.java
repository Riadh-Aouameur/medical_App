package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class selectOldMedicament implements Initializable {
    @FXML
    TextField search;
    @FXML
    ListView <Medicament>list;

    ObservableList<Medicament> observableList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
     observableList = FXCollections.observableArrayList(new Medicament("assprin","2562",6,"gftf"));
     list.setItems(observableList);
    }

    public void onSet(ActionEvent actionEvent) {

    }

    public void onCancel(ActionEvent actionEvent) {

    }

}
