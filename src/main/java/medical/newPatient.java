package medical;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;






public class newPatient implements Initializable {

    @FXML
    TextField firstName ;
    @FXML
    TextField lastName;
    @FXML
    TextField placeOfBirth ;
    @FXML
    TextArea note ;
    @FXML
    TextField age ;
    @FXML
    TextField job ;
    @FXML
    DatePicker birthday;
    @FXML
    ComboBox gender;
    @FXML
    ComboBox socialLife;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        gender.setItems(FXCollections.observableArrayList("Male","Female"));
        gender.setCellFactory(param -> new MyListCell());
        gender.setButtonCell(new MyListCell());

        socialLife.setItems(FXCollections.observableArrayList("Single","Married","Divorced"));
        socialLife.setCellFactory(param -> new MyListCell());
        socialLife.setButtonCell(new MyListCell());

    }

    public void onSavePatient(MouseEvent mouseEvent) {




    }


}
