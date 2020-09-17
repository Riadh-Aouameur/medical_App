package medical;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import medical.DataBase.Db;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.ResourceBundle;

public class WorkPage  implements Initializable {

    public ImageView drg;
    public Label dr ;

    public Tab medicalRecordTab;
    public TextField fAge;
    public TextField fPhone;
    public TextField fBirthday;
    public ImageView imgeGander;

    public TextField fName;
    public TextField fDate;
    public TextField fProfession;
    public TextField fChildren;
    public ComboBox <String> fMaritalStatus;
    @FXML
    TableView <Patient>table;
    @FXML
    TableColumn <Patient, String>  columnId;
    @FXML
    TableColumn <Patient, String> columnFirstName;
    @FXML
    TableColumn <Patient, String> columnLastName;
    @FXML
    TableColumn <Patient, String>  columnGander;
    @FXML
    TableColumn<Patient, String> columnBirthday;

    public Tab appointementTab;
    public Tab patientsTab;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    @FXML
    BorderPane root;
    @FXML
    Tab homeTab;
    @FXML
    TabPane tabpane;
     @FXML
    Pane paneSearch;
    @FXML
    TextField search;

    @FXML
    Button searchButton;

    private double x;
    private double y;

    @FXML
    ListView <Patient> searchList ;

    Tab wattingRoom = new Tab();
    Tab appointment = new Tab();
    ObservableList<Patient> observableList = FXCollections.observableArrayList();

    Db db = new Db();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dr.setText("Dr."+DoctorInformationSingle.getInstance(0).getFirstName());
        if(DoctorInformationSingle.getInstance(0).getGender().equals("Female")) {
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            drg.setImage(imProfile);
        }


