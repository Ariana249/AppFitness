package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConeccionDB {
    
    //Iniciamos la coneccion con nuestra base de datos que es un archivo .sqlite que esta en nuestra carpeta src del proyecto
    private static final String DB_URL = "jdbc:sqlite:src/appsystem.sqlite";        
    
    //Creamos el metodo por el cual conectarla
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conexión a la base de datos establecida exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }
    
    
}
