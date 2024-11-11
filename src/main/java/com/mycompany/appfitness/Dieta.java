package com.mycompany.appfitness;

import database.ConeccionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class Dieta implements GEA<Dieta> {

    Connection conn = ConeccionDB.connect();

    // Atributos 
    private int id;
    private String tipo; // desayuno, almuerzo, cena
    private ArrayList<Comida> comidas;
    private Usuario usr;

    // Constructores    
    public Dieta() {
    }

    public Dieta(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Dieta(String tipo) {
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComida(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    //Metodos
    public ArrayList<Comida> mostrarDieta(int id) {
        ArrayList<Comida> comidas = new ArrayList<>();
        String sql = "SELECT nombreComida, cantProteina, calorias, grasas FROM comida WHERE id_dieta = ?";

        try (PreparedStatement pr = conn.prepareStatement(sql)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Comida comida = new Comida(rs.getString("nombreComida"), rs.getFloat("cantProteina"), rs.getFloat("calorias"), rs.getFloat("grasas"), id);
                comidas.add(comida);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return comidas;
    }

    public ArrayList<String> mostrarTodaComida(int id){
        ArrayList<String> comidas = new ArrayList<>();
        String sql = "SELECT nombreComida, cantProteina, calorias, grasas FROM comida WHERE id_dieta IN (?,?,?)";
        int almuerzoId = buscarDietaPorTipo(id, "Almuerzo");
        int desayunoId = buscarDietaPorTipo(id, "Desayuno");
        int cenaId = buscarDietaPorTipo(id, "Cena");
        
        try (PreparedStatement pr = conn.prepareStatement(sql)) {
            pr.setInt(1, almuerzoId);
            pr.setInt(2, desayunoId);
            pr.setInt(3, cenaId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String comida = rs.getString("nombreComida");
                comidas.add(comida);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return comidas;
    }
    
    public int buscarDieta(int idLogin) {
        int idDieta = 0;
        String readQuery = "SELECT id FROM dieta WHERE id_login = ?";

        try (PreparedStatement pr = conn.prepareStatement(readQuery)) {
            pr.setInt(1, idLogin);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                idDieta = rs.getInt("id");
            }

            pr.close();

            return idDieta;
        } catch (SQLException e) {
            System.err.println("Error al buscar dieta: " + e.getMessage());
        }

        return idDieta;
    }
    
    public int buscarDietaPorTipo(int idLogin, String tipo) {
        int idDieta = 0;
        String readQuery = "SELECT id FROM dieta WHERE id_login = ? AND tipo = ?";

        try (PreparedStatement pr = conn.prepareStatement(readQuery)) {
            pr.setInt(1, idLogin);
            pr.setString(2, tipo);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                idDieta = rs.getInt("id");
            }

            pr.close();

            return idDieta;
        } catch (SQLException e) {
            System.err.println("Error al buscar dieta: " + e.getMessage());
        }

        return idDieta;
    }

    @Override
    public boolean guardar(Dieta d) {
        try {
            String sql = "INSERT INTO dieta (tipo, id_login) SELECT ?, ? WHERE NOT EXISTS (SELECT * FROM dieta WHERE tipo = ? AND id_login = ?)";

            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, d.getTipo());
            pr.setFloat(2, d.getUsr().getIdLogin());
            pr.setString(3, d.getTipo());
            pr.setFloat(4, d.getUsr().getIdLogin());

            pr.executeUpdate();
            pr.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Integer id, Dieta objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
