package Medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkPage  implements Initializable {
    @FXML
    Tab homeTab;
    @FXML
    TabPane tabpane;

    Tab newPatient = new Tab();
    Tab consultation = new Tab();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newPatient.setText("New Patient");
        consultation.setText("Consultation");




     }


    public void onCreateNewPatient(ActionEvent actionEvent) {




     tabpane.getTabs().add(newPatient);
     tabpane.getSelectionModel().select(newPatient);


    }

    public void onMakeConsultation(ActionEvent actionEvent) {
        tabpane.getTabs().add(consultation);
        tabpane.getSelectionModel().select(consultation);

    }
}
