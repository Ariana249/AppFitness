/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import com.mycompany.appfitness.ComidaItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ComidaItemPersistencia {

    public void guardarComidaItem(ComidaItem comidaItem) {
        
    }

    public void conectar() throws ClassNotFoundException {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:appfitness.sqlite");

            if (conn != null) {
                System.out.println("Conexión a base de datos ... Ok");
            } else {
                System.out.println("Conexión a base de datos: problemas!");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());//ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Otra Exception: " + ex.getMessage());//ex.printStackTrace();
        }

    }

}
