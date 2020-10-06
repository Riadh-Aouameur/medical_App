package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class MyListCell_16 extends ListCell<Checkup> {
    @Override
    protected void updateItem(Checkup item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else {
            Label label =new Label("Prescription  ");
            Label label2 =new Label("ID : "+item.getId());
            Label label3 =new Label("Date : "+item.getDate());
            label.setStyle("-fx-text-fill: #000;");
            label.setPrefSize(180,20);

            VBox Box =new VBox();
            Box.getChildren().addAll(label,label2,label3);
            setGraphic(Box);
        }
        setText("");

        setText("");
    }



}
