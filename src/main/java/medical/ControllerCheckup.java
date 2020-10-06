package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

public class ControllerCheckup implements Initializable {


    public AnchorPane textAge;
    public TextArea text;
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
    ListView  <CheckupName>list_1;
    @FXML
    TextField searchField;
    ObservableList<CheckupName> observableList_1;
    Db db= new Db();


    Patient patient;

    public ControllerCheckup(Patient patient) {
        this.patient = patient;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        fName.setText(patient.getFirstName()+" "+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");
        fPhone.setText(patient.getPhone());
        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fDate.setText(formatter.format(LocalDate.now()));

        list_1.setItems(observableList_1);
        list_1.setCellFactory(p->new MyListCell_5());



         observableList_1 =FXCollections.observableArrayList(db.getCheckupName());



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
        list_1.setItems(sortedLis);

    }

    public void onAddToList2(ActionEvent actionEvent) {
       String txt="";
       int j = 0;
        for(int i=0;i<observableList_1.size();i++){
            if(observableList_1.get(i).getChecked().isSelected()){
                String s =observableList_1.get(i).getName();
                j++;
                txt = txt+(j)+"- The Analysis "+s+"\n";
                text.setText(txt);
            }


        }
    }



    public void onPrint(ActionEvent actionEvent) {

        if (!text.getText().isEmpty()){


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Are you sure to save ?");
            alert.setTitle("CONFIRMATION");
            alert.setHeaderText("");

            ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getDialogPane().getButtonTypes().add(buttonCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                String content= text.getText();
                LocalDate date =LocalDate.now();

                Integer doctorID=Integer.parseInt(DoctorInformationSingle.getInstance(0).getDoctorID());
                Integer patientID = patient.getId();

                Checkup checkup =new Checkup( content,  date, doctorID, patientID);
                checkup.setId(db.InsertCheckup(checkup));

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/medical?autoReconnect=true&useSSL=false","root","1234");
                    String q = "SELECT checkup.content,checkup.checkupID,checkup.dateofcheckup,doctor.firstname,doctor.lastname,doctor.specialty,doctor.address,doctor.emailorphone,patient.firstname,patient.lastname,patient.birthday,patient.patientID\n" +
                            "FROM checkup\n" +
                            "INNER JOIN patient ON checkup.patientID = patient.patientID\n" +
                            "INNER JOIN doctor ON checkup.doctorID = doctor.doctorID\n" +
                            "where checkupID ="+checkup.getId();
                    JasperDesign jd = JRXmlLoader.load("src/main/resources/medical/jasper/Blank_A4_1.jrxml");
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
                    text.clear();

            }






        }else {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setContentText("Checkup List Is Empty");
            alert2.setTitle("INFORMATION");
            alert2.setHeaderText("");
            alert2.showAndWait();
        }
    }

    public void onOpenMedicalAnalysis(ActionEvent actionEvent) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("chakupAdd.fxml"));


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


        stage.setTitle("Medical Analysis");
        Image icon = new Image(getClass().getResourceAsStream("img/plus.png"));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(icon);
            stage.show();

    }
}
