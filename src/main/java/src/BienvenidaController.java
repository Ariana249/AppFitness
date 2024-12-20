package src;

import database.ConeccionDB;
import com.mycompany.appfitness.Usuario;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import opciones.OpcionObjetivo;

public class BienvenidaController implements Initializable {

    Connection conn = ConeccionDB.connect();
    private int idLogin = LoginModel.idLogin;

    @FXML
    private ComboBox objetivo;
    @FXML
    private TextField nombreIngresado;
    @FXML
    private TextField apellidoIngresado;
    @FXML
    private TextField alturaIngresada;
    @FXML
    private TextField pesoIngresado;
    @FXML
    private Button botonContinuar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.objetivo.setItems(FXCollections.observableArrayList(OpcionObjetivo.values()));
        objetivo.setValue("Objetivo");
    }

    @FXML
    public void Continuar(ActionEvent event) {
        Usuario usr;

        String nombre = this.nombreIngresado.getText();
        String apellido = this.apellidoIngresado.getText();
        String altura = this.alturaIngresada.getText();
        String peso = this.pesoIngresado.getText();
        String opcion = this.objetivo.getValue().toString();

        if (nombre.isEmpty() || apellido.isEmpty() || altura.isEmpty() || peso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar los Datos para continuar.");
        } else {
            if (opcion.equalsIgnoreCase("Objetivo")) {
                JOptionPane.showMessageDialog(null, "Debe Elegir un Objetivo.");
            } else {
                if (!esNumerico(peso) || !esNumerico(altura)) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar numeros en peso y altura!!");
                } else {

                    usr = new Usuario(nombre, apellido, Float.parseFloat(peso), Float.parseFloat(altura), opcion, idLogin);

                    if (usr.guardar(usr)) {
                        JOptionPane.showMessageDialog(null, "Te has registrado correctamente!");

                        Stage stage = (Stage) this.botonContinuar.getScene().getWindow();
                        stage.close();

                        App a = new App();
                        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error. Intenta denuevo");
                    }

                }
            }
        }
    }

    private boolean esNumerico(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
