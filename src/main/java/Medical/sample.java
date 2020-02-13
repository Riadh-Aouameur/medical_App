package Medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class sample {


    @FXML
    void OnAddOrdonnons(ActionEvent event) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(new File("D:\\My Project\\AppDoctor\\src\\main\\resources\\Medical\\Page_2.fxml").toURI().toURL());
        Parent root = loader2.load();
        Stage stage =new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
