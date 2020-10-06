package medical;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ControllerAdd implements Initializable {

    public TextField phone;
    public ToggleGroup group;
    public ComboBox <String>children;
    public ComboBox  <String> marritalStatus;
    public TextField profession;
    public AnchorPane paneMassage;
    public Label message;
    @FXML
    TextField firstName ;
    @FXML
    TextField lastName;
    public AnchorPane root;
    private double x;
    private double y;
    @FXML
    DatePicker birthday;
    public RadioButton ima;
    public RadioButton ife;
    String gender="Male";
    String iFirstName = null;
    String iLastName = null;
    LocalDate iBirthday = null;
    String iPhone =" ";
    String iChildren="-1" ;
    String iMarritalStatus ="";
    String iProfession ="";
    Patient patient;
    ObservableList<Patient> observableList = FXCollections.observableArrayList();

    public ControllerAdd(ObservableList<Patient> observableList) {
        this.observableList = observableList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lastName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                lastName.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        firstName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                firstName.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        profession.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*")) {
                profession.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
            }
        });
        phone.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    // Check if the new character is greater than LIMIT
                    if (phone.getText().length() >= 10) {

                        // if it's 11th character then just setText to previous
                        // one
                        phone.setText(phone.getText().substring(0, 10));
                    }
                }
            }
        });
        phone.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    phone.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(e->{
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX()-x);
            stage.setY(e.getScreenY()-y);
        });
        marritalStatus.setItems(FXCollections.observableArrayList("Single","Married","Divorced","Widowed"));
        marritalStatus.setCellFactory(param -> new MyListCell());
        marritalStatus.setButtonCell(new MyListCell());
        children.setItems(FXCollections.observableArrayList("0","1","2","3","4","5","More"));
        children.setCellFactory(param -> new MyListCell_19());
        children.setButtonCell(new MyListCell_19());
        ima.fire();
        group = new ToggleGroup();
        ife.setToggleGroup(group);
        ima.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    gender=button.getText();
                }
            }
        });




    }

    public void onSavePatient(ActionEvent mouseEvent) {

        if (!(firstName.getText().isEmpty())){
            iFirstName= firstName.getText();
        }
        if (!(lastName.getText().isEmpty())){
            iLastName= lastName.getText();
        }
        if (!(birthday.getValue()== null)){
            iBirthday =birthday.getValue();
        }
        if (!(phone.getText().isEmpty())){
            iPhone= phone.getText();
        }
        if (!(marritalStatus.getValue()== null)){
            iMarritalStatus =marritalStatus.getValue();
        }
        if (!(children.getValue()== null)){
            iChildren =children.getValue();
        }
        if (!(profession.getText().isEmpty())){
            iProfession =profession.getText();
        }

        if (iFirstName != null && iLastName != null&& iBirthday != null){

            if (!iBirthday.isBefore(LocalDate.now())){
                message.setText("This Date Not Available");
                paneMassage.setVisible(true);
                return;
            }
            patient = new Patient(iLastName,iFirstName,Integer.parseInt(iChildren),iBirthday,gender,iProfession,iPhone,iMarritalStatus,"Active");
            Db db = new Db();
            db.InsertPatientData(patient);
            observableList.add(patient);

             iFirstName = null;
            iLastName = null;
             iBirthday = null;
             iPhone =" ";
             iChildren="0" ;
            iMarritalStatus ="";
            iProfession ="";
            firstName.setText("");
            lastName.setText("");
            phone.setText("");
            profession.clear();
            birthday.setValue(null);
            children.setValue(null);
            marritalStatus.setValue(null);

            message.setText("Successful");





        }else {
            message.setText("Must Fill Empty Fields");
            paneMassage.setVisible(true);
        }







    }
    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();

    }

}
