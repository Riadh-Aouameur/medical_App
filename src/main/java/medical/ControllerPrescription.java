package medical;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerPrescription implements Initializable {


   @FXML ListView <ModelPrescription> listLoad;
    @FXML
    VBox paneLaodamodel;
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
    ObservableList<ModelPrescription> observableList2;


    Patient patient;
    private  int index;

    public ControllerPrescription(Patient patient)
    {

            this.patient = patient;


    }
    public ControllerPrescription(PatientForAllPatients patient, Boolean test)
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
        listOfMedication.setCellFactory(pr -> new MyListCell_2());
        listLoad.setCellFactory(pr -> new MyListCell_9());
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
       ModelPrescription modelPrescription = new ModelPrescription("hi");
        modelPrescription.setMedicaments(FXCollections.observableArrayList(new Medicament("gsgff","bfxcbfv",4,"bfdfbfb"),new Medicament("gsgff","bfxcbfv",4,"bfdfbfb")));
        observableList2 = FXCollections.observableArrayList(modelPrescription);
        listLoad.setItems(observableList2);
        fName.setText(patient.getFirstName()+"\t"+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");
        textEntityNumber.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textEntityNumber.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        listOfMedication.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                   Medicament medicament = listOfMedication.getSelectionModel().getSelectedItem();
                   index = listOfMedication.getSelectionModel().getSelectedIndex();
                    textMedi.setText(medicament.getNameMedicament());
                    textDosage.setText(medicament.getDosage());
                    textQsp.setText(medicament.getQsp());
                    textEntityNumber.setText(String.valueOf(medicament.getEntityNumber()));



                }
            }
        });
        listLoad.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    ModelPrescription modelPrescription = listLoad.getSelectionModel().getSelectedItem();


                    Boolean  b= false;
                    for (Medicament medicament : modelPrescription.getMedicaments()) {
                        for (Medicament value : listOfMedication.getItems()) {

                            if (medicament.getNameMedicament().equals(value.getNameMedicament())) {
                                b = true;
                            }

                        }
                    }

                    if (b){

                        Alert alert = new Alert(Alert.AlertType.WARNING,"deble",ButtonType.APPLY);
                        alert.show();

                        return;

                    }else {
                        listOfMedication.getItems().addAll(modelPrescription.getMedicaments());

                    }


                    paneLaodamodel.setVisible(false);



                }
            }
        });










        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        date.setText(formatter.format(LocalDate.now()));
        fDate.setText(formatter.format(LocalDate.now()));




    }



    public void onAdd(ActionEvent actionEvent) throws IOException {

        Medicament medicament = new Medicament(textMedi.getText(),textDosage.getText(),Integer.parseInt(textEntityNumber.getText()),textQsp.getText());
        listOfMedication.getItems().addAll(medicament);



        textMedi.setText("");
        textDosage.setText("");
        textQsp.setText("");
        textEntityNumber.setText("");
    }

    public void onModify(ActionEvent actionEvent) {
        Medicament medicament = new Medicament(textMedi.getText(),textDosage.getText(),Integer.parseInt(textEntityNumber.getText()),textQsp.getText());
        listOfMedication.getItems().set(index,medicament);



        textMedi.setText("");
        textDosage.setText("");
        textQsp.setText("");
        textEntityNumber.setText("");
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
                paneLIstOFMedicament.setVisible(false);

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
        if(paneLaodamodel.isVisible())
            paneLaodamodel.setVisible(false);


    }

    public void onSearch(ActionEvent actionEvent) {



    }

    public void onLoadAModel(ActionEvent actionEvent) {
        if(paneLaodamodel.isVisible())
            paneLaodamodel.setVisible(false);
        else
            paneLaodamodel.setVisible(true);
    }

    public void onAddNewModel(ActionEvent actionEvent) {

            ModelPrescription modelPrescription = new ModelPrescription("new Model");
            modelPrescription.setMedicaments(listOfMedication.getItems());
            listLoad.getItems().add(modelPrescription);



    }

    public void onSaveAndPrint(ActionEvent actionEvent) {

        if(listOfMedication.getItems().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("");
            alert.setTitle("");
            alert.setHeaderText("");
            alert.showAndWait();

        }
        else
            {
                Prescription prescription = new Prescription(LocalDate.now(),listOfMedication.getItems());
                System.out.println("down");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("");
                alert.setTitle("");
                alert.setHeaderText("");

                ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getDialogPane().getButtonTypes().add(buttonCancel);
                Optional <ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    System.out.println("save");
                    Db db=new Db();
                    db.InsertMedicament(prescription,patient.getId());
                }
                System.out.println("NOT save");

            }


    }
}
