package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import medical.InformationForHistoryList;
import medical.Parameters;

public class MyListCell_8 extends ListCell<Parameters> {
    @Override
    protected void updateItem( Parameters item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else if (item.getType().equals("t1")){
            Label label =new Label(item.getA1().getName());
            label.setStyle("-fx-text-fill: #000;");
            label.setPrefSize(180,60);

            HBox hBox =new HBox();
            hBox.getChildren().addAll(label,item.getA1().getCheckBox());
            setGraphic(hBox);
        } else if (item.getType().equals("t2")){
            Label label =new Label(item.getA2().getName());
            label.setStyle("-fx-text-fill: #000;");
            label.setPrefSize(180,60);

            HBox hBox =new HBox();
            hBox.getChildren().addAll(label,item.getA2().getTextField());
            setGraphic(hBox);
        }
        setText("");

        setText("");
    }



}
