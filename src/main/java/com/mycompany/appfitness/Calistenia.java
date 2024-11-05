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
public class Calistenia extends ActividadFisica implements GEA<Calistenia>{
    Connection conn = ConeccionDB.connect();
    private String ejercicio;
    private String grupoMuscular;
    
    public Calistenia() {
    }

    public Calistenia(String ejercicio, String grupoMuscular, int series, int repeticiones) {
        super(series, repeticiones);
        this.ejercicio = ejercicio;
        this.grupoMuscular = grupoMuscular;
    }       

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public void guardar(Calistenia c) {
        try {
            String sql = "INSERT INTO rutina (nombreEjercicio, series, repeticiones, tipo) VALUES (?, ?, ?, ?)";
            
            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, c.getEjercicio());
            pr.setInt(2, c.getSeries());
            pr.setInt(3, c.getRepeticiones());
            pr.setString(4, c.getGrupoMuscular());
            
            pr.executeUpdate();
            pr.close();
        } catch (SQLException ex) {
            Logger.getLogger(Calistenia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Integer id, Calistenia c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
