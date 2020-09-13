package medical;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import medical.DataBase.Db;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerH2 implements Initializable {

    public Label t1;
    public Label t2;
    public Label t3;
    public Label t4;
    public Label i1;
    public Label i2;
    public Label i3;
    public Label i4;

    public TextArea content;
    public Label type;
  Document document ;

    public ControllerH2(Document document) {
        this.document = document;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        Db db = new Db() ;
        DoctorInformation doctorInformation = db.getDoctor(document.getDoctorID());
        t1.setText(doctorInformation.getFirstName());









    }
}
