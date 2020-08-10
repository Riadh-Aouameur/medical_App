import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class t extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        AutoCompleteTextField autoCompleteTextField =new AutoCompleteTextField();
        VBox vBox =new VBox();
        autoCompleteTextField.getEntries().addAll(Arrays.asList("AA", "AB", "AC","BCA"));
        vBox.getChildren().addAll(autoCompleteTextField);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Printing Nodes");
        stage.show();

    }
}
