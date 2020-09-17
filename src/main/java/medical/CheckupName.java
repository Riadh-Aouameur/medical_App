package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class CheckupName {
    SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public CheckBox checked;

    public CheckupName(String name) {
        this.name = new SimpleStringProperty(name);
        this.checked = new CheckBox();
        this.id = new SimpleIntegerProperty();

    }
    public CheckupName(String name,Integer id) {
        this.name = new SimpleStringProperty(name);
        this.checked = new CheckBox();
        this.id = new SimpleIntegerProperty(id);

    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public CheckBox getChecked() {
        return checked;
    }

    public void setChecked(CheckBox checked) {
        this.checked = checked;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
