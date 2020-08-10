package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import medical.Checkup;
import medical.InformationForHistoryList;

public class MyListCell_7 extends ListCell<InformationForHistoryList> {
    @Override
    protected void updateItem(InformationForHistoryList item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else {
            Label label =new Label(item.getType()+"  "+item.getDate());
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
