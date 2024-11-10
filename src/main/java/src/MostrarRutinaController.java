package src;

import com.mycompany.appfitness.Ejercicio;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.mycompany.appfitness.Usuario;
import javafx.scene.control.Label;

public class MostrarRutinaController implements Initializable {
    
    private int idLogin = LoginModel.idLogin;
    private Ejercicio ej = new Ejercicio();
    
    @FXML
    private Button volver;
    @FXML
    private Label rutinaContenido;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usuario = new Usuario().buscarUsr(idLogin);
        if (usuario != null) {
            //rutinaContenido.setText(ej.buscarEj(idLogin));
            //pasar a array
        } else {
            System.out.println("No se encontró un usuario con el id_Login especificado.");
        }
    }
     
     public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }

    
}
