package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class MyListCell_12 extends ListCell<Document> {
    @Override
    protected void updateItem( Document item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("h2.fxml"));


            loader.setControllerFactory(e->{

                return new ControllerH2(item);
            });
            try {
                setGraphic(loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }





}
