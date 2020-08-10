package medical;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Document {
    SimpleIntegerProperty id;
     SimpleStringProperty content;
     SimpleStringProperty type;
     SimpleObjectProperty <LocalDate>date;

    public Document( String content, String type, LocalDate date) {
        this.id = new SimpleIntegerProperty();
        this.content =  new SimpleStringProperty(content);
        this.type = new SimpleStringProperty( type);
        this.date = new SimpleObjectProperty<>(date);
    }
    public Document(int id , String content, String type, LocalDate date) {
        this.id = new SimpleIntegerProperty(id);
        this.content =  new SimpleStringProperty(content);
        this.type = new SimpleStringProperty( type);
        this.date = new SimpleObjectProperty<>(date);
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

    public String getContent() {
        return content.get();
    }

    public SimpleStringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
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

    public LocalDate getDate() {
        return date.get();
    }

    public SimpleObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }
}
