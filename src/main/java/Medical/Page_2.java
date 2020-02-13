package Medical;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import java.net.URL;
import java.util.ResourceBundle;


public class Page_2  implements Initializable {

    @FXML
    private TableView<Ordinance> tableView;

    @FXML
    private TableColumn<Ordinance,String> Medicament, Posologie;


    ObservableList<Ordinance> observableList = FXCollections.observableArrayList(
            new Ordinance("samir","benhami"),
            new Ordinance("samir","benhami")

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Medicament.setCellValueFactory(new PropertyValueFactory<>("medicament"));
        Posologie.setCellValueFactory(new PropertyValueFactory<>("Posologie"));
        tableView.setItems(observableList);
        tableView.setEditable(true);
        Medicament.setCellFactory(ComboBoxTableCell.forTableColumn());
        Posologie.setCellFactory(TextFieldTableCell.forTableColumn());


    }





}
