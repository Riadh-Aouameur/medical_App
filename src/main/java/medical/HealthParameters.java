package medical;

import javafx.scene.control.CheckBox;

import javax.swing.text.View;

public class HealthParameters {
    String  name ;
    CheckBox checkBox;

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }



    public HealthParameters(String name) {
        this.name = name;
        this.checkBox = new CheckBox();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
