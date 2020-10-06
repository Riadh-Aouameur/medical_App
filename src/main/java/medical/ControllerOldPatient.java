package medical;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOldPatient implements Initializable {
    public ListView <Patient> list;
    public AnchorPane anchorPaneRoot;
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

    public void onNewPatient(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("createPatient.fxml"));

        loader.setControllerFactory(e->{


            return new newPatient();

        });

        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Stage stage = (Stage) anchorPaneRoot.getScene().getWindow();
        stage.close();

    }
}
