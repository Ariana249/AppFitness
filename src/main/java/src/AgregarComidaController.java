package src;

import com.mycompany.appfitness.Comida;
import com.mycompany.appfitness.Dieta;
import com.mycompany.appfitness.Usuario;
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
import opciones.OpcionesComida;
import static src.LoginModel.idLogin;

public class AgregarComidaController implements Initializable {

    @FXML
    private Button volver;
    @FXML
    private TextField nombreIngresado;
    @FXML
    private TextField cantProteinas;
    @FXML
    private TextField calorias;
    @FXML
    private TextField grasas;
    @FXML
    private ComboBox tipoComida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreIngresado.setText("");
        cantProteinas.setText("");
        calorias.setText("");
        grasas.setText("");
        
        //Inicializa los valores para el ComboBox de tipo comida
        this.tipoComida.setItems(FXCollections.observableArrayList(OpcionesComida.values()));
        tipoComida.setValue("Tipo");
    }

    public void GuardarComida(ActionEvent event){
        Comida c;
        Dieta d;
        Usuario usr = new Usuario();
        usr.setIdLogin(idLogin);
        
        String nombreComida = this.nombreIngresado.getText();
        String cantProteina = this.cantProteinas.getText();
        String calorias = this.calorias.getText();
        String grasas = this.grasas.getText();
        String tipo = this.tipoComida.getValue().toString();
        
        if (nombreComida.isEmpty() || cantProteina.isEmpty() || calorias.isEmpty() || grasas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar los datos de la comida");
        } else {
            if (tipo.equalsIgnoreCase("Tipo")) {
                JOptionPane.showMessageDialog(null, "Debe elegir el tipo de la comida.");
            } else {
                try {
                    d = new Dieta(tipo);
                    d.setUsr(usr);
                    if (d.guardar(d)) {
                        System.out.println("Se guardo la dieta correctamente");
                    } else {
                        System.out.println("No se guardo la dieta");
                    }
                    
                    c = new Comida(nombreComida, Float.parseFloat(cantProteina), Float.parseFloat(calorias), Float.parseFloat(grasas),d.buscarDietaPorTipo(idLogin,tipo));
                    
                    if (c.guardar(c)) {
                        JOptionPane.showMessageDialog(null, "Comida Agregada Correctamente!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Hubo un error. Intente nuevamente!");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
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
