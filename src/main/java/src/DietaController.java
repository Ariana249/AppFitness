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
    private Button botonElimnar;
    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonBorrarTodo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void AbrirEliminarComida(ActionEvent event) {
        Stage s = (Stage) this.botonElimnar.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/eliminarComida.fxml", "FITCOMPILER");
    }
    
    public void AbrirAgregarComida(ActionEvent event) {
        Stage s = (Stage) this.botonAgregar.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/agregarComida.fxml", "FITCOMPILER");
    }
    
    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }
    
}
