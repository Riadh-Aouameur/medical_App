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

public class ControllerAddCheckup implements Initializable {
    public ListView <CheckupName>list;
    public TextField f1;
    String t1;

    Db db =new Db();
    ObservableList<CheckupName> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(observableList);
        observableList.setAll(db.getCheckupName());

    }

    public void onAdd(ActionEvent actionEvent) {
        if (!(f1.getText().isEmpty())){
            t1= f1.getText();
        }

        if(t1 != null){
             CheckupName checkupName = new CheckupName(t1);
             checkupName.setId(db.InsertCheckup(checkupName));
             observableList.add(checkupName);
        }


    }
}
