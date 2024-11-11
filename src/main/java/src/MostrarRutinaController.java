package src;

import com.mycompany.appfitness.Ejercicio;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.mycompany.appfitness.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class MostrarRutinaController implements Initializable {

    private int idLogin = LoginModel.idLogin;
    private Ejercicio ej = new Ejercicio();

    @FXML
    private Button volver;
    @FXML
    private ListView<String> listaEjercicios;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usuario = new Usuario().buscarUsr(idLogin);
        if (usuario != null) {
            ObservableList<String> lista = FXCollections.observableArrayList(ej.buscarEj(idLogin));
            listaEjercicios.setItems(lista);
        } else {
            System.out.println("No se encontró un usuario con el id_Login especificado.");
        }
    }

    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }
}
