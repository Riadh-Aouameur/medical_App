package medical;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import medical.DataBase.Db;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

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
        documentType.setItems(FXCollections.observableArrayList("t1","t2","t3"));
        fName.setText(patient.getFirstName()+"\t"+patient.getLastName());
        fBirthday.setText(patient.getBirthday().toString());
        LocalDate b= (LocalDate) patient.getBirthday();
        Calendar c =Calendar.getInstance();
        int i =c.get(Calendar.YEAR)-b.getYear();
        fAge.setText(i+"");
        DateTimeFormatter formatter =DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        fDate.setText(formatter.format(LocalDate.now()));
    }
    public void onSaveAndPrint(ActionEvent actionEvent) {
        boolean a= false;
        boolean b= false;

        if (documentContent.getText()== null||documentContent.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Document content vied");
            alert.setTitle("");
            alert.setHeaderText("");
            alert.showAndWait();
        }else {
            content = documentContent.getText();
            a = true ;
        }
        if (documentType.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Select type of document");
            alert.setTitle("");
            alert.setHeaderText("");
            alert.showAndWait();
        }else {
            type = documentType.getSelectionModel().getSelectedItem();
            b =true;
        }
      if (a&&b){
          Document document = new Document(content,type,LocalDate.now());


          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setContentText("");
          alert.setTitle("");
          alert.setHeaderText("");

          ButtonType buttonCancel=  new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
          alert.getDialogPane().getButtonTypes().add(buttonCancel);
          Optional <ButtonType> result = alert.showAndWait();
          if (result.isPresent() && result.get() == ButtonType.OK){
              Db db = new Db();
              db.Insert(document,patient.getId());

              System.out.println("save");


          }
      }




    }




    public void onSearch(ActionEvent actionEvent) {
    }


}
