package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import src.ConeccionDB;

public class Rutina implements CrearRutina {
    //Atributos
    private int cantDias;
    private String objetivo;
    private Pesas pesas;
    private Calistenia calistenia;
    
    
    //Constructor

    public Rutina(int cantDias, String objetivo) {
        this.cantDias = cantDias;
        this.objetivo = objetivo;
    }
    
    //Getters & Setters

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
      
    public Pesas getPesas() {
        return pesas;
    }

    public void setPesas(Pesas pesas) {
        this.pesas = pesas;
    }
    
    Connection conn = ConeccionDB.connect();

    @Override
    public void agregarEjercicio(String nombre, int repeticiones, int series, String tipo) {
        
        try {
            
            String sql = "INSERT INTO rutina (nombreEjercicio, series, repeticiones, tipo) VALUES (?,?,?,?)";
            
            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            
            pr.setString(1, nombre);
            pr.setInt(2, series);
            pr.setInt(3, repeticiones);
            pr.setString(4, tipo);
            
            pr.executeQuery();
            
            pr.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void eliminarEjercicio(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarRutina() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
