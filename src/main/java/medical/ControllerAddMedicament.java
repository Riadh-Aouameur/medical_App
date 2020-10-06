package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAddMedicament  implements Initializable {
    public ListView <MedicamentName>list;
    public TextField f1;
    public TextField f2;
    public AnchorPane root;
    String t1;
    String t2;
    Db db =new Db();
    private  double x;
    private  double y;
    ObservableList<MedicamentName> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(e->{
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX()-x);
            stage.setY(e.getScreenY()-y);
        });
        list.setItems(observableList);
        observableList.setAll(db.getMedi());
        list.setCellFactory(param -> new MyListCell_20());

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
             f1.clear();
             f2.clear();
        }


    }

    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    public void onDelete(ActionEvent actionEvent) {
       MedicamentName medicamentName=  list.getSelectionModel().getSelectedItem();
       if(medicamentName!=null){
           db.deleteMedi(medicamentName.getId());
       }
            list.getItems().remove(medicamentName);
      list.getSelectionModel().clearSelection();


    }
}
