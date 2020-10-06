package medical;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDelete implements Initializable {
    public Label fPatient;


    public ImageView img;

    public AnchorPane paneMassage;
    public Label message;
    public AnchorPane root;

    public Label fPhone;
    public Label fStats;
   private double x;
    private  double y;
    public TextField fnb;
Db db = new Db();
    ObservableList<Patient> observableList;
Patient patient;

    public ControllerDelete(ObservableList<Patient> observableList, Patient patient) {
        this.observableList = observableList;
        this.patient = patient;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        root.setOnMousePressed(mouseEvent -> {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(e->{
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX()-x);
            stage.setY(e.getScreenY()-y);
        });
        if (patient!=null){
            fPatient.setText("Patient : "+patient.getFirstName()+" "+patient.getLastName());
            fPhone.setText("Phone : "+patient.getPhone());
            fStats.setText("Status : "+patient.getStatus());
            if (patient.getGender().equals("Female")){
                Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                img.setImage(imProfile);
            }else {
                Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                img.setImage(imProfile);
            }
        }
        fnb.lengthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {

                    if (fnb.getText().length() >= 2) {


                        fnb.setText(fnb.getText().substring(0, 2));
                    }
                }
            }
        });
        fnb.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fnb.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }


    public void onDelete(ActionEvent actionEvent) {
        if (patient !=null){
            db.deletePatient(patient.getId());
            observableList.remove(patient);
            message.setText("Successful");
            fPatient.setText("Patient : ...");
            fPhone.setText("Phone :... ");
            fStats.setText("Status :... ");
            patient= null;


        }else {
            message.setText("No Patient Selected");
            paneMassage.setVisible(true);
        }

    }

    public void onExit(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();

    }
    public void onSelect(ActionEvent actionEvent) {
        int id;
        if(fnb.getText().isEmpty()){
            message.setText("Enter Your Patient ID");
            paneMassage.setVisible(true);
        }
        else{
            try {
                 id = Integer.parseInt(fnb.getText());
                 for (Patient p :observableList){
                     if(p.getId()==id){
                         patient = p;
                         fPatient.setText("Patient : "+patient.getFirstName()+" "+patient.getLastName());
                         fPhone.setText("Phone : "+patient.getPhone());
                         fStats.setText("Status : "+patient.getStatus());
                         if (patient.getGender().equals("Female")){
                             Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                             img.setImage(imProfile);
                         }else {
                             Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                             img.setImage(imProfile);
                         }
                         return;
                     }
                 }

                fPatient.setText("Patient : ...");
                fPhone.setText("Phone :... ");
                fStats.setText("Status :... ");
                message.setText("Out Of Rang");
                paneMassage.setVisible(true);

            }catch (Exception e){

            }

        }
    }


}
