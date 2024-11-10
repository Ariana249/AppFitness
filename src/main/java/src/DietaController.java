package src;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DietaController implements Initializable {

    @FXML
    private Button volver;
    @FXML
    private Button botonEliminarcomida;
    @FXML
    private Button botonAgregarcomida;
    @FXML
    private Button botonBorrarTodo;
    @Override
   public void initialize(URL url, ResourceBundle rb) {
        
    }
     public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }
     public void AgregarComida(ActionEvent event) {
        Stage s = (Stage)this.botonAgregarcomida.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/agregarComida.fxml", "FITCOMPILER");
    }
     public void EliminarComida(ActionEvent event) {
        Stage s = (Stage)this.botonEliminarcomida.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/eliminarComida.fxml", "FITCOMPILER");
    }
     public  void Borrartodo(String[] args) {
        
    }
}
