package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class MyListCell_14 extends ListCell<Patient> {
    static int a = 0;
    @Override
    protected void updateItem(Patient item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("itemPatients.fxml"));
            loader.setControllerFactory(e->{

                return new ControllerListItemPatients(item);
            });


            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }





}
