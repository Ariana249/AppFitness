package src;

import src.LoginModel;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static src.LoginModel.idLogin;

public class EliminarComidaController implements Initializable {

    private int idLogin = LoginModel.idLogin;
    private Comida com = new Comida();
    private Dieta d = new Dieta();

    @FXML
    private Button eliminar;
    @FXML
    private Button volver;
    @FXML
    private ComboBox comboComida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.comboComida.setItems(FXCollections.observableArrayList(d.mostrarTodaComida(idLogin)));
        comboComida.setValue("Comida");
    }

    public void eliminarComida(ActionEvent event) {
        Dieta d = new Dieta();
        String nombreCom = this.comboComida.getValue().toString();

        com.setIdDieta(d.buscarDieta(idLogin));

        if (nombreCom.equalsIgnoreCase("Comida")) {
            JOptionPane.showMessageDialog(null, "Debe elegir una comida para eliminar.");
        } else {
            if (com.eliminar(nombreCom)) {
                JOptionPane.showMessageDialog(null, "La comida se ha eliminado correctamente!");
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
