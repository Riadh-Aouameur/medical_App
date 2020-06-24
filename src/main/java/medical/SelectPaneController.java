package medical;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectPaneController implements Initializable {
    @FXML
     ListView <Patient>list;
    @FXML
    AnchorPane root;
    ObservableList <Patient> items;

    public Patient getPatientSelection() {
        return patientSelection;
    }

    Patient patientSelection;


    public SelectPaneController(ObservableList <Patient> list) {
        this.items = list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      list.setItems(items);
      list.setCellFactory(param -> new ListCell<Patient>() {
          @Override
          protected void updateItem(Patient item, boolean empty) {
              super.updateItem(item, empty);

              if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                  setText(null);
              } else {
                  setText(item.getFirstName()+" "+item.getLastName());
              }
          }
      });
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {


                    Stage stage = (Stage) root.getScene().getWindow();

                    stage.close();
                }
            }
        });



    }


}
