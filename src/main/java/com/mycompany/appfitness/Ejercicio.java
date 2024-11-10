/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.ConeccionDB;

/**
 *
 * @author brook
 */
public class Ejercicio extends Entrenamiento implements GEA<Ejercicio> {

    Connection conn = ConeccionDB.connect();

    //Atributos 
    private String grupoMuscular;
    private int repeticiones;
    private int series;
    private int idLogin;

    // Constructor
    public Ejercicio() {
    }

    public Ejercicio(String nombre, String grupoMuscular, int repeticiones, int series, String objetivo, int frecuencia, String nivelDeDificultad, int idLogin) {
        super(objetivo, frecuencia, nivelDeDificultad, nombre);
        this.grupoMuscular = grupoMuscular;
        this.repeticiones = repeticiones;
        this.series = series;
        this.idLogin = idLogin;
    }

    // Getters y Setters
    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    // Metodos
    @Override
    public boolean guardar(Ejercicio c) {
        try {
            String sql = "INSERT INTO ejercicio (nombreEjercicio, grupo_muscular, repeticiones, series, objetivo, frecuencia, dificultad, id_login) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, c.getNombre());
            pr.setString(2, c.getGrupoMuscular());
            pr.setInt(3, c.getRepeticiones());
            pr.setInt(4, c.getSeries());
            pr.setString(5, c.getObjetivo());
            pr.setInt(6, c.getFrecuencia());
            pr.setString(7, c.getNivelDeDificultad());
            pr.setInt(8, c.getIdLogin());

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
        String sql = "DELETE FROM ejercicio WHERE id_login = ? AND nombreEjercicio = ?";        
        try(PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql)) {            
            pr.setInt(1, getIdLogin());
            pr.setString(2, nombre);
            
            pr.executeUpdate();
            pr.close();
            
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar ejercicio " + e.getMessage());
        } catch(Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }        
        return false;
    }

    @Override
    public boolean actualizar(Integer id, Ejercicio c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<String> buscarEj(Integer id) {
        ArrayList<String> ejercicios = new ArrayList();
        String readQuery = "SELECT nombreEjercicio FROM ejercicio WHERE id_login = ?";

        try (PreparedStatement pr = conn.prepareStatement(readQuery)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                ejercicios.add(rs.getString("nombreEjercicio"));
            }
            pr.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar ejercicio: " + e.getMessage());
        }

        return ejercicios;
    }

}
