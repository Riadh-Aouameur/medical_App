package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPatients implements Initializable {



    public ListView <Patient>waitingList;
    Db db = new Db();

    ObservableList<Patient> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        observableList.setAll(db.getPatientData());
        waitingList.setItems(observableList);
       waitingList.setCellFactory(pp->new MyListCell_14());
        
    }

    Stage primaryStage = new Stage();;
    public void onAdd(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
        loader.setControllerFactory(e->{

            return new ControllerAdd(observableList);
        });





        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }
    Stage primaryStage4= new Stage();
     public void onDeletePatient(ActionEvent actionEvent) throws IOException {
        if(!observableList.isEmpty()){
            Patient patient= waitingList.getSelectionModel().getSelectedItem();
           waitingList.getSelectionModel().clearSelection();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ddelete.fxml"));
            loader.setControllerFactory(e->{

                return new ControllerDelete(observableList,patient);
            });





            primaryStage4.setTitle("Hello World!");
            primaryStage4.setScene(new Scene(loader.load()));
            primaryStage4.show();
        }
//

    }
    Stage primaryStage5= new Stage();
    public void onOpenModify(ActionEvent actionEvent) throws IOException {

        if(!observableList.isEmpty()){
            Patient patient= waitingList.getSelectionModel().getSelectedItem();
            waitingList.getSelectionModel().clearSelection();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modify.fxml"));
            loader.setControllerFactory(e->{

                return new ControllerModify(observableList,patient);
            });





            primaryStage5.setTitle("Hello World!");
            primaryStage5.setScene(new Scene(loader.load()));
            primaryStage5.show();
        }

    }
}
