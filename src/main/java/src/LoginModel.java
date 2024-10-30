package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    Connection coneccion;

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
                    return true; // El usuario y clave coinciden
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al intentar iniciar sesión: " + ex.getMessage());
        }
        return false; // El usuario y clave no coinciden
    }
}
