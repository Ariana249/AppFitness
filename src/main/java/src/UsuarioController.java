package src;

import opciones.OpcionObjetivo;
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

public class UsuarioController implements Initializable {

    Connection conn = ConeccionDB.connect();

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
    private Button botonListo;
    @FXML
    private Button volver;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.objetivo.setItems(FXCollections.observableArrayList(OpcionObjetivo.values()));
        objetivo.setValue("Objetivo");

    }

    @FXML
    public void Listo(ActionEvent event) {

        String nombre = this.nombreIngresado.getText();
        String apellido = this.apellidoIngresado.getText();
        String altura = this.alturaIngresada.getText();
        String peso = this.pesoIngresado.getText();
        String opcion = this.objetivo.getValue().toString();

        if (nombre.isEmpty() || altura.isEmpty() || peso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar los Datos para continuar.");
        } else {
            if (opcion.equalsIgnoreCase("Objetivo")) {
                JOptionPane.showMessageDialog(null, "Debe Elegir un Objetivo.");
            } else {
                try {
                    actualizarDatosUsuario(nombre, apellido, peso, altura, opcion);

                    Stage stage = (Stage) this.botonListo.getScene().getWindow();
                    stage.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void actualizarDatosUsuario(String nombre, String apellido, String peso, String altura, String objetivo) {
        String updateQuery = "UPDATE usuario SET nombre = ?, apellido = ?, peso = ?, altura = ?, objetivo = ?";

        try (PreparedStatement pr = conn.prepareStatement(updateQuery)) {
            pr.setString(1, nombre);
            pr.setString(2, peso);
            pr.setString(3, peso);
            pr.setString(4, altura);
            pr.setString(5, objetivo);

            int affectedRows = pr.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Datos actualizados correctamente.");
            } else {
                System.out.println("No se pudo actualizar los datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar datos: " + e.getMessage());
        }
    }
    
    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }
    
}
