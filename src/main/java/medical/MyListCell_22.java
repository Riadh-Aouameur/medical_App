package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class MyListCell_22 extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)
            setGraphic(null);
        else {

            Label label =new Label(item);
            label.setStyle("-fx-text-fill: #fff;");
            setGraphic(label);
        }

        setText("");
    }

}
