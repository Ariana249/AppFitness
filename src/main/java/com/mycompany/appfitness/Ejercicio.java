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
public class Ejercicio extends Rutina implements GEA<Ejercicio>{
    Connection conn = ConeccionDB.connect();
    private String grupoMuscular;
    private int repeticiones;
    private int series;

    // Constructor

    public Ejercicio() {
    }

    public Ejercicio(String nombre, String grupoMuscular, int repeticiones, int series, String objetivo, int frecuencia, String nivelDeDificultad ) {
        super(objetivo, frecuencia, nivelDeDificultad, nombre);
        this.grupoMuscular = grupoMuscular;
        this.repeticiones = repeticiones;
        this.series = series;
    }
    
    
    // Atributos

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

    @Override
    public void guardar(Ejercicio c) {
        try {
            String sql = "INSERT INTO rutina (nombreEjercicio, series, repeticiones, tipo) VALUES (?, ?, ?, ?)";
            
            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, c.getNombre());
            pr.setInt(2, c.getSeries());
            pr.setInt(3, c.getRepeticiones());
            pr.setString(4, c.getGrupoMuscular());
            
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
