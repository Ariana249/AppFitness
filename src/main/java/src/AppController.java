package src;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class AppController implements Initializable {
    
    @FXML
    private Hyperlink salir;
    @FXML
    private Button botonAgregarEjercicio;
    @FXML
    private Button usuario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    public void Perfil(ActionEvent event){
        Stage s = (Stage)this.usuario.getScene().getWindow();
        s.close();
        
        App a = new App();
        a.AbrirEscena("/fxml/perfil.fxml", "Perfil");
    }
    
    @FXML
    public void ActualizarDatos(ActionEvent event) {
        App a = new App();
        a.AbrirEscena("/fxml/actualizarDatos.fxml", "FITCOMPILER");
    }
    
    @FXML
    public void Dieta(ActionEvent event) {
        App a = new App();
        a.AbrirEscena("/fxml/dieta.fxml", "FITCOMPILER");
    }
    
    @FXML
    public void abrirAgregarEjercicio(ActionEvent event) {
        Stage s = (Stage)this.botonAgregarEjercicio.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/agregarEjercicio.fxml", "FITCOMPILER");
    }
    @FXML
    public void abrirEliminarEjercicio(ActionEvent event) {
        App a = new App();
        a.AbrirEscena("/fxml/eliminarEjercicio.fxml", "FITCOMPILER");
    }

    @FXML
    public void CerrarSesion(ActionEvent evento) {

        try {
            
            Stage stage = (Stage)this.salir.getScene().getWindow();
            stage.close();
            
            App a = new App();
            a.start(stage);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
