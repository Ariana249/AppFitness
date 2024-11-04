package src;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class PerfilController implements Initializable {
    
    Connection conn = ConeccionDB.connect();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
