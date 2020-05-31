package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

class MyListCell_3 extends ListCell<checkupName> {
    @Override
    protected void updateItem(checkupName item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)

            setGraphic(null);
        else {











                setGraphic(null);

        }

        setText("");
    }



}
