package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAddMedicament  implements Initializable {
    public ListView <MedicamentName>list;
    public TextField f1;
    public TextField f2;
    String t1;
    String t2;
    Db db =new Db();
    ObservableList<MedicamentName> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(observableList);
        observableList.setAll(db.getMedi());

    }

    public void onAdd(ActionEvent actionEvent) {
        if (!(f1.getText().isEmpty())){
            t1= f1.getText();
        }
        if (!(f2.getText().isEmpty())){
            t2= f2.getText();
        }
        if(t2 != null && t1 != null){
             MedicamentName medicamentName = new MedicamentName(t1,t2);
             medicamentName.setId(db.InsertMedi(medicamentName));
             observableList.add(medicamentName);
        }


    }
}
