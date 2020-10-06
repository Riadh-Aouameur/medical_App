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

public class ControllerAddCheckup implements Initializable {
    public ListView <CheckupName>list;
    public TextField f1;
    public AnchorPane root;
    String t1;
    private double x;
    private double y;

    Db db =new Db();
    ObservableList<CheckupName> observableList = FXCollections.observableArrayList();

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
        observableList.setAll(db.getCheckupName());
        list.setCellFactory(param -> new MyListCell_21());

    }

    public void onAdd(ActionEvent actionEvent) {
        if (!(f1.getText().isEmpty())){
            t1= f1.getText();
        }

        if(t1 != null){
             CheckupName checkupName = new CheckupName(t1);
             checkupName.setId(db.InsertCheckup(checkupName));
             observableList.add(checkupName);
             f1.clear();
        }


    }

    public void onDelete(ActionEvent actionEvent) {
        CheckupName checkupName=  list.getSelectionModel().getSelectedItem();
        if(checkupName!=null){
            db.deleteCheckup(checkupName.getId());
        }
        list.getItems().remove(checkupName);
        list.getSelectionModel().clearSelection();

    }

    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

}