            tabpane.getTabs().remove(appointementTab);
        tabpane.getTabs().remove(patientsTab);
        tabpane.getTabs().remove(medicalRecordTab);
        observableList.addAll(db.getPatientData());
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("rghitdrawer.fxml"));
            loader.setControllerFactory(e->{

                return new ControllerRightDrawer();

            });

            AnchorPane anchorPane=loader.load();

            drawer.setSidePane(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
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



        wattingRoom.setText("Watting Room");
        appointment.setText("Appointment");


        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);








    }









    public void onAppointment(ActionEvent actionEvent) {

        tabpane.getTabs().add(appointementTab);
        tabpane.getSelectionModel().select(appointementTab);

    }



    public void onClicked(MouseEvent mouseEvent) {

        searchList.setCellFactory(param -> new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.getFirstName()+" "+item.getLastName());
                }
            }
        });
        searchList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Patient patient =searchList.getSelectionModel().getSelectedItem();
                if(patient!=null){
                    listPatient.observableList.add(patient);
                    paneSearch.setVisible(false);
                    search.setText(searchList.getSelectionModel().getSelectedItem().getFirstName()+" "+searchList.getSelectionModel().getSelectedItem().getLastName());
                }
            }
        });
        paneSearch.setVisible(true);
        FilteredList<Patient> filteredData = new FilteredList<>(observableList, s -> true);
        search.textProperty().addListener((obs ,oldValue,newValue)->{
            filteredData.setPredicate(patient -> {
                if(newValue ==null||newValue.isEmpty()){
                    return true;
                }
                String filter = newValue.toLowerCase();
                if(patient.getFirstName().toLowerCase().contains(filter)){
                    return true;
                } else return patient.getLastName().toLowerCase().contains(filter);

            });
        });
        SortedList<Patient>sortedLis= new SortedList<>(filteredData);

        searchList.setItems(sortedLis);

    }
    public void onSearch(ActionEvent actionEvent) throws IOException {




        if(search.getText()==null||search.getText().equals("")){
            Alert alert= new Alert(Alert.AlertType.ERROR,"No patient selected ");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("history.fxml"));
        loader.setControllerFactory(e->{
            return new ControllerHistory(new Patient());
        });

        Stage stage =   new Stage();
        try {
            VBox vBox = loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.setTitle("History");
            Image icon = new Image(getClass().getResourceAsStream("img/health.png"));
            stage.getIcons().add(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();



    }





    public void onClose(ActionEvent actionEvent) {
        System.exit(0);
    }


    public void onMedicalAnalysis(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = new AnchorPane();


        ListView <Patient> litView = new ListView<>();
        litView.setCellFactory(    param -> new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.getFirstName()+" "+item.getLastName());
                }
            }
        });
        litView.setItems(listPatient.observableList);
        litView.setCellFactory(e-> new MyListCell_4());
        anchorPane.getChildren().add(litView);
        litView.setPrefSize(500,400);
        anchorPane.setPrefWidth(500);
        anchorPane.setPrefHeight(400);

        Scene scene =new Scene(anchorPane,500,400);
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setScene(scene);
        stage1.show();

        litView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {


                    FXMLLoader loader = new FXMLLoader(getClass().getResource("checkup.fxml"));
                    loader.setControllerFactory(e->{


                        return new ControllerCheckup(litView.getSelectionModel().getSelectedItem());

                    });


                    Stage stage =   new Stage();
                    try {

                        stage.setScene(new Scene( loader.load()));
                        stage.setTitle("Medical Analysis");
                        stage.initStyle(StageStyle.UTILITY);

                        Image icon = new Image(getClass().getResourceAsStream("img/health.png"));
                        stage.getIcons().add(icon);



                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                    stage1.close();



                }
            }
        });














    }

    public void OnOpenListOfAllPatients(ActionEvent actionEvent) throws IOException {
        Stage  primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Patients.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();



    }

    public void onGotoHome(ActionEvent actionEvent) {
        tabpane.getSelectionModel().select(0);
    }

    public void onOpenPrescription(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane = new AnchorPane();

    
        ListView <Patient> litView = new ListView<>();
         litView.setCellFactory(    param -> new ListCell<Patient>() {
             @Override
             protected void updateItem(Patient item, boolean empty) {
                 super.updateItem(item, empty);

                 if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                     setText(null);
                 } else {
                     setText(item.getFirstName()+" "+item.getLastName());
                 }
             }
         });
         litView.setItems(listPatient.observableList);
         litView.setCellFactory(e-> new MyListCell_4());
         anchorPane.getChildren().add(litView);
         litView.setPrefSize(500,400);
         anchorPane.setPrefWidth(500);
         anchorPane.setPrefHeight(400);

            Scene scene =new Scene(anchorPane,500,400);
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UTILITY);
            stage1.setScene(scene);
            stage1.show();

        litView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ord.fxml"));

                    loader.setControllerFactory(e->{

                       return new ControllerPrescription(litView.getSelectionModel().getSelectedItem());
                    });

            search.setText("");
            Stage stage =   new Stage();
                    try {
                        stage.setScene(new Scene(loader.load()));
                        stage.setTitle("Prescription");
                        stage.initStyle(StageStyle.UTILITY);
                        Image icon = new Image(getClass().getResourceAsStream("img/prescription.png"));
                        stage.getIcons().add(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                    stage1.close();



                }
            }
        });









    }

    public void onOpenConsultation(ActionEvent actionEvent) throws IOException {


        AnchorPane anchorPane = new AnchorPane();


        ListView <Patient> litView = new ListView<>();
        litView.setCellFactory(    param -> new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.getFirstName()+" "+item.getLastName());
                }
            }
        });
        litView.setItems(listPatient.observableList);
        litView.setCellFactory(e-> new MyListCell_4());
        anchorPane.getChildren().add(litView);
        litView.setPrefSize(500,400);
        anchorPane.setPrefWidth(500);
        anchorPane.setPrefHeight(400);

        Scene scene =new Scene(anchorPane,500,400);
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setScene(scene);
        stage1.show();

        litView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {


                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("fconsultation.fxml"));
                    loader1.setControllerFactory(e->{
                        return new ControllerConsultation(litView.getSelectionModel().getSelectedItem());
                    });


                    Stage stage =   new Stage();
                    try {
                        VBox vBox = loader1.load();
                        stage.setScene(new Scene(vBox));
                        stage.setTitle("Consultation");
                        stage.initStyle(StageStyle.UTILITY);
                        Image icon = new Image(getClass().getResourceAsStream("img/consultation.png"));
                        stage.getIcons().add(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                    stage1.close();



                }
            }
        }); }

    public void onMinButton(ActionEvent actionEvent) {
     Stage stage = (Stage) root.getScene().getWindow();
     stage.setIconified(true);

    }

    public void onMaxButton(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
        }


    }


    public void onCalculater(ActionEvent actionEvent) throws IOException {
        String params ;
        params = "C:\\Windows\\System32\\calc.exe";

        Runtime.getRuntime().exec(params);
    }

    public void onOpenNotes(ActionEvent actionEvent) throws IOException {
        String params ;
        params = "C:\\Program Files\\Notes 0.9.0\\Notes.exe";

        Runtime.getRuntime().exec(params);

    }

    public void onOpenDocuments(ActionEvent actionEvent) {

        AnchorPane anchorPane = new AnchorPane();


        ListView <Patient> litView = new ListView<>();
        litView.setCellFactory(    param -> new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.getFirstName()+" "+item.getLastName());
                }
            }
        });
        litView.setItems(listPatient.observableList);
        litView.setCellFactory(e-> new MyListCell_4());
        anchorPane.getChildren().add(litView);
        litView.setPrefSize(500,400);
        anchorPane.setPrefWidth(500);
        anchorPane.setPrefHeight(400);

        Scene scene =new Scene(anchorPane,500,400);
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setScene(scene);
        stage1.show();

        litView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {


                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("document.fxml"));
                    loader1.setControllerFactory(e->{
                        return new ControllerDocument(litView.getSelectionModel().getSelectedItem());
                    });


                    Stage stage =   new Stage();
                    try {
                        VBox vBox = loader1.load();
                        stage.setScene(new Scene(vBox));
                        stage.initStyle(StageStyle.UTILITY);
                        stage.setTitle("ControllerConsultation");
                        Image icon = new Image(getClass().getResourceAsStream("img/consultation.png"));
                        stage.getIcons().add(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                    stage1.close();



                }
            }
        });











    }

    public void onOpenPrescriptionMenu(ActionEvent actionEvent) {
        if(table.getSelectionModel().getSelectedItem()==null){
            Alert alert= new Alert(Alert.AlertType.ERROR,"No patient selected ");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ord.fxml"));

        loader.setControllerFactory(e->{

            return new ControllerPrescription(table.getSelectionModel().getSelectedItem());
        });


        Stage stage =   new Stage();
        try {
            ;
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("ControllerPrescription");
            Image icon = new Image(getClass().getResourceAsStream("img/prescription.png"));
            stage.getIcons().add(icon);

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();




    }

    public void onOpenConsultationMenu(ActionEvent actionEvent) {
        if(table.getSelectionModel().getSelectedItem()==null){
            Alert alert= new Alert(Alert.AlertType.ERROR,"No patient selected ");
            alert.show();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fconsultation.fxml"));
        loader.setControllerFactory(e->{
            return new ControllerConsultation(table.getSelectionModel().getSelectedItem());
        });

        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("ControllerConsultation");
            Image icon = new Image(getClass().getResourceAsStream("img/consultation.png"));
            stage.getIcons().add(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();


    }
    public void onMedicalAnalysisMenu(ActionEvent actionEvent) {

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
            stage.setTitle("Medical Analysis");
            Image icon = new Image(getClass().getResourceAsStream("img/health.png"));
            stage.getIcons().add(icon);
            stage.initStyle(StageStyle.TRANSPARENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();




    }
    Patient patient;
    public void onOpenMedicalRecord(ActionEvent actionEvent) {

        AnchorPane anchorPane = new AnchorPane();


        ListView <Patient> litView = new ListView<>();
        litView.setCellFactory(    param -> new ListCell<Patient>() {
            @Override
            protected void updateItem(Patient item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getFirstName()+item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.getFirstName()+" "+item.getLastName());
                }
            }
        });
        litView.setItems(listPatient.observableList);
        litView.setCellFactory(e-> new MyListCell_4());
        anchorPane.getChildren().add(litView);
        litView.setPrefSize(500,400);
        anchorPane.setPrefWidth(500);
        anchorPane.setPrefHeight(400);

        Scene scene =new Scene(anchorPane,500,400);
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setScene(scene);
        stage1.show();

        litView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    patient = litView.getSelectionModel().getSelectedItem();



                    if(patient.getGender().equals("female")){
                        Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                        imgeGander.setImage(imProfile);
                    }
                    fName.setText(patient.getFirstName()+" "+patient.getLastName());
                    fBirthday.setText(patient.getBirthday().toString());
                    LocalDate b= (LocalDate) patient.getBirthday();
                    Calendar c =Calendar.getInstance();
                    int i =c.get(Calendar.YEAR)-b.getYear();
                    fPhone.setText(patient.getPhone());
                    fAge.setText(i+"");
                    DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
                    fDate.setText(formatter.format(LocalDate.now()));





                    tabpane.getTabs().add(medicalRecordTab);
                    tabpane.getSelectionModel().select(medicalRecordTab);




                }
            }
        });












    }

    public void onOpenHistoryOfPrescription(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("history.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerHistory(patient);

        });

        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));



        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();

    }

    public void onOpenCalender(ActionEvent actionEvent) {

        try {
        String params ;
        params = "C:\\Program Files (x86)\\Calendrier\\Cld2000.exe";


            Runtime.getRuntime().exec(params);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void onOpenHistoryOfConsultation(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("history1.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerHistory1(patient);

        });

        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));



        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();

    }

    public void onOpenHistoryOfDocuments(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("history2.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerHistory2(patient);

        });

        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));



        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void onOpenHistoryOfMedicalAnalysis(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("history3.fxml"));
        loader.setControllerFactory(e->{


            return new ControllerHistory3(patient);

        });

        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));



        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
        paneSearch.setVisible(false);
    }


    public void onOpenAbout(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));


        Stage stage =   new Stage();
        try {
            stage.setScene(new Scene(loader.load()));



        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("About");
        stage.show();

    }
}

//    Classification of legal marital status
//        1 - Married (and not separated) ...
//        2 - Widowed (including living common law) ...
//        3 - Separated (including living common law) ...
//        4 - Divorced (including living common law) ...
//        5 - Single (including living common law


