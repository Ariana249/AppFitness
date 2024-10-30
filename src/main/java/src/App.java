package src;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        
        //Creo una nueva escena con el root en donde se encuentra el archivo login.fxml
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Fitness App Login");
        stage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    } 
    
}
