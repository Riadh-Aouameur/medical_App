package Medical;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Ordinance implements Initializable {
@FXML
TextArea textMedi ;
@FXML
TextField textQuantity ;

@FXML
ComboBox textType;
@FXML
ComboBox textPoad;

@FXML
ComboBox textBam;
@FXML
ComboBox textEvery;
@FXML
VBox vBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        textType.setItems(FXCollections.observableArrayList());
        textEvery.setItems(FXCollections.observableArrayList());
        textBam.setItems(FXCollections.observableArrayList());
        textPoad.setItems(FXCollections.observableArrayList());

    }

    public void onAdd(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("midicament.fxml"));

        loader.setControllerFactory(c -> {
            return new Medicament("vfvf","rvvr","rvaavr" +
                    "a");
        });

        AnchorPane anchorPane = loader.load();
       vBox.getChildren().add(anchorPane);











    }

    public void onModify(ActionEvent actionEvent) {

    }

    public void onPrinted(ActionEvent actionEvent) {

    }

    public void onSave(ActionEvent actionEvent) {

    }
}
