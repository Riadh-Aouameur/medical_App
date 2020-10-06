package medical;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import medical.DataBase.Db;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerPatients implements Initializable {



    public ListView <Patient>waitingList;
    public RadioButton rWaiting;
    public RadioButton rAll;
    public RadioButton rPass;
    Db db = new Db();
    public ToggleGroup group;
    ObservableList<Patient> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        group = new ToggleGroup();

        rAll.setToggleGroup(group);
        rPass.setToggleGroup(group);
        rWaiting.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    String status=button.getText();
                    if(status.equals("All")){
                        observableList.setAll(db.getPatientData());
                    }
                    else if (status.equals("Active")){
                        observableList.setAll(db.getPatientDataActive());
                    }else {
                        observableList.setAll(db.getPatientDataNoActive());
                    }


                    System.out.println(LocalDate.now().minusDays(1));

                }
            }
        });
        
        observableList.setAll(db.getPatientData());
        rAll.fire();
        waitingList.setItems(observableList);
       waitingList.setCellFactory(pp->new MyListCell_14());
        
    }

    Stage primaryStage ;
    public void onAdd(ActionEvent actionEvent) throws IOException {
        if(primaryStage== null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
            loader.setControllerFactory(e->{

                return new ControllerAdd(observableList);
            });




            primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            Image icon = new Image(getClass().getResourceAsStream("img/adduser.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("New Patient");
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add.fxml"));
            loader.setControllerFactory(e->{

                return new ControllerAdd(observableList);
            });



            primaryStage.close();
            primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            Image icon = new Image(getClass().getResourceAsStream("img/adduser.png"));
            primaryStage.getIcons().add(icon);
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        }

    }






    Stage primaryStage4;
     public void onDeletePatient(ActionEvent actionEvent) throws IOException {
         if(primaryStage4== null){
             if(!observableList.isEmpty()){
                 Patient patient= waitingList.getSelectionModel().getSelectedItem();
                 waitingList.getSelectionModel().clearSelection();
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("ddelete.fxml"));
                 loader.setControllerFactory(e->{

                     return new ControllerDelete(observableList,patient);
                 });





                 primaryStage4 = new Stage();
                 primaryStage4.initStyle(StageStyle.TRANSPARENT);
                 Image icon = new Image(getClass().getResourceAsStream("img/delete1.png"));
                 primaryStage4.getIcons().add(icon);
                 primaryStage4.setTitle("Delete");
                 primaryStage4.setScene(new Scene(loader.load()));
                 primaryStage4.show();
             }
         }else {
             if(!observableList.isEmpty()){
                 Patient patient= waitingList.getSelectionModel().getSelectedItem();
                 waitingList.getSelectionModel().clearSelection();
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("ddelete.fxml"));
                 loader.setControllerFactory(e->{

                     return new ControllerDelete(observableList,patient);
                 });




                 primaryStage4.close();
                 primaryStage4 = new Stage();
                 primaryStage4.initStyle(StageStyle.TRANSPARENT);
                 Image icon = new Image(getClass().getResourceAsStream("img/delete1.png"));
                 primaryStage4.getIcons().add(icon);
                 primaryStage4.setTitle("Delete");
                 primaryStage4.setScene(new Scene(loader.load()));
                 primaryStage4.show();
             }
         }

//

    }





    Stage primaryStage6;
    public void onOpenModify(ActionEvent actionEvent) throws IOException {
        Patient patient= waitingList.getSelectionModel().getSelectedItem();
        int index= waitingList.getSelectionModel().getSelectedIndex();
        waitingList.getSelectionModel().clearSelection();

        if(primaryStage6== null){
            if(patient!= null){


                FXMLLoader loader = new FXMLLoader(getClass().getResource("modify.fxml"));
                loader.setControllerFactory(e->{

                    return new ControllerModify(observableList,patient,index);
                });





                primaryStage6 = new Stage();
                primaryStage6.initStyle(StageStyle.TRANSPARENT);
                Image icon = new Image(getClass().getResourceAsStream("img/pencil.png"));
                primaryStage6.getIcons().add(icon);
                primaryStage6.setTitle("Modify");
                primaryStage6.setScene(new Scene(loader.load()));
                primaryStage6.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Select Patient");
                alert.setTitle("INFORMATION");
                alert.setHeaderText("");
                alert.showAndWait();
            }
        }else {
            primaryStage6.close();
            if(patient!= null){


                FXMLLoader loader = new FXMLLoader(getClass().getResource("modify.fxml"));
                loader.setControllerFactory(e->{

                    return new ControllerModify(observableList,patient,index);
                });





                primaryStage6 = new Stage();
                primaryStage6.initStyle(StageStyle.TRANSPARENT);
                Image icon = new Image(getClass().getResourceAsStream("img/pencil.png"));
                primaryStage6.getIcons().add(icon);
                primaryStage6.setTitle("Modify");
                primaryStage6.setScene(new Scene(loader.load()));
                primaryStage6.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Select Patient");
                alert.setTitle("INFORMATION");
                alert.setHeaderText("");
                alert.showAndWait();
            }
        }



    }
}
