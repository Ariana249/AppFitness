package src;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EliminarComidaController implements Initializable {

    @FXML
    private Button volver;
    
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        
    }  
   
    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/dieta.fxml", "FITCOMPILER");

    }
}
