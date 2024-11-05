package src;

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
                try {
                    String sql = "INSERT INTO usuario (nombre, apellido, peso, altura, objetivo) VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement pr = conn.prepareStatement(sql);
                    pr.setString(1, nombre);
                    pr.setString(2, apellido);
                    pr.setString(3, peso);
                    pr.setString(4, altura);
                    pr.setString(5, opcion);

                    pr.executeUpdate();
                    pr.close();

                    Stage stage = (Stage) this.botonContinuar.getScene().getWindow();
                    stage.close();
                    
                    App a = new App();
                    a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

