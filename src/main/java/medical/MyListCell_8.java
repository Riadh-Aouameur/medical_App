package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import medical.InformationForHistoryList;
import medical.Parameters;

import java.io.IOException;

public class MyListCell_8 extends ListCell<Prescription> {
    @Override
    protected void updateItem( Prescription item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("h1.fxml"));


            loader.setControllerFactory(e->{

                return new ControllerH1(item);
            });
            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }





}
