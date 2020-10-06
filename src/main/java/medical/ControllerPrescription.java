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
import javafx.stage.StageStyle;
import medical.DataBase.Db;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ControllerPrescription implements Initializable {


    public Button m;
    public Button a;
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
    Db db=new Db();

    public ControllerPrescription(Patient patient)
    {

            this.patient = patient;


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
        fPhone.setText(patient.getPhone());
        fName.setText(patient.getFirstName()+" "+patient.getLastName());
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
                    m.setDisable(false);
                    a.setDisable(true);




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
        a.setDisable(false);
        m.setDisable(true);
    }



    public void onClicked(MouseEvent mouseEvent) {
        observableList = FXCollections.observableArrayList(db.getMedi());
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
            alert.setContentText("Medicaments List Is Empty");
            alert.setTitle("INFORMATION");
            alert.setHeaderText("");
            alert.showAndWait();

        }
        else
            {
                Prescription prescription = new Prescription(LocalDate.now(),listOfMedication.getItems());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Are you sure to save ?");
                alert.setTitle("CONFIRMATION");
                alert.setHeaderText("");

                ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getDialogPane().getButtonTypes().add(buttonCancel);
                Optional <ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    System.out.println("save");

                    int doctorID = Integer.parseInt(DoctorInformationSingle.getInstance(0).getDoctorID());
                    db.InsertMedicament(prescription,patient.getId(),doctorID);
                    listOfMedication.getItems().clear();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/medical?autoReconnect=true&useSSL=false","root","1234");
                        String q = "SELECT *\n" +
                                "FROM  Prescription\n" +
                                "INNER JOIN Medicament ON Prescription.prescriptionID = Medicament.prescriptionID\n" +
                                "INNER JOIN patient ON Prescription.patientID = patient.patientID\n" +
                                "INNER JOIN doctor ON Prescription.doctorID = doctor.doctorID\n" +
                                "where Prescription.prescriptionID ="+prescription.getId();
                        JasperDesign jd = JRXmlLoader.load("src/main/resources/medical/jasper/Blank_A4_2.jrxml");
                        JRDesignQuery jrDesignQuery = new JRDesignQuery();
                        jrDesignQuery.setText(q);
                        jd.setQuery(jrDesignQuery);


                        JasperReport jr = JasperCompileManager.compileReport(jd);
                        Map<String, Object> param = new HashMap<String, Object>();
                        JasperPrint jP = JasperFillManager.fillReport(jr,param,con);

                        JasperViewer.viewReport(jP,false);
                    } catch (Exception e) {
                        Alert alert2 = new Alert(Alert.AlertType.ERROR);
                        alert2.setContentText(e.getMessage());
                        alert2.setTitle("ERROR");
                        alert2.setHeaderText("");
                        alert2.showAndWait();
                    }

                }


            }


    }

    public void onOpenMedi(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addMedicament.fxml"));


        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));



        } catch (IOException e) {

            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setContentText(e.getMessage());
            alert2.setTitle("ERROR");
            alert2.setHeaderText("");
            alert2.showAndWait();
        }
        stage.setTitle("Medicament");
        Image icon = new Image(getClass().getResourceAsStream("img/plus.png"));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(icon);
        stage.show();
    }
}
//new MedicamentName("Amoxicilline","125 mg"),
//                new MedicamentName("Amoxicilline","250mg"),
//                new MedicamentName("Amoxicilline","500 mg /5 ml"),
//                new MedicamentName("Paracetamol","100 mg"),
//                new MedicamentName("Paracetamol","200 mg"),
//                new MedicamentName("Paracetamol","150 mg"),
//                new MedicamentName("Paracetamol","300 mg"),
//                new MedicamentName("Paracetamol","500 mg"),
//                new MedicamentName("Paracetamol","1000 mg"),
//                new MedicamentName("Flgyl","125 mg / 5 ml"),
//                new MedicamentName("Flgyl","250 mg / 10 ml"),
//                new MedicamentName("Flgyl","500 mg"),
//                new MedicamentName("Smecta"),
//                new MedicamentName("Domperidone","10 mg"),
//                new MedicamentName("Domperidone","1 mg / 1 ml"),
//                new MedicamentName("Ibuprofene","200 mg"),
//                new MedicamentName("Ibuprofene","400 mg"),
//                new MedicamentName("Ibuprofene","600 mg"),
//                new MedicamentName("Bedelix"),
//                new MedicamentName("Dicetel","50 mg"),
//                new MedicamentName("Dicetel","100 mg"),
//                new MedicamentName("Duspatalin","100 mg"),
//                new MedicamentName("Duspatalin","200 mg"),
//                new MedicamentName("Calcium","500 mg"),
//                new MedicamentName("Tiralor","10 mg")