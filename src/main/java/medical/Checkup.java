package medical;

import javafx.beans.property.SimpleStringProperty;

public class Checkup {
    SimpleStringProperty name;
    public Checkup(CheckupName checkupName ) {
        this.name =new SimpleStringProperty( checkupName.getName());
    }
    public Checkup(String name ) {
        this.name =new SimpleStringProperty(name);
    }



    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
