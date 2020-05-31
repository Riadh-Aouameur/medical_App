package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    Boolean aBoolean = false;




    AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (aBoolean==false) {
            p0.toFront();
            single =new DoctorInformationSingle("demo","Deom","Deom","Deom","Deom","Deom","Deom","Deom","Deom");



        }else {
            p1.toFront();
        }


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
            Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
            primaryStage.setX(primaryScreenBounds.getMinX());
            primaryStage.setY(primaryScreenBounds.getMinY());

            primaryStage.setMaxWidth(primaryScreenBounds.getWidth());
            primaryStage.setMinWidth(primaryScreenBounds.getWidth());

            primaryStage.setMaxHeight(primaryScreenBounds.getHeight());
            primaryStage.setMinHeight(primaryScreenBounds.getHeight());
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setTitle("Assistant");
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
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());

        primaryStage.setMaxWidth(primaryScreenBounds.getWidth());
        primaryStage.setMinWidth(primaryScreenBounds.getWidth());

        primaryStage.setMaxHeight(primaryScreenBounds.getHeight());
        primaryStage.setMinHeight(primaryScreenBounds.getHeight());
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Assistant");
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
