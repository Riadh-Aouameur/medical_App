package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Prescription implements Initializable {


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
    AnchorPane textAge;
    @FXML
    TextArea textDosage ;
    @FXML
    TextArea textQsp ;
    @FXML
    TextArea textMedi;
    @FXML
    TextField textEntityNumber  ;
    @FXML
    Label date;



    @FXML
    VBox vBox;
    @FXML
   ListView <Medicament> listOfMedication;
    @FXML
    AnchorPane paneLIstOFMedicament;

    @FXML
    ListView <MedicamentName> listOfMedicament;
    ObservableList<MedicamentName> observableList;


    Patient patient;

    public Prescription(Patient patient)
    {

            this.patient = patient;


    }
    public Prescription(PatientForAllPatients patient,Boolean test)
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
        date.setText(formatter.format(LocalDate.now()));
        fDate.setText(formatter.format(LocalDate.now()));




    }



    public void onAdd(ActionEvent actionEvent) throws IOException {

        Medicament medicament = new Medicament(textMedi.getText(),textDosage.getText(),Integer.parseInt(textEntityNumber.getText()),textQsp.getText());
        listOfMedication.getItems().addAll(medicament);
       listOfMedication.setCellFactory(pr -> new MyListCell_2());


        textMedi.setText("");
        textDosage.setText("");
        textQsp.setText("");
        textEntityNumber.setText("");
    }

    public void onModify(ActionEvent actionEvent) {
    }

    public void onSave(ActionEvent actionEvent) {
    }

    public void onPrinted(ActionEvent actionEvent) {
    }

    public void onClicked(MouseEvent mouseEvent) {
        observableList = FXCollections.observableArrayList(new MedicamentName("Amoxicilline","125 mg"),
                new MedicamentName("Amoxicilline","250mg"),
                new MedicamentName("Amoxicilline","500 mg /5 ml"),
                new MedicamentName("Paracetamol","100 mg"),
                new MedicamentName("Paracetamol","200 mg"),
                new MedicamentName("Paracetamol","150 mg"),
                new MedicamentName("Paracetamol","300 mg"),
                new MedicamentName("Paracetamol","500 mg"),
                new MedicamentName("Paracetamol","1000 mg"),
                new MedicamentName("Flgyl","125 mg / 5 ml"),
                new MedicamentName("Flgyl","250 mg / 10 ml"),
                new MedicamentName("Flgyl","500 mg"),
                new MedicamentName("Smecta"),
                new MedicamentName("Domperidone","10 mg"),
                new MedicamentName("Domperidone","1 mg / 1 ml"),
                new MedicamentName("Ibuprofene","200 mg"),
                new MedicamentName("Ibuprofene","400 mg"),
                new MedicamentName("Ibuprofene","600 mg"),
                new MedicamentName("Bedelix"),
                new MedicamentName("Dicetel","50 mg"),
                new MedicamentName("Dicetel","100 mg"),
                new MedicamentName("Duspatalin","100 mg"),
                new MedicamentName("Duspatalin","200 mg"),
                new MedicamentName("Calcium","500 mg"),
                new MedicamentName("Tiralor","10 mg")


        );
        if(paneLIstOFMedicament.isVisible())
             paneLIstOFMedicament.setVisible(false);
        else
            paneLIstOFMedicament.setVisible(true);



        listOfMedicament.setItems(observableList);

        listOfMedicament.setCellFactory(param -> new ListCell<MedicamentName>() {
            @Override
            protected void updateItem(MedicamentName item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null ) {
                    setGraphic(null);
                } else {
                    Label label =new Label(item.getName()+" "+item.getDosage());
                    label.setStyle("-fx-text-fill: #000;");
                    setGraphic(label);
                }
                setText("");

            }

        });


        listOfMedicament.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + listOfMedicament.getSelectionModel().getSelectedItem());

               textMedi.setText(listOfMedicament.getSelectionModel().getSelectedItem().getNameDosage());

            }
        });


        FilteredList<MedicamentName> filteredData = new FilteredList<>(observableList, s -> true);
        textMedi.textProperty().addListener((obs ,oldValue,newValue)->{
            filteredData.setPredicate(medicamentName -> {
                if(newValue ==null|| newValue.isEmpty()){
                    return true;
                }
                String filter = newValue.toLowerCase();
                if(medicamentName.getName().toLowerCase().indexOf(filter)!=-1){
                    return true;
                } else if(medicamentName.getDosage().toLowerCase().indexOf(filter)!=-1){
                    return true;
                }else {
                    return false;
                }

            });
        });
        SortedList<MedicamentName> sortedLis= new SortedList<>(filteredData);
        listOfMedicament.setItems(sortedLis);


    }

    public void onSelectOld(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("oldMedicament.fxml"));
        AnchorPane anchorPane = loader.load();
        Stage primaryStage = new Stage();
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void onMouseClickedAnchorPane(MouseEvent mouseEvent) {
        if(paneLIstOFMedicament.isVisible())
            paneLIstOFMedicament.setVisible(false);


    }

    public void onSearch(ActionEvent actionEvent) {



    }
}
