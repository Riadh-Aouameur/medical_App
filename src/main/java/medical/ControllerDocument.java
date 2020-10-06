package medical;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import medical.DataBase.Db;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ControllerDocument implements Initializable {
    public ImageView imgeGander;
    public TextField fName;
    public TextField fBirthday;
    public TextField fPhone;
    public TextField fAge;
    public TextField fDate;


    String  content;
    String  type;
    public TextArea documentContent;
    public ComboBox <String>documentType;
    Patient patient;
    public ControllerDocument(Patient patient)
    {
        this.patient = patient;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(patient.getGender().equals("female")){
            Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
            imgeGander.setImage(imProfile);
        }
        documentType.setItems(FXCollections.observableArrayList("Letter","Work absences"));
        documentType.setButtonCell(new MyListCell_22());
        fName.setText(patient.getFirstName()+" "+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");
        fPhone.setText(patient.getPhone());
        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fDate.setText(formatter.format(LocalDate.now()));
    }
    public void onSaveAndPrint(ActionEvent actionEvent) {
        boolean a= false;
        boolean b= false;

        if (documentContent.getText()== null||documentContent.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Document Content Empty");
            alert.setTitle("INFORMATION");
            alert.setHeaderText("");
            alert.showAndWait();
            return;
        }else {
            content = documentContent.getText();
            a = true ;
        }
        if (documentType.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Select Type Of Document");
            alert.setTitle("INFORMATION");
            alert.setHeaderText("");
            alert.showAndWait();
            return;
        }else {
            type = documentType.getSelectionModel().getSelectedItem();
            b =true;
        }
      if (a&&b){

          int doctorID =Integer.parseInt(DoctorInformationSingle.getInstance(0).getDoctorID());
          Document document = new Document(content,type,LocalDate.now(),doctorID,patient.getId());


          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setContentText("Are you sure to save ?");
          alert.setTitle("CONFIRMATION");
          alert.setHeaderText("");

          ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
          alert.getDialogPane().getButtonTypes().add(buttonCancel);
          Optional <ButtonType> result = alert.showAndWait();
          if (result.isPresent() && result.get() == ButtonType.OK){
              Db db = new Db();

              db.Insert(document);

              try {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/medical?autoReconnect=true&useSSL=false","root","1234");
                  String q = "SELECT document.content,document.documentID,document.dateofdocumentdate ,document.typeofdocument,doctor.firstname,doctor.lastname,doctor.specialty,doctor.address,doctor.emailorphone,patient.firstname,patient.lastname,patient.birthday,patient.patientID\n" +
                          "FROM document\n" +
                          "INNER JOIN patient ON document.patientID = patient.patientID\n" +
                          "INNER JOIN doctor ON document.doctorID = doctor.doctorID\n" +
                          "\n" +
                          " where documentID ="+document.getId();
                  JasperDesign jd = JRXmlLoader.load("src/main/resources/medical/jasper/Blank_A4.jrxml");
                  JRDesignQuery jrDesignQuery = new JRDesignQuery();
                  jrDesignQuery.setText(q);
                  jd.setQuery(jrDesignQuery);


                  JasperReport jr = JasperCompileManager.compileReport(jd);
                  Map<String, Object> param = new HashMap<String, Object>();
                  JasperPrint jP = JasperFillManager.fillReport(jr,param,con);
                 content = null;
                    documentContent.clear();

                  JasperViewer.viewReport(jP,false);
              } catch (Exception e) {
                  Alert alert1 = new Alert(Alert.AlertType.ERROR);
                  alert1.setContentText(e.getMessage());
                  alert1.setTitle("Error");
                  alert1.setHeaderText("");
                  alert1.show();
              }




          }
      }




    }




    public void onSearch(ActionEvent actionEvent) {
    }


}
