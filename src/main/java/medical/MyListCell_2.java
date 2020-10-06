package medical;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

 public  class MyListCell_2 extends ListCell<Medicament> {
    @Override
    protected void updateItem(Medicament item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty)

            setGraphic(null);
        else {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("midicament.fxml"));

            loader.setControllerFactory(c -> {
                return new ControllerMedicament(item);
            });
            HBox Box =new HBox();
            Button btn = new Button();
            btn.getStylesheets().add("Css/button1.css");


            btn.setOnAction(e->getListView().getItems().remove(item));


            Image image = new Image("medical/img/delete.png", 35, 35, false, false);
            btn.setGraphic(new ImageView(image));


            try {
                Box.getChildren().addAll(loader.load(),btn);
            } catch (IOException e) {
                e.printStackTrace();
            }



                setGraphic(Box);

        }

        setText("");
    }



}
