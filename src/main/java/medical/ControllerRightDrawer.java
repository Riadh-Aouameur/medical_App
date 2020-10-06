package medical;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import medical.DataBase.Db;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRightDrawer implements Initializable {


    public ImageView imageGender;
    public ListView <APatientForWaitingRoom>listView;


    public AnchorPane r1;
    public AnchorPane r2;
    Db db = new Db();
    ObservableList<APatientForWaitingRoom> observableList = FXCollections.observableArrayList();
    int i =0 ;

    public void onSetPaneList(ActionEvent actionEvent) {
        r2.toFront();
    }



    public void onOpenNewPatient(ActionEvent actionEvent) throws IOException {
        APatientForWaitingRoom patient= listView.getSelectionModel().getSelectedItem();
        listView.getSelectionModel().clearSelection();
        if(patient != null){
            ObservableList<Patient> observableList = db.getPatientPatient(patient.getFirstName() ,patient.getLastName()) ;
            if(observableList.isEmpty()){
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("createPatient.fxml"));

                loader.setControllerFactory(e->{


                    return new newPatient(patient);

                });

                Parent root = loader.load();
                primaryStage.initStyle(StageStyle.TRANSPARENT);
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
            else {
                System.out.println(observableList.get(0).getFirstName());
                Stage primaryStage = new Stage();
                primaryStage.initStyle(StageStyle.UTILITY);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("litstOldPatient.fxml"));

                loader.setControllerFactory(e->{


                    return  new ControllerOldPatient(observableList);

                });

                AnchorPane root = loader.load();

                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }
        }
        else {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("createPatient.fxml"));

            loader.setControllerFactory(e->{


                return new newPatient(patient);

            });

            Parent root = loader.load();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }


    }


    public class PThread extends Thread{
        public PThread() {

            observableList.setAll(db.getPatientDataa());
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
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setContentText(e.getMessage());
                    alert2.setTitle("ERROR");
                    alert2.setHeaderText("");
                    alert2.showAndWait();
                }
               Platform.runLater(new Runnable() {
                   @Override
                   public void run() {

                       observableList.setAll(db.getPatientDataa());





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


    }

