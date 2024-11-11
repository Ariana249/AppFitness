package src;

import database.ConeccionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginModel {

    Connection coneccion;
    public static int idLogin;

    public LoginModel() {
        this.coneccion = ConeccionDB.connect();
        if (this.coneccion == null) {
            System.exit(1);
        }
    }

    public boolean DBConectada() {
        return this.coneccion != null;
    }

    public boolean Ingresar(String usuario, String clave) {
        String sql = "SELECT * FROM login WHERE nombreUsuario = ? AND clave = ?";

        try (PreparedStatement pr = this.coneccion.prepareStatement(sql)) {
            pr.setString(1, usuario);
            pr.setString(2, clave);

            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    idLogin(usuario);
                    return true; // El usuario y clave coinciden
                }
            }
            pr.close();
        } catch (SQLException ex) {
            System.out.println("Error al intentar iniciar sesión: " + ex.getMessage());
        }
        return false; // El usuario y clave no coinciden
    }
    
    public void idLogin(String nombreUsuario){        
        String query = "SELECT id FROM login WHERE nombreUsuario = ?";
        
        try {            
            PreparedStatement pr = (PreparedStatement) this.coneccion.prepareStatement(query);
            pr.setString(1, nombreUsuario);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                idLogin = rs.getInt("id");
            }
            pr.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
