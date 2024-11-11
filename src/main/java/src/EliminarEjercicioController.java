package src;

import com.mycompany.appfitness.Ejercicio;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class EliminarEjercicioController implements Initializable {
    private int idLogin = LoginModel.idLogin;
    private Ejercicio ej = new Ejercicio();
    
    @FXML
    private Button volver;
    
    @FXML
    private ComboBox comboEjercicios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.comboEjercicios.setItems(FXCollections.observableArrayList(ej.buscarEj(idLogin)));
        comboEjercicios.setValue("Ejercicios");
    }    
    

    public void eliminarEjercicio(ActionEvent event){
        String nombreEj = this.comboEjercicios.getValue().toString();
         
        ej.setIdLogin(idLogin);        
        System.out.println(nombreEj);
        System.out.println(ej.getIdLogin());
        if (nombreEj.equalsIgnoreCase("Ejercicios")) {
            JOptionPane.showMessageDialog(null, "Debe elegir un ejercicio para eliminar.");
        } else {
            if(ej.eliminar(nombreEj)){
                JOptionPane.showMessageDialog(null, "El ejercicio se ha eliminado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error. Intente denuevo");
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
