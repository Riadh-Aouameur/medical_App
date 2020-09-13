package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class MyListCell_11 extends ListCell<APatientForWaitingRoom> {

    @Override
    protected void updateItem( APatientForWaitingRoom item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("waitItem.fxml"));


            loader.setControllerFactory(e->{

                return new ControllerWaitList(item);
            });
            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }





}
