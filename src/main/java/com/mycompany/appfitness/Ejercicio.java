/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.ConeccionDB;

/**
 *
 * @author brook
 */
public class Ejercicio extends Entrenamiento implements GEA<Ejercicio>{
    Connection conn = ConeccionDB.connect();
    
    //Atributos 
    
    private String grupoMuscular;
    private int repeticiones;
    private int series;
    private int idUsuario;

    // Constructor

    public Ejercicio() {
    }

    public Ejercicio(String nombre, String grupoMuscular, int repeticiones, int series, String objetivo, int frecuencia, String nivelDeDificultad, int idUsuario ) {
        super(objetivo, frecuencia, nivelDeDificultad, nombre);
        this.grupoMuscular = grupoMuscular;
        this.repeticiones = repeticiones;
        this.series = series;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    // Metodos
    
    @Override
    public void guardar(Ejercicio c) {
        try {
            String sql = "INSERT INTO rutina (nombreEjercicio, grupo_muscular, repeticiones, series, objetivo, frecuencia, dificultad, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, c.getNombre());
            pr.setString(2, c.getGrupoMuscular());
            pr.setInt(3, c.getRepeticiones());
            pr.setInt(4, c.getSeries());            
            pr.setString(5, c.getObjetivo());
            pr.setInt(6, c.getFrecuencia());
            pr.setString(7, c.getNivelDeDificultad());
            pr.setInt(8,c.getIdUsuario());
            
            pr.executeUpdate();
            pr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Integer id, Ejercicio c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
