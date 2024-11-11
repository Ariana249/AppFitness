package src;

import com.mycompany.appfitness.Comida;
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

public class EliminarComidaController implements Initializable {

    private int idLogin = LoginModel.idLogin;
    private Comida com = new Comida();

    @FXML
    private Button eliminar;
    @FXML
    private Button volver;
    @FXML
    private ComboBox comboComida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.comboComida.setItems(FXCollections.observableArrayList(com.buscarCom(idLogin)));
        comboComida.setValue("Comida");
    }

    public void eliminarComida(ActionEvent event) {
        String nombreCom = this.comboComida.getValue().toString();

        com.setIdLogin(idLogin);
        System.out.println(nombreCom);
        System.out.println(com.getIdLogin());

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
