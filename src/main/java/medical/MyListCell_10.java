package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class MyListCell_10 extends ListCell<Medicament> {
    static int a = 0;
    @Override
    protected void updateItem( Medicament item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("t1.fxml"));


            loader.setControllerFactory(e->{

                return new ControllerT1(item ,getIndex()+1);
            });
            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }





}
