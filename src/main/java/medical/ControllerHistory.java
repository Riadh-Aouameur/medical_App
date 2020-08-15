package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import medical.DataBase.Db;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ControllerHistory implements Initializable {
    public Label fName;
    public Label fAge;
    @FXML
  ListView <Prescription>list_1;
    @FXML
    ListView <Prescription>list_2;
    @FXML
    ObservableList <Prescription>observableList1;
    ObservableList <Prescription>observableList2;

    @FXML
    ImageView imgeGander;
    Patient patient;
    public ControllerHistory(Patient patient)
    { this.patient = patient; }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Db db = new Db();
        System.out.println(patient.getId());

        if(patient.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }

        fName.setText(patient.getFirstName()+" "+patient.getLastName());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");

        observableList2 = FXCollections.observableArrayList();
        observableList1 = FXCollections.observableArrayList();
        observableList2.setAll(db.getPatientDaa(patient.getId()));
        observableList1.setAll(db.getPatientDaa(patient.getId()));
        list_1.setCellFactory(l->new MyListCell_7());
        list_2.setCellFactory(l->new MyListCell_8());
                list_1.setItems(observableList1);
                list_2.setItems(observableList2);

    }

    public void onAdd(ActionEvent actionEvent) {
    }
}
