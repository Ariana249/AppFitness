package src;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    LoginModel modeloLogin = new LoginModel();

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (this.modeloLogin.DBConectada()) {
            this.dbstatus.setText("Conectada");
        } else {
            this.dbstatus.setText("Sin Conexion");
        }
    }

    @FXML
    public void Login(ActionEvent event) {
        try {

            if (this.modeloLogin.Ingresar(this.nombreUsuario.getText(), this.clave.getText())) {
                Stage stage = (Stage) this.botonIngresar.getScene().getWindow();
                stage.close();

                loginMenu();

            } else {
                this.loginStatus.setText("Datos Incorrectos");
            }
        } catch (Exception e) {
        }
    }

    @FXML
    public void Registrar(ActionEvent evento) {
        try {
            // Cargar el archivo FXML para la ventana de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registrar.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con el contenido de registrar.fxml
            Scene scene = new Scene(root);

            // Crear una nueva ventana (Stage)
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Fitness App Registrar");

            // Mostrar la nueva ventana
            stage.show();

            // Cerrar la ventana de login si es necesario
            ((Stage) ((Hyperlink) evento.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void CrearCuenta(ActionEvent evento) {
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
                
                Stage stage = (Stage)this.botonCrearCuenta.getScene().getWindow();
                stage.close();
                
                App login = new App();
                login.start(stage);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    public void loginMenu() {
        try {
            Stage menu = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/fxml/menu.fxml").openStream());

            MenuController menuController = (MenuController) loader.getController();

            Scene scene = new Scene(root);
            menu.setScene(scene);
            menu.setTitle("App Fitness");
            menu.setResizable(false);
            menu.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
