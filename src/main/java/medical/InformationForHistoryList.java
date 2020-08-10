package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class InformationForHistoryList {

    SimpleIntegerProperty id;

    SimpleStringProperty type;
    SimpleObjectProperty date ;

    public InformationForHistoryList(Integer id,  String type, LocalDate date) {
        this.id =new SimpleIntegerProperty( id);

        this.type = new SimpleStringProperty(type);
        this.date = new SimpleObjectProperty(date);
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





    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public Object getDate() {
        return date.get();
    }

    public SimpleObjectProperty dateProperty() {
        return date;
    }

    public void setDate(Object date) {
        this.date.set(date);
    }
}
