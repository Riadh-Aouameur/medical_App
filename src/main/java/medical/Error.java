package medical;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Error implements Initializable {
    @FXML
     Label label;
    String message;

    public Error(String message){
        this.message = message;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setWrapText(true);
        label.setText(message);
    }

    public void onMinButton(ActionEvent actionEvent) {
    }

    public void onMaxButton(ActionEvent actionEvent) {
    }

    public void onClose(ActionEvent actionEvent) {
    }
}
