package src;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    private TextField alturaIngresada;
    @FXML
    private TextField pesoIngresado;
    @FXML
    private Button botonListo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.objetivo.setItems(FXCollections.observableArrayList(Opcion.values()));
        objetivo.setValue("Objetivo");

    }
    
    @FXML
    public void Listo(ActionEvent event) {
        
        String nombre = this.nombreIngresado.getText();
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
                    String sql = "INSERT INTO usuario (nombre, peso, altura, plan) VALUES (?, ?, ?, ?)";
                    
                    PreparedStatement pr = conn.prepareStatement(sql);
                    pr.setString(1, nombre);
                    pr.setString(2, peso);
                    pr.setString(3, altura);
                    pr.setString(4, opcion);
                    
                    pr.executeUpdate();
                    pr.close();
                    
                    Stage stage = (Stage)this.botonListo.getScene().getWindow();
                    stage.close();
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}