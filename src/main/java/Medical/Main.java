package Medical;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{



//        Image image = new Image("Medical/dr.png");
//        Stage root_2 = new Stage();
//        root_2.setTitle("Doctor");
//        FXMLLoader loader = new FXMLLoader(new File("D:\\IntelliJProject\\src\\main\\resources\\Medical\\WorkPage.fxml").toURI().toURL());
//        Parent roo = loader.load();
//        VBox box_2 =new VBox();
//        root_2.setMaximized(true);
//        root_2.setScene(new Scene(roo));
//
//        // primaryStage.resizableProperty().setValue(Boolean.FALSE);
//        //  primaryStage.initStyle(StageStyle.UTILITY);
//        //primaryStage.initStyle(StageStyle.UTILITY);
//
//
//        ImageView iv1 = new ImageView();
//        iv1.setFitHeight(300);
//        iv1.setFitWidth(300);
//        iv1.setImage(image);
//        iv1.setOnMouseClicked(event -> {
//
//
//             root_2.show();
//            primaryStage.close();
//        });
//
//        HBox box = new HBox();
//        box.getChildren().add(iv1);
//
//
//        StackPane root = new StackPane();
//        root.getChildren().add(box);
        FXMLLoader loader = new FXMLLoader(new File("D:\\My Project\\AppDoctor\\src\\main\\resources\\Medical\\startpage.fxml").toURI().toURL());
       Parent root = loader.load();
//        FXMLLoader loader1 = new FXMLLoader(new File("D:\\My Project\\AppDoctor\\src\\main\\resources\\Medical\\WorkPage.fxml").toURI().toURL());
//        Parent root_1 = loader1.load();


        primaryStage.setTitle("Hello World!");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}