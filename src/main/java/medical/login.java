package medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class login implements Initializable {
    @FXML
    PasswordField lpassword;
    @FXML
    TextField llastName;
    @FXML
    TextField lfirstName;
    @FXML
    TextField lidOfApproval;
    @FXML
    TextField lspecialties;
    @FXML
    TextField laddress;
    @FXML
    TextField lemail;
    @FXML
    TextField lphone;
    @FXML
    ComboBox lgender;
    @FXML
    TextField lyear;
    @FXML
    TextField lday;
    @FXML
    TextField lmonth;
    @FXML
    PasswordField lconfirmoassword;
    
    @FXML
    HBox p;
    @FXML
    AnchorPane p0;
    @FXML
    AnchorPane p1;
    @FXML
    AnchorPane p2;
    @FXML
    AnchorPane p3;
    DoctorInformationSingle single;





    AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1.toFront();
        lgender.setItems(FXCollections.observableArrayList("Male","Female"));




    }

    public void onNext_0(ActionEvent actionEvent) {



            try {
                root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

        Image icon = new Image(getClass().getResourceAsStream("img/img.png"));
        primaryStage.getIcons().add(icon);


            primaryStage.show();
            p.getScene().getWindow().hide();




    }

    public void onNext_3(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        Image icon = new Image(getClass().getResourceAsStream("img/img.png"));
        primaryStage.getIcons().add(icon);


        primaryStage.show();
        p.getScene().getWindow().hide();

    }

    public void onNext_1(ActionEvent actionEvent) {
        if(lfirstName.getText()!= null && llastName.getText() != null &&lpassword.getText()!=null&&lconfirmoassword.getText()!=null){
            if(lconfirmoassword.getText().equals(lpassword.getText())&&lconfirmoassword.getLength()>=8){
                p2.toFront();
            }
        }


    }

    public void onNext_2(ActionEvent actionEvent) {
        p3.toFront();
    }
}
