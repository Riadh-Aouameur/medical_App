package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerShowAllPatient  implements Initializable {
    @FXML AnchorPane root;
    @FXML TextField searchField;
    @FXML
    TableView <PatientForAllPatients>table;
    @FXML
    TableColumn <PatientForAppointement, String>  columnId;
    @FXML
    TableColumn <PatientForAppointement, String> columnFirstName;
    @FXML
    TableColumn <PatientForAppointement, String> columnLastName;
    @FXML
    TableColumn <PatientForAppointement, String>  columnGander;
    @FXML
    TableColumn<PatientForAppointement, String> columnBirthday;
    @FXML
    TableColumn <PatientForAppointement, String> ColumnLastConsultation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<PatientForAllPatients> observableList =  FXCollections.observableArrayList(
                new PatientForAllPatients(1,"Benhami","Samir", LocalDate.now(),"male")
                ,new PatientForAllPatients(2,"Aouameur","riadh", LocalDate.now(),"male"),new PatientForAllPatients(3,"Aouameur","mohamed ", LocalDate.now(),"male")
                ,new PatientForAllPatients(4,"Sky","Line", LocalDate.now(),"male")
                ,new PatientForAllPatients(5,"Aouameur","Aya", LocalDate.now(),"female"),new PatientForAllPatients(6,"Aouameur","Hamza", LocalDate.now(),"male"),
                new PatientForAllPatients(7,"Chekhar","Rafik", LocalDate.now(),"male"),
                new PatientForAllPatients(8,"Chekhar","Amira", LocalDate.now(),"female"),
                new PatientForAllPatients(9,"Chekhar","Malika", LocalDate.now(),"male"),
                new PatientForAllPatients(10,"Chekhar","Rayan", LocalDate.now(),"male"),
                new PatientForAllPatients(11,"Bacha","mohamed ", LocalDate.now(),"male"),
                new PatientForAllPatients(12,"Bacha","Imade ", LocalDate.now(),"male"),
                new PatientForAllPatients(13,"Bacha","Abde rahman ", LocalDate.now(),"male"),
                new PatientForAllPatients(14,"Bacha","kaouther ", LocalDate.now(),"female")
        );
         columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
         columnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
         columnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
         columnGander.setCellValueFactory(new PropertyValueFactory<>("gender"));
         columnBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
         table.setItems(observableList);






    }

    public void onOpenPrescription(ActionEvent actionEvent) {
        if(table.getSelectionModel().getSelectedItem()==null){
            Alert alert= new Alert(Alert.AlertType.ERROR,"No patient selected ");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ord.fxml"));

                    loader.setControllerFactory(e->{

                        return new Prescription(table.getSelectionModel().getSelectedItem(),true);
                    });


                    Stage stage =   new Stage();
                    try {
                        stage.setScene(new Scene(loader.load()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();




                }

    public void onOpenConsultation(ActionEvent actionEvent) {
        if(table.getSelectionModel().getSelectedItem()==null){
            Alert alert= new Alert(Alert.AlertType.ERROR,"No patient selected ");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fconsultation.fxml"));
        loader.setControllerFactory(e->{
            return new Consultation(table.getSelectionModel().getSelectedItem(),true);
        });

        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();


    }
    public void onMedicalAnalysis(ActionEvent actionEvent) {

        if(table.getSelectionModel().getSelectedItem()==null){
            Alert alert= new Alert(Alert.AlertType.ERROR,"No patient selected ");
            alert.show();
            return;
        }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("checkup.fxml"));
            loader.setControllerFactory(e->{


                return new ControllerCheckup(table.getSelectionModel().getSelectedItem());

            });

            Stage stage =   new Stage();
            try {
                stage.setScene(new Scene(loader.load()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.show();




    }


}
