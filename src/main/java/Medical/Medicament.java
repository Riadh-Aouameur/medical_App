package Medical;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class Medicament implements Initializable {
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;
    @FXML
 AnchorPane root;
    String ll1;
    String ll2;
    String ll3;


 public Medicament(String l1 ,String l2,String l3){
   this.ll1=l1;
   this.ll2=l2;
   this.ll3=l3;

 }

    public void onDelete(ActionEvent actionEvent) {
        ((VBox) root.getParent()).getChildren().remove(root);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l1.setText(ll1);
        l2.setText(ll2);
        l3.setText(ll3);
    }
}
