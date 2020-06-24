import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setOnMouseClicked(event -> {
            Pane rooot = new Pane();
            Stage primar = new Stage();
            primar.setScene( new Scene(rooot, 250, 150) );
            primar.show();
        });
        primaryStage.setScene( new Scene(root, 250, 150) );
        primaryStage.show();
    }


    public static void main(String[]args){
        launch(args);
        }





    }

