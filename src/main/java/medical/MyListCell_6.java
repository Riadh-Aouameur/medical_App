package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class MyListCell_6 extends ListCell<Checkup> {
    @Override
    protected void updateItem(Checkup item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else {
            Label label =new Label(item+" ");
            label.setStyle("-fx-text-fill: #000;");
            label.setPrefSize(180,60);

            HBox hBox =new HBox();
            hBox.getChildren().addAll(label);
            setGraphic(hBox);
        }
        setText("");

        setText("");
    }



}
