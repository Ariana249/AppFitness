package src;

import com.mycompany.appfitness.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PerfilController implements Initializable {

    private int idLogin = LoginModel.idLogin;

    @FXML
    private Button volver;
    @FXML
    private Label nombre;
    @FXML
    private Label apellido;
    @FXML
    private Label objetivo;
    @FXML
    private Label peso;
    @FXML
    private Label altura;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usuario = new Usuario().buscarUsr(idLogin);
        
        if (usuario != null) {
            nombre.setText(usuario.getNombre());
            apellido.setText(usuario.getApellido());
            peso.setText(String.valueOf(usuario.getPeso())+" kg");
            altura.setText(String.valueOf(usuario.getAltura())+" cm");
            objetivo.setText(usuario.getObjetivo());
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
