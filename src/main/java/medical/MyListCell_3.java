package medical;

import javafx.scene.control.ListCell;

class MyListCell_3 extends ListCell<CheckupName> {
    @Override
    protected void updateItem(CheckupName item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)

            setGraphic(null);
        else {











                setGraphic(null);

        }

        setText("");
    }



}
