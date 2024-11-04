package src;

import com.mycompany.appfitness.Usuario;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    LoginModel modeloLogin = new LoginModel();
    //Inicializamos conn como atributo Connection para tener la coneccion con la base de datos
    Connection conn = ConeccionDB.connect();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField nombreUsuario;
    @FXML
    private PasswordField clave;
    @FXML
    private Button botonIngresar;
    @FXML
    private Label loginStatus;
    @FXML
    private TextField regUsuario;
    @FXML
    private PasswordField regClave;
    @FXML
    private TextField email;
    @FXML
    private Button botonCrearCuenta;
    @FXML
    private Hyperlink registrarse;
    @FXML
    private Button volver;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (this.modeloLogin.DBConectada()) {
            this.dbstatus.setText("Conectada");
        } else {
            this.dbstatus.setText("Sin Conexion");
        }
    }

    //Esto es para Logearte
    @FXML
    public void Login(ActionEvent event) {
        try {

            if (this.modeloLogin.Ingresar(this.nombreUsuario.getText(), this.clave.getText())) {
                Stage stage = (Stage) this.botonIngresar.getScene().getWindow();
                stage.close();

                App a = new App();
                a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

            } else {
                this.loginStatus.setText("Datos Incorrectos");
            }
        } catch (Exception e) {
        }
    }

    @FXML
    public void Registrar(ActionEvent evento) {
        // Cerrar la ventana de login
        Stage stage = (Stage) this.registrarse.getScene().getWindow();
        stage.close();
        //Abre la escena registrar
        App a = new App();
        a.AbrirEscena("/fxml/registrar.fxml","Fitness App Registrar");
    }

    @FXML
    public void CrearCuenta(ActionEvent evento) {
        Usuario user = new Usuario();
        String usuario = this.regUsuario.getText();
        String clave = this.regClave.getText();
        String email = this.email.getText();

        if (usuario.isEmpty() || clave.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar los datos.");
        } else {
            String sql = "INSERT INTO login (nombreUsuario, clave, email) VALUES (?, ?, ?)";
            try {
                // Prepara el statement para evitar inyección SQL
                PreparedStatement pr = conn.prepareStatement(sql);
                pr.setString(1, usuario);
                pr.setString(2, clave);
                pr.setString(3, email);

                // Ejecuta la inserción
                int filasAfectadas = pr.executeUpdate();
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear la cuenta.");
                }

                // Cierra el PreparedStatement
                pr.close();

                Stage stage = (Stage) this.botonCrearCuenta.getScene().getWindow();
                stage.close();

                App a = new App();
                a.AbrirEscena("/fxml/bienvenida.fxml", "Fitness App");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    
    public void Volver(ActionEvent event) {
        Stage s = (Stage)this.volver.getScene().getWindow();
        s.close();
        
        App a = new App();
        a.AbrirEscena("/fxml/login.fxml", "Fitness App Login");
        
    }
    
}
