package src;

import com.mycompany.appfitness.Usuario;
import opciones.OpcionObjetivo;
import java.net.URL;
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
        
        Usuario usr;        
        
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

                    usr = new Usuario(nombre,Float.parseFloat(peso),Float.parseFloat(altura),opcion);
                
                    //busca el usuario y lo actualiza con los datos que le pasamos                                        
                    usr.actualizar(idLogin,usr);
                    
                    Stage stage = (Stage) this.botonListo.getScene().getWindow();
                    stage.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }
    
}
