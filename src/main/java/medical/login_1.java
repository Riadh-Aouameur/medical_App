package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class login_1 implements Initializable {
    BorderPane root;
    @FXML
    HBox p;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);

        Image icon = new Image(getClass().getResourceAsStream("img/img.png"));
        primaryStage.getIcons().add(icon);


        primaryStage.show();
        p.getScene().getWindow().hide();
    }
}
