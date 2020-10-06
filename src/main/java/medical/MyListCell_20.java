package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class MyListCell_20 extends ListCell<MedicamentName> {
    @Override
    protected void updateItem(MedicamentName item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)
            setGraphic(null);
        else {


            Label label =new Label(item.getNameDosage() +" "+item.getDosage());
            label.setStyle("-fx-text-fill: #000;");
            setGraphic(label);
        }

        setText("");
    }

}
