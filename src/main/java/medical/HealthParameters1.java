package medical;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class HealthParameters1 {
    String  name ;

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    TextField textField;





    public HealthParameters1(String name) {
        this.name = name;
        this.textField= new TextField();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
