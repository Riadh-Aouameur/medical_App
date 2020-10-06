package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import medical.DataBase.Db;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ControllerHistory3 implements Initializable {
    public Label fName;
    public Label fAge;
    public TextField t1;
    @FXML
  ListView <Checkup>list_1;
    @FXML
    ListView <Checkup>list_2;
    @FXML
    ObservableList <Checkup>observableList1;
    ObservableList <Checkup>observableList2;

    @FXML
    ImageView imgeGander;
    Patient patient;
    public ControllerHistory3(Patient patient)
    { this.patient = patient; }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Db db = new Db();
        System.out.println(patient.getId());

        if(patient.getGender().equals("Female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }

        fName.setText(patient.getFirstName()+" "+patient.getLastName());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText("Age : "+i);

        observableList2 = FXCollections.observableArrayList();
        observableList1 = FXCollections.observableArrayList();


        list_1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                 Checkup p =  list_1.getSelectionModel().getSelectedItem();
                    if (!observableList2.isEmpty()) {
                        observableList2.clear();
                    }
                    observableList2.add(p);


                }
            }
        });

        observableList1.setAll(db.getCheckupHistory(patient.getId()));


       list_1.setCellFactory(l->new MyListCell_16());
       list_2.setCellFactory(l->new MyListCell_17());
                list_1.setItems(observableList1);
                list_2.setItems(observableList2);


        FilteredList<Checkup> filteredData = new FilteredList<>(observableList1, s -> true);
        t1.textProperty().addListener((obs ,oldValue,newValue)->{
            filteredData.setPredicate(patient -> {
                if(newValue ==null||newValue.isEmpty()){
                    return true;
                }
                String filter = newValue.toLowerCase();
                if(patient.getDate().toString().toLowerCase().contains(filter)){
                    return true;
                } else if(String.valueOf(patient.getId()).toLowerCase().contains(filter)){
                    return true;
                }else {
                    return false;
                }

            });
        });
        SortedList<Checkup> sortedLis= new SortedList<>(filteredData);

        list_1.setItems(sortedLis);

    }

    public void onShowAll(ActionEvent actionEvent) {

        if (!observableList2.isEmpty()) {
            observableList2.clear();
        }
        observableList2.addAll(observableList1);

    }
}
