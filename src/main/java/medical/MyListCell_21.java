package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class MyListCell_21 extends ListCell<CheckupName> {
    @Override
    protected void updateItem(CheckupName item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)
            setGraphic(null);
        else {


            Label label =new Label(item.getName());
            label.setStyle("-fx-text-fill: #000;");
            setGraphic(label);
        }

        setText("");
    }

}
