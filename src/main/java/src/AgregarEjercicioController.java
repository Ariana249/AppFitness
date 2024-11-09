package src;

import com.mycompany.appfitness.Ejercicio;
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
import opciones.OpcionObjetivo;
import opciones.PartesCuerpo;

public class AgregarEjercicioController implements Initializable {

    @FXML
    private ComboBox tipo;
    @FXML
    private ComboBox<Integer> series;
    @FXML
    private ComboBox<Integer> repeticiones;
    @FXML
    private TextField nombreIngresado;
    @FXML
    private ComboBox objetivo;
    @FXML
    private TextField frecuencia;
    @FXML
    private ComboBox nivelDeDificultad;
    @FXML
    private Button volver;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombreIngresado.setText("");
        frecuencia.setText("");
        series.setValue(1);
        repeticiones.setValue(1);
        
        //Inicializa los valores para el ComboBox de tipo
        this.tipo.setItems(FXCollections.observableArrayList(PartesCuerpo.values()));
        tipo.setValue("Tipo");

        //Inicializa los valores para el ComboBox de objetivo
        this.objetivo.setItems(FXCollections.observableArrayList(OpcionObjetivo.values()));
        objetivo.setValue("Objetivo");
    
        //agregar a la tabla de browser para el nivel de dificultad
        
        
        // Agrega los números al ComboBox de series
        for (int i = 1; i <= 8; i++) {
            series.getItems().add(i);
        }
        
        //Agrega los numeros al ComboBox de repeticiones
        for (int i = 1; i <= 30; i++) {
            repeticiones.getItems().add(i);
        }
    }
    
    public void GuardarEjercicio(ActionEvent event){
        Ejercicio c;
        
        String nombreEj = this.nombreIngresado.getText();
        String frecuenciaEJ = this.frecuencia.getText();
        String tipoEj = this.tipo.getValue().toString();
        String objetivoEj = this.objetivo.getValue().toString();
        String ser = this.series.getValue().toString();
        String reps = this.repeticiones.getValue().toString();                
        String dificultadEj = this.nivelDeDificultad.getValue().toString();
        if (nombreEj.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del ejercicio.");
        } else {
            if (tipoEj.equalsIgnoreCase("Tipo")) {
                JOptionPane.showMessageDialog(null, "Debe elegir el tipo del ejercicio.");
            } else {
                try {
                    //agregar con los nuevos elementos
                    c = new Ejercicio(nombreEj,tipoEj,Integer.parseInt(ser),Integer.parseInt(reps),objetivoEj,Integer.parseInt(frecuenciaEJ),dificultadEj);
                    
                    c.guardar(c);
                    
                    JOptionPane.showMessageDialog(null, "Ejercicio Agregado Correctamente!");
                    
                    initialize(null, null);
                    
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void Volver(ActionEvent event) {
        Stage s = (Stage)this.volver.getScene().getWindow();
        s.close();
        
        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");
        
    }
    
}