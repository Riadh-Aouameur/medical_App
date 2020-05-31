package medical;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Checkup implements Initializable {

    @FXML
    ListView <checkupName>list_1;
    @FXML
    ListView list_2;
    @FXML
    TextField searchField;
    ObservableList<checkupName> observableList ;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableList =FXCollections.observableArrayList(new checkupName("fns"),new checkupName("uree"),new checkupName("Creatinine"),new checkupName("asat"),new checkupName("Alat"),new checkupName("crp"),new checkupName("Vs"),new checkupName("cholesterol"),new checkupName("Triglyceride"));
        list_1.setItems(observableList);
        list_1.setCellFactory(param -> new ListCell<checkupName>() {

            @Override
            protected void updateItem(checkupName item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null ) {
                    setGraphic(null);
                } else {
                    Label label =new Label(item.getName()+" ");
                    label.setStyle("-fx-text-fill: #000;");
                    CheckBox checkBox= new CheckBox();
                    checkBox.setOnAction(e->{
                        if (item.isChecked()){
                            item.setChecked(false);
                        }else {
                            item.setChecked(true);
                        }

                    });
                    HBox hBox =new HBox();
                    hBox.getChildren().addAll(label,checkBox);
                    setGraphic(hBox);
                }
                setText("");

            }

        });
//        list_1.setCellFactory(CheckBoxListCell.forListView(new Callback<checkupName, ObservableValue<Boolean>>() {
//
//
//            @Override
//            public ObservableValue<Boolean> call(checkupName item) {
//                BooleanProperty observable = new SimpleBooleanProperty();
//                observable.addListener((obs, wasSelected, isNowSelected) ->
//                        System.out.println("Check box for "+item.getName()+" changed from "+wasSelected+" to "+isNowSelected)
//                );
//                return observable ;
//            }
//        }));
    }

    public void onAddToList2(ActionEvent actionEvent) {
        int i=0;
          while(list_1.getItems().get(i)!=null){
              System.out.println( list_1.getItems().get(i).isChecked());
              i++;
          }
        System.out.println("is null");

    }

    public void onCheckup(ActionEvent actionEvent) {
    }

    public void onPrint(ActionEvent actionEvent) {
    }
}
