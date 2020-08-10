package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import medical.CheckupName;

public class MyListCell_5 extends ListCell<CheckupName> {
    @Override
    protected void updateItem(CheckupName item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else {
            Label label =new Label(item.getName()+" ");
            label.setStyle("-fx-text-fill: #000;");
            label.setPrefSize(180,60);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(label,item.getChecked());
            setGraphic(hBox);
        }
        setText("");

        setText("");
    }



}
