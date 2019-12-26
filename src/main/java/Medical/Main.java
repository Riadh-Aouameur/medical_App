package Medical;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Db b= new Db();
        System.out.println("hello world");
        primaryStage.setTitle("Hello World!");
        Image image = new Image("Medical/dr.png");
        Stage a = new Stage();
        a.setTitle("Doctor");
        a.setScene(new Scene(new StackPane()));

        // primaryStage.resizableProperty().setValue(Boolean.FALSE);
        //  primaryStage.initStyle(StageStyle.UTILITY);
        //primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        ImageView iv1 = new ImageView();
        iv1.setFitHeight(300);
        iv1.setFitWidth(300);
        iv1.setImage(image);
        iv1.setOnMouseClicked(event -> {
            b.Show();
            a.show();
            primaryStage.close();
        });

        HBox box = new HBox();
        box.getChildren().add(iv1);


        StackPane root = new StackPane();
        root.getChildren().add(box);

        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.show();

    }
}