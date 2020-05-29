package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class login implements Initializable {
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




    AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p0.toFront();
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
    }

    public void onNext_1(ActionEvent actionEvent) {
    }

    public void onNext_2(ActionEvent actionEvent) {
    }
}
