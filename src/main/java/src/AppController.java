package src;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class AppController implements Initializable {
    
    @FXML
    private Hyperlink salir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void IniciarEscenaApp() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/app.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("FITCOMPILER");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Usuario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/usuario.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("FITCOMPILER");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void Dieta(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dieta.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("FITCOMPILER");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void Ejercicio(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ejercicio.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("FITCOMPILER");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void CerrarSesion(ActionEvent evento) {

        try {
            
            Stage stage = (Stage)this.salir.getScene().getWindow();
            stage.close();
            
            App a = new App();
            a.start(stage);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
