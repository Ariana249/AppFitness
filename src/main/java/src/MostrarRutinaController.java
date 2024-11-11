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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class MostrarRutinaController implements Initializable {

    private int idLogin = LoginModel.idLogin;
    private Ejercicio ej = new Ejercicio();

    @FXML
    private Button volver;
    @FXML
    private ListView<Ejercicio> listaEjercicios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usuario = new Usuario().buscarUsr(idLogin);
        if (usuario != null) {
            ObservableList<Ejercicio> lista = FXCollections.observableArrayList(ej.listaEjercicios(idLogin));
            listaEjercicios.setItems(lista);

            // Configurar el formato de cada celda para mostrar todos los atributos
            listaEjercicios.setCellFactory(lv -> new ListCell<>() {
                @Override
                protected void updateItem(Ejercicio item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText("Nombre: "+ item.getNombre() + " - "
                                + "Grupo Muscular: " +item.getGrupoMuscular() + " - "
                                + item.getSeries() + " series de "
                                + item.getRepeticiones() + " repeticiones - "
                                + item.getFrecuencia() + " veces por semana - ");
                    }
                }
            });
        } else {
            System.out.println("No se encontrÃ³ un usuario con el id_Login especificado.");
        }
    }

    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }
}
