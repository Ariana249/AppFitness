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
    private Button botonPerfil;
    @FXML
    private Button botonAgregarComida;
    @FXML
    private Button botonEliminarComida;
    @FXML
    private Button botonActualizarDatos;
    @FXML
    private Button botonEliminarEjercicio;
    @FXML
    private Button botonMostrarRutina;
    @FXML
    private Button botonMostrarDieta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    public void Perfil(ActionEvent event){
        Stage s = (Stage)this.botonPerfil.getScene().getWindow();
        s.close();
        
        App a = new App();
        a.AbrirEscena("/fxml/perfil.fxml", "Perfil");
    }
    
    @FXML
    public void ActualizarDatos(ActionEvent event) {
        Stage s = (Stage)this.botonActualizarDatos.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/actualizarDatos.fxml", "FITCOMPILER");
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
        Stage s = (Stage)this.botonEliminarEjercicio.getScene().getWindow();
        s.close();
        
        App a = new App();
        a.AbrirEscena("/fxml/eliminarEjercicio.fxml", "FITCOMPILER");
    }
    @FXML
    public void mostrarRutina(ActionEvent event) {
        Stage s = (Stage)this.botonMostrarRutina.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/mostrarRutina.fxml", "FITCOMPILER");
    }
    
    @FXML
    public void AbrirEliminarComida(ActionEvent event) {
        Stage s = (Stage) this.botonEliminarComida.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/eliminarComida.fxml", "FITCOMPILER");
    }
    @FXML
    public void AbrirAgregarComida(ActionEvent event) {
        Stage s = (Stage) this.botonAgregarComida.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/agregarComida.fxml", "FITCOMPILER");
    }
    
    @FXML
    public void mostrarDieta(ActionEvent event) {
        Stage s = (Stage)this.botonMostrarDieta.getScene().getWindow();
        s.close();
        App a = new App();
        a.AbrirEscena("/fxml/mostrarDieta.fxml", "FITCOMPILER");
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
