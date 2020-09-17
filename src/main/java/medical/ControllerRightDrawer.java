package medical;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import medical.DataBase.Db1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRightDrawer implements Initializable {

    public Label firstLastName;
    public ImageView imageGender;
    public ListView <APatientForWaitingRoom>listView;
    public JFXButton next;
    public Label firstLastName1;
    public AnchorPane r1;
    public AnchorPane r2;
    ObservableList<APatientForWaitingRoom> observableList = FXCollections.observableArrayList();
    int i =0 ;

    public void onSetPaneList(ActionEvent actionEvent) {
        r2.toFront();
    }

    public void onSetPanePatient(ActionEvent actionEvent) {
        r1.toFront();
    }

    public void onOpenNewPatient(ActionEvent actionEvent) throws IOException {

        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("createPatient.fxml"));
       APatientForWaitingRoom patient= listView.getSelectionModel().getSelectedItem();
        loader.setControllerFactory(e->{


            return new newPatient(patient);

        });

        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public class PThread extends Thread{
        public PThread() {
            Db1 db1 = new Db1();
            observableList.setAll(db1.getPatientData());
            listView.setItems(observableList);
            listView.setCellFactory(param -> new MyListCell_11());

        }

        @Override
        public void run() {

           while (true){





                try {
                    Thread.sleep(20*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               Platform.runLater(new Runnable() {
                   @Override
                   public void run() {
                       Db1 db1 = new Db1();
                       observableList.setAll(db1.getPatientData());
                       if (!observableList.isEmpty()){
                           APatientForWaitingRoom aPatientForWaitingRoom =observableList.get(i);
                           firstLastName.setText(aPatientForWaitingRoom.getFirstName()+" "+aPatientForWaitingRoom.getLastName());
                           if(aPatientForWaitingRoom.getGender().equals("Female")){
                               Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                               imageGender.setImage(imProfile);
                           }else {
                               Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                               imageGender.setImage(imProfile);
                           }

                       }





                   }

               });
            }



        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


       PThread pg_thread =new PThread();
        pg_thread.start();
    }

    public void onLast(ActionEvent actionEvent) {
        if (i==observableList.size()-1){
          i=0;

        firstLastName.setText("work");
            APatientForWaitingRoom aPatientForWaitingRoom =observableList.get(i);
            firstLastName.setText(aPatientForWaitingRoom.getFirstName()+" "+aPatientForWaitingRoom.getLastName());
            if(aPatientForWaitingRoom.getGender().equals("Female")){
                Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                imageGender.setImage(imProfile);
            }else {
                Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                imageGender.setImage(imProfile);
            }
        }
        else {
            i++;
            APatientForWaitingRoom aPatientForWaitingRoom =observableList.get(i);
            firstLastName.setText(aPatientForWaitingRoom.getFirstName()+" "+aPatientForWaitingRoom.getLastName());
            if(aPatientForWaitingRoom.getGender().equals("Female")){
                Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                imageGender.setImage(imProfile);
            }else {
                Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                imageGender.setImage(imProfile);
            }

        }

    }

    public void onNext(ActionEvent actionEvent) {
        if (i==0){
            i=observableList.size()-1;
            System.out.println(i+" : i");
            APatientForWaitingRoom aPatientForWaitingRoom =observableList.get(i);
            firstLastName.setText(aPatientForWaitingRoom.getFirstName()+" "+aPatientForWaitingRoom.getLastName());
            if(aPatientForWaitingRoom.getGender().equals("Female")){
                Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                imageGender.setImage(imProfile);
            }else {
                Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                imageGender.setImage(imProfile);
            }
        }
        else {
            i--;
            APatientForWaitingRoom aPatientForWaitingRoom =observableList.get(i);
            firstLastName.setText(aPatientForWaitingRoom.getFirstName()+" "+aPatientForWaitingRoom.getLastName());
            if(aPatientForWaitingRoom.getGender().equals("Female")){
                Image imProfile = new Image(getClass().getResourceAsStream("img/femalepatient.png"));
                imageGender.setImage(imProfile);
            }else {
                Image imProfile = new Image(getClass().getResourceAsStream("img/patient.png"));
                imageGender.setImage(imProfile);
            }



        }

        }
    }

