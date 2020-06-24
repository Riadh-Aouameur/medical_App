package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import medical.listCell.MyListCell_5;
import medical.listCell.MyListCell_6;
import org.w3c.dom.Document;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ControllerCheckup implements Initializable {


    @FXML TableView <CheckupName>table_1;
    @FXML
     TableColumn <CheckupName,String>col1;
    @FXML TableColumn<CheckupName,CheckBox> col2;
    @FXML
    ImageView imgeGander;
    @FXML
    TextField fBirthday;
    @FXML
    TextField fPhone;
    @FXML
    TextField fAge;
    @FXML
    TextField fDate;
    @FXML
    TextField fName;


    @FXML
    ListView  <Checkup>list_2;
    @FXML
    TextField searchField;
    ObservableList<CheckupName> observableList_1;
    ObservableList<Checkup> observableList_2 ;


    Patient patient;

    public ControllerCheckup(Patient patient) {
        this.patient = patient;
    }
    public ControllerCheckup(PatientForAllPatients patient)
    {
        this.patient = new Patient();

        this.patient.setId(patient.getId());
        this.patient.setFirstName(patient.getFirstName());
        this.patient.setLastName(patient.getLastName());
        this.patient.setGender(patient.getGender());
        this.patient.setBirthday(patient.getBirthday());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        fName.setText(patient.getFirstName()+"\t"+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");
        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fDate.setText(formatter.format(LocalDate.now()));
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col2.setCellValueFactory(new PropertyValueFactory<>("checked"));
        table_1.setItems(observableList_1);



         observableList_1 =FXCollections.observableArrayList(new CheckupName("fns"),new CheckupName("uree"),new CheckupName("Creatinine"),new CheckupName("asat"),new CheckupName("Alat"),new CheckupName("crp"),new CheckupName("Vs"),new CheckupName("cholesterol"),new CheckupName("Triglyceride"));
         observableList_2 =FXCollections.observableArrayList();

        list_2.setItems(observableList_2);


        list_2.setCellFactory(pr->new MyListCell_6());


        // search field
        FilteredList<CheckupName> filteredData = new FilteredList<>(observableList_1, s -> true);


        searchField.textProperty().addListener((obs, oldValue, newValue) -> {
            filteredData.setPredicate(checkupName -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                return checkupName.getName().toLowerCase().contains(filter);

            });
        });
        SortedList<CheckupName> sortedLis = new SortedList<>(filteredData);
        table_1.setItems(sortedLis);

    }

    public void onAddToList2(ActionEvent actionEvent) {


        ObservableList  <Checkup> observableList =FXCollections.observableArrayList();
        for (CheckupName checkupName : observableList_1) {
            Checkup checkup = new Checkup(checkupName);
            if(checkupName.getChecked().isSelected()){
                observableList.add(checkup);
            }





        }

        Boolean  b= false;
        for (Checkup checkup : observableList) {
            for (Checkup value : observableList_2) {

                if (checkup.getName().equals(value.getName())) {
                     b = true;
                }

            }
        }

        if (b){

            Alert alert = new Alert(Alert.AlertType.WARNING,"deble",ButtonType.APPLY);
            alert.show();

            return;

        }else {
            observableList_2.addAll(observableList);

        }










    }

    public void onCheckup(ActionEvent actionEvent) {
    }

    public void onPrint(ActionEvent actionEvent) {
    }
}
