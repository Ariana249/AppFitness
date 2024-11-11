package src;

import com.mycompany.appfitness.Comida;
import com.mycompany.appfitness.Dieta;
import com.mycompany.appfitness.Ejercicio;
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
        //Inicializa los valores para el ComboBox de tipo comida
        this.tipoComida.setItems(FXCollections.observableArrayList(OpcionesComida.values()));
        tipoComida.setValue("Desayuno");
        String comida = this.tipoComida.getValue().toString();
        
        Usuario usuario = new Usuario().buscarUsr(idLogin);

        if (usuario != null || comida.equalsIgnoreCase("Desayuno")) {
            ObservableList<Comida> lista = FXCollections.observableArrayList(com.mostrarDieta(idLogin, "Desayuno"));
            listaComida.setItems(lista);
            
            listaComida.setCellFactory(lv -> new ListCell<>() {
                @Override
                protected void updateItem(Comida item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombreComida()+ " - " + item.getCantProteina()+ " proteinas " + item.getCalorias()+ " calorias - " + item.getGrasas()+ " grasas ");
                    }
                }
            });
        } else {
            if (comida.equalsIgnoreCase("Almuerzo")) {
                ObservableList<Comida> lista = FXCollections.observableArrayList(com.mostrarDieta(idLogin, "Almuerzo"));
                listaComida.setItems(lista);
            } else {
                if (comida.equalsIgnoreCase("Cena")) {
                    ObservableList<Comida> lista = FXCollections.observableArrayList(com.mostrarDieta(idLogin, "Cena"));
                    listaComida.setItems(lista);
                } else {
                    System.out.println("No se encontro un usuario con el id_Login especificado.");
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
