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

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;

public class WorkPage  implements Initializable {

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
    ObservableList<Patient> observableList = FXCollections.observableArrayList(
            new Patient(1,"Benhami","Samir", LocalDate.now(),"male")
            ,new Patient(2,"Aouameur","riadh", LocalDate.now(),"male"),new Patient(3,"Aouameur","mohamed ", LocalDate.now(),"male")
            ,new Patient(4,"Sky","Line", LocalDate.now(),"male")
            ,new Patient(5,"Aouameur","Aya", LocalDate.now(),"female"),new Patient(6,"Aouameur","Hamza", LocalDate.now(),"male"),
            new Patient(7,"Chekhar","Rafik", LocalDate.now(),"male"),
            new Patient(8,"Chekhar","Amira", LocalDate.now(),"female"),
            new Patient(9,"Chekhar","Malika", LocalDate.now(),"male"),
            new Patient(10,"Chekhar","Rayan", LocalDate.now(),"male"),
            new Patient(11,"Bacha","mohamed ", LocalDate.now(),"male"),
            new Patient(12,"Bacha","Imade ", LocalDate.now(),"male"),
            new Patient(13,"Bacha","Abde rahman ", LocalDate.now(),"male"),
            new Patient(14,"Bacha","kaouther ", LocalDate.now(),"female")
    );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        Patients.listPatient.add(new Patient(14,"aouameur","riadh",
                LocalDate.now(),"male"));


        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);








    }


    public void onCreateNewPatient(ActionEvent actionEvent) throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("createPatient.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

//        Tab newPatient = new Tab();
//        ScrollPane sp = new ScrollPane();
//        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//        sp.setFitToHeight(true);
//        sp.setFitToWidth(true);
//        sp.setPrefSize(900,1080);
//        sp.setHmax(1);
//        sp.setVmax(1);
//        sp.setContent(root);
//        newPatient.setContent(sp);
//        tabpane.getTabs().add(newPatient);
//        tabpane.getSelectionModel().select(newPatient);
//        newPatient.setText("New Patient");




    }


    public void onWattingRoom(ActionEvent actionEvent) {
        //TODO complete the future
        ObservableList<PatientForWattingRoom> observableList = FXCollections.observableArrayList(
                new PatientForWattingRoom(5, 9, "gtfdotu", "hguogug", "utdttotu", "yrfu", "yifly")
        );
        TableView tableView = new TableView<PatientForWattingRoom>();

        TableColumn<PatientForWattingRoom, String> colFirstName = new TableColumn<>("First Name");
        TableColumn<PatientForWattingRoom, Integer> colId = new TableColumn<>("ID");
        TableColumn<PatientForWattingRoom, Integer> colNumber = new TableColumn<>("Number");
        TableColumn<PatientForWattingRoom, String> colLastName = new TableColumn<>("Last Name");
        TableColumn<PatientForWattingRoom, String> colGender = new TableColumn<>("Gender");
        TableColumn<PatientForWattingRoom, String> colRndv = new TableColumn<>("Rndv");
        TableColumn<PatientForWattingRoom, String> colEtat = new TableColumn<>("Etat");

        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colRndv.setCellValueFactory(new PropertyValueFactory<>("etat"));
        colEtat.setCellValueFactory(new PropertyValueFactory<>("rndv"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("nb"));
        tableView.setEditable(true);
        tableView.getColumns().setAll(colId, colNumber, colFirstName, colLastName, colGender, colEtat, colRndv);
        tableView.getItems().setAll(observableList);
        wattingRoom.setContent(tableView);
        tabpane.getTabs().add(wattingRoom);
        tabpane.getSelectionModel().select(wattingRoom);

        tableView.setItems(observableList);

        tableView.setRowFactory(tv -> {
            TableRow<PatientForWattingRoom> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    System.out.println("hi");


                }
            });
            return row;
        });


    }


    public void  onOrdonnance(ActionEvent actionEvent) throws IOException {
        Tab ordonnance = new Tab();

        ordonnance.setText("ordonnance");





   FXMLLoader loader = new FXMLLoader(getClass().getResource("patientConsultation.fxml"));
   loader.setControllerFactory(e->{
       Patient patient =new Patient(5,"aouameur","riadh",
               LocalDate.now(),"male");
       return new Prescription(patient);

   });
   VBox root =loader.load();
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        sp.setPrefSize(900,1080);
        sp.setHmax(1);
        sp.setVmax(1);


        sp.setContent(root);


        ordonnance.setContent(sp);
        tabpane.getTabs().add(ordonnance);
        tabpane.getSelectionModel().select(ordonnance);



    }



    public void onAppointment(ActionEvent actionEvent) {
        TextField filterInput = new TextField();
        VBox vBox = new VBox();
        TableView tableView = new TableView();
        ObservableList<PatientForAppointement> observableList = FXCollections.observableArrayList(
                new PatientForAppointement(5,"riadh","aouameur",LocalDate.now(),LocalDate.now()),
                new PatientForAppointement(6,"samir","benhami",LocalDate.now(),LocalDate.now()),
                new PatientForAppointement(7,"mohamed","aouameur",LocalDate.now(),LocalDate.now())

        );


        TableColumn<PatientForAppointement, String> col_1firstName = new TableColumn<>("First Name");
        TableColumn<PatientForAppointement, String> col_1lastName = new TableColumn<>("Last Name");
        TableColumn<PatientForAppointement, String> col_1date = new TableColumn<>("Appointment Date");
        TableColumn<PatientForAppointement, String> col_1Id = new TableColumn<>("ID");
        TableColumn<PatientForAppointement, String> col_1today = new TableColumn<>("Today Date");
        col_1firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_1lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_1date.setCellValueFactory(new PropertyValueFactory<>("appointmentdate"));
        col_1Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_1today.setCellValueFactory(new PropertyValueFactory<>("todaydate"));

        tableView.getColumns().setAll(col_1Id, col_1firstName, col_1lastName, col_1today, col_1date);
        tableView.setItems(observableList);
        vBox.getChildren().setAll(filterInput, tableView);
        appointment.setContent(vBox);
        tabpane.getTabs().add(appointment);
        tabpane.getSelectionModel().select(appointment);


        FilteredList<PatientForAppointement> filteredData = new FilteredList<>(observableList, s -> true);


        filterInput.textProperty().addListener((obs, oldValue, newValue) -> {
            filteredData.setPredicate(patientForAppointement -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String filter = newValue.toLowerCase();
                if (patientForAppointement.getFirstName().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else if (patientForAppointement.getLastName().toLowerCase().indexOf(filter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });
        });
        SortedList<PatientForAppointement> sortedLis = new SortedList<>(filteredData);
        sortedLis.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedLis);
    }

    public void onConsultation(ActionEvent actionEvent) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();




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
                System.out.println("clicked on " + searchList.getSelectionModel().getSelectedItem());

                 listPatient.observableList.add(searchList.getSelectionModel().getSelectedItem());
                 paneSearch.setVisible(false);

                search.setText(searchList.getSelectionModel().getSelectedItem().getFirstName()+" "+searchList.getSelectionModel().getSelectedItem().getLastName());

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
                if(patient.getFirstName().toLowerCase().indexOf(filter)!=-1){
                    return true;
                } else if(patient.getLastName().toLowerCase().indexOf(filter)!=-1){
                    return true;
                }else {
                    return false;
                }

            });
        });
        SortedList<Patient>sortedLis= new SortedList<>(filteredData);

        searchList.setItems(sortedLis);

    }
    public void onSearch(ActionEvent actionEvent) throws IOException {
        Tab patient = new Tab();
        patient.setText("Patient Folder");
        search.setText("");
        tabpane.getTabs().add(patient);
        tabpane.getSelectionModel().select(patient);



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
                        stage.setMaximized(true);
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
        Tab patients = new Tab();
        patients.setText("patients");


        Parent root = FXMLLoader.load(getClass().getResource("Patients.fxml"));
        patients.setContent(root);

        tabpane.getTabs().add(patients);
        tabpane.getSelectionModel().select(patients);



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

                       return new Prescription(litView.getSelectionModel().getSelectedItem());
                    });

            search.setText("");
            Stage stage =   new Stage();
                    try {
                        stage.setScene(new Scene(loader.load()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                    stage1.close();



                }
            }
        });








//        if (patient== null){
//
//
//            FXMLLoader load = new FXMLLoader(getClass().getResource("error.fxml"));
//            load.setControllerFactory(e->{
//
//                return new Error("Select Patient select patient \n from search textFiled ") ;
//            });
//
//
//            Scene scene =new Scene(load.load());
//            Stage stage = new Stage();
//            stage.initStyle(StageStyle.UNDECORATED);
//            stage.setScene(scene);
//            stage.show();
//
//        }else{
//            loader.setControllerFactory(e->{
//
//                return new Prescription(patient);
//            });
//
//            search.setText("");
//            Stage stage =   new Stage();
//            stage.setScene(new Scene(loader.load()));
//            stage.show();
//
//       }

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
                        return new Consultation(litView.getSelectionModel().getSelectedItem());
                    });


                    Stage stage =   new Stage();
                    try {
                        VBox vBox = loader1.load();
                        stage.setScene(new Scene(vBox));
                        stage.setMaximized(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stage.show();
                    stage1.close();



                }
            }
        });












    }

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


}




