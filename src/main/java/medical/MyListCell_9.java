package medical;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import medical.CheckupName;
import medical.ModelPrescription;

public class MyListCell_9 extends ListCell<ModelPrescription> {
    @Override
    protected void updateItem(ModelPrescription item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null ) {
            setGraphic(null);
        } else {
            Label label =new Label(item.getName()+" ");
            label.setStyle("-fx-text-fill: #000;");
            label.setPrefSize(180,30);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(label);
            setGraphic(hBox);
        }
        setText("");

        setText("");
    }



}
