package medical;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import medical.DataBase.Db;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;






public class newPatient implements Initializable {

    public TextField phone;
    public ToggleGroup group;
    public ComboBox <String>children;
    public ComboBox  <String> marritalStatus;
    public TextField profession;
    public Label massage;
    @FXML
    TextField firstName ;
    @FXML
    TextField lastName;

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







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        marritalStatus.setItems(FXCollections.observableArrayList("Single","Married","Divorced","Widowed"));
        marritalStatus.setCellFactory(param -> new MyListCell());
        marritalStatus.setButtonCell(new MyListCell());

        children.setItems(FXCollections.observableArrayList("0","1","2","3","4","5","More"));
        children.setCellFactory(param -> new MyListCell());
        children.setButtonCell(new MyListCell());
        group = new ToggleGroup();
        ima.fire();
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
            iProfession =children.getValue();
        }

        if (iFirstName != null && iLastName != null&& iBirthday != null){
            patient = new Patient(iLastName,iFirstName,Integer.parseInt(iChildren),iBirthday,gender,iProfession,iPhone,iMarritalStatus);
            Db db = new Db();
            db.InsertPatientData(patient);
            massage.setText("good");

            System.out.println(iFirstName+" "+iLastName+" "+iBirthday+" "+iChildren+" "+gender);
        }else {
            System.out.println("error");
            massage.setText("error");
        }







    }


}
