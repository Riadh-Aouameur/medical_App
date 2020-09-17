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
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDelete implements Initializable {
    public Label fPatient;
    public Label lab1;

    public ImageView img;
    public Label text;
    public AnchorPane root1;
    public Label fDateTwo;
    public Label fDateOne;
    public Label fPhone;
    public Label fStats;
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
                    // Check if the new character is greater than LIMIT
                    if (fnb.getText().length() >= 2) {

                        // if it's 11th character then just setText to previous
                        // one
                        fnb.setText(fnb.getText().substring(0, 2));
                    }
                }
            }
        });

    }


    public void onDelete(ActionEvent actionEvent) {
        if (patient !=null){
            db.deletePatient(patient.getId());
            observableList.remove(patient);
            patient= null;
            text.setVisible(true);

        }

    }

    public void onExit(ActionEvent actionEvent) {
        System.exit(0);

    }

    public void onSelect(ActionEvent actionEvent) {
        int id;
        if(fnb.getText().isEmpty()){
            lab1.setText("Enter your patient number");
        }
        else{
            try {
                 id = Integer.parseInt(fnb.getText());
                 for (Patient p :observableList){
                     if(p.getId()==id){
                         patient = p;
                     }
                 }
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


            }catch (Exception e){
                lab1.setText("Something is wrong");
            }

        }
    }


}
