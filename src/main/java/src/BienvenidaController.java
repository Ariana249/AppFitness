package src;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BienvenidaController implements Initializable {


    @FXML
    private Button botonContinuar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void Continuar(ActionEvent event) {
        try {
            
            Stage stage = (Stage)this.botonContinuar.getScene().getWindow();
            stage.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/app.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage s = new Stage();
            s.setScene(scene);
            s.setTitle("FITCOMPILER");
            s.show();
            
        } catch (Exception e) {
        }
    }

}
