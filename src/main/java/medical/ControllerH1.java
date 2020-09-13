package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerH1 implements Initializable {

    public Label t1;
    public Label t2;
    public Label t3;
    public Label t4;
    public Label i1;
    public Label i2;
    public Label i3;
    public Label i4;
    public ListView <Medicament> list;
    ObservableList <Medicament>observableList;
    Prescription prescription;
    public ControllerH1( Prescription prescription) {
        this.prescription =  prescription;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableList = FXCollections.observableArrayList();
        observableList.addAll(prescription.getObservableList());
        list.setItems(observableList);
        list.setCellFactory(p->new MyListCell_10());
        Db db = new Db() ;
        DoctorInformation doctorInformation = db.getDoctor(prescription.getDoctorID());
        t1.setText(doctorInformation.getFirstName());









    }
}
