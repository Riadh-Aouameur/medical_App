package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerHistory implements Initializable {
  @FXML
  ListView <InformationForHistoryList>list_1;
    @FXML
    ListView <Object>list_2;
    @FXML
    ObservableList <InformationForHistoryList>observableList1;
    ObservableList <Object>observableList2;

    @FXML
    ImageView imgeGander;
    Patient patient;
    public ControllerHistory(Patient patient)
    { this.patient = patient; }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        observableList1 = FXCollections.observableArrayList(new InformationForHistoryList(16,"Prescription", LocalDate.of(1999,1,19))
                ,new InformationForHistoryList(16,"Prescription", LocalDate.of(1999,2,19))
                ,new InformationForHistoryList(16,"Prescription", LocalDate.of(1999,3,19)));

        observableList2 = FXCollections.observableArrayList();
        list_1.setCellFactory(l->new MyListCell_7());
                list_1.setItems(observableList1);
                list_2.setItems(observableList2);

    }

    public void onAdd(ActionEvent actionEvent) {
    }
}
