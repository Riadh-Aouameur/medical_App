package Medical;

import com.jfoenix.controls.JFXBadge;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

public class WorkPage  implements Initializable {
    @FXML
    Tab homeTab;
    @FXML
    TabPane tabpane;


    Paitent paitent;

    Tab newPatient = new Tab();
    Tab consultation = new Tab();
    Tab wattingRoom = new Tab();
    Tab appointment = new Tab();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newPatient.setText("New Patient");
        consultation.setText("Consultation");
        wattingRoom.setText("Watting Room");
        appointment.setText("Appointment");
        tabpane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);


    }


    public void onCreateNewPatient(ActionEvent actionEvent) {

        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 150);
        gridPane.setPadding(new Insets(10, 10, 0, 10));
        gridPane.setVgap(4);
        gridPane.setHgap(4);
        gridPane.setAlignment(Pos.BASELINE_LEFT);


        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField place_of_birth = new TextField();
        TextArea note = new TextArea();

        TextField age = new TextField();
        age.setEditable(false);

        TextField job = new TextField();
        DatePicker brithday = new DatePicker();
        ComboBox gender = new ComboBox(FXCollections.observableArrayList("M", "F"));
        ComboBox socialife = new ComboBox(FXCollections.observableArrayList("single", "marred", "alone"));
        gridPane.add(new Label("First Name"), 0, 0);
        gridPane.add(new Label("Last Name"), 0, 1);
        gridPane.add(new Label("birthday"), 0, 2);
        gridPane.add(new Label("Place of birth"), 0, 3);
        gridPane.add(firstName, 1, 0);
        gridPane.add(lastName, 1, 1);
        gridPane.add(brithday, 1, 2);
        gridPane.add(place_of_birth, 1, 3);

        gridPane.add(new Label("Gender"), 2, 0);
        gridPane.add(new Label("Social Life"), 2, 1);
        gridPane.add(new Label("Age"), 2, 2);
        gridPane.add(new Label("Job"), 2, 3);
        gridPane.add(new Label("Note"), 0, 4);

        gridPane.add(gender, 3, 0);
        gridPane.add(socialife, 3, 1);
        gridPane.add(age, 3, 2);
        gridPane.add(job, 3, 3);
        HBox hBox = new HBox();
        hBox.setMinSize(400, 70);


        hBox.getChildren().setAll(note);


        brithday.valueProperty().addListener((ov, oldValue, newValue) -> {
            int a = Period.between(brithday.getValue(), LocalDate.now()).getYears();
            age.setText(String.valueOf(a));
        });


        Button save = new Button("Save");
        save.setPadding(new Insets(5));
        save.setMinSize(60, 45);
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Paitent paitent = new Paitent(4, firstName.getText(), lastName.getText(), brithday.getValue(), gender.getSelectionModel().getSelectedItem().toString());
                System.out.println(paitent.getFirstName());

                System.out.println("hi");
            }
        });

        vBox.getChildren().setAll(new Label("Create New Patient"), gridPane, hBox, save);
        newPatient.setContent(vBox);
        tabpane.getTabs().add(newPatient);
        tabpane.getSelectionModel().select(newPatient);


    }

    public void onMakeConsultation(ActionEvent actionEvent) {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 150);
        gridPane.setPadding(new Insets(10, 10, 0, 10));
        gridPane.setVgap(4);
        gridPane.setHgap(4);
        gridPane.setAlignment(Pos.BASELINE_LEFT);

        TextArea motif = new TextArea();
        TextArea diagnostic = new TextArea();
        TextArea traitement = new TextArea();
        TextArea note = new TextArea();

        motif.setWrapText(true);
        diagnostic.setWrapText(true);
        traitement.setWrapText(true);
        note.setWrapText(true);

        gridPane.add(new Label("motif"), 0, 0);
        gridPane.add(new Label("diagnostic"), 0, 1);
        gridPane.add(new Label("Traitement"), 0, 2);
        gridPane.add(new Label("note"), 0, 3);
        gridPane.add(motif, 1, 0);
        gridPane.add(diagnostic, 1, 1);
        gridPane.add(traitement, 1, 2);
        gridPane.add(note, 1, 3);


        TextField poids = new TextField();
        TextField taille = new TextField();
        TextField tomperature = new TextField();
        TextField pa_syst = new TextField();
        TextField pa = new TextField();
        GridPane gridPaneRIGHT = new GridPane();
        gridPaneRIGHT.setMinSize(600, 150);
        gridPaneRIGHT.setPadding(new Insets(10, 10, 0, 10));
        gridPaneRIGHT.setVgap(4);
        gridPaneRIGHT.setHgap(4);
        gridPaneRIGHT.setAlignment(Pos.BASELINE_RIGHT);
        gridPaneRIGHT.add(new Label("Poids"), 0, 0);
        gridPaneRIGHT.add(new Label("Taille"), 0, 1);
        gridPaneRIGHT.add(new Label("Tomperature"), 0, 2);
        gridPaneRIGHT.add(new Label("Pa"), 0, 3);
        gridPaneRIGHT.add(poids, 1, 0);
        gridPaneRIGHT.add(taille, 1, 1);
        gridPaneRIGHT.add(tomperature, 1, 2);
        gridPaneRIGHT.add(pa, 1, 3);
        HBox hBox = new HBox();
        hBox.getChildren().setAll(gridPane, gridPaneRIGHT);


        consultation.setContent(hBox);


        tabpane.getTabs().add(consultation);
        tabpane.getSelectionModel().select(consultation);


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

}



