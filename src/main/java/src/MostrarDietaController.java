package src;

import src.LoginModel;
import com.mycompany.appfitness.Comida;
import com.mycompany.appfitness.Dieta;
import com.mycompany.appfitness.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import opciones.OpcionesComida;

public class MostrarDietaController implements Initializable {

    private int idLogin = LoginModel.idLogin;
    private Dieta com = new Dieta();

    @FXML
    private Button volver;
    @FXML
    private ComboBox tipoComida;
    @FXML
    private ListView<Comida> listaComida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar ComboBox de tipo comida
        this.tipoComida.setItems(FXCollections.observableArrayList(OpcionesComida.values()));
        tipoComida.setValue("Desayuno");

        // Cargar comidas iniciales (Desayuno por defecto)
        actualizarListaComidas("Desayuno");

        // Listener para detectar cambios en el ComboBox
        tipoComida.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                actualizarListaComidas(newValue.toString());
            }
        });
    }

    private void actualizarListaComidas(String tipoComida) {
        Usuario usuario = new Usuario().buscarUsr(idLogin);
        if (usuario != null) {
            ObservableList<Comida> lista = FXCollections.observableArrayList(com.mostrarDieta(idLogin, tipoComida));
            listaComida.setItems(lista);
            // Configurar el formato de cada celda para mostrar todos los atributos
            listaComida.setCellFactory(lv -> new ListCell<>() {
                protected void updateItem(Comida item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        int indice = listaComida.getItems().indexOf(item) + 1;
                        setText(indice + ") " + item.getNombreComida()+ " - " + item.getCantProteina()+ " gr. de proteina - " + item.getCalorias()+ " calorias - " + item.getGrasas()+ " grasas");
                    }
                }
            });
        }
    }

    public void Volver(ActionEvent event) {
        Stage s = (Stage) this.volver.getScene().getWindow();
        s.close();

        App a = new App();
        a.AbrirEscena("/fxml/app.fxml", "FITCOMPILER");

    }

}
