package medical;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    Boolean aBoolean = true;


    @Override
    public void start(Stage primaryStage) throws Exception{

        if (aBoolean==false) {

            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            primaryStage.setTitle("");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();



        }else {

            Parent root = FXMLLoader.load(getClass().getResource("login_1.fxml"));
            primaryStage.setTitle("");
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }


    }
    public static void main(String[] args) {
        launch(args);
    }
}