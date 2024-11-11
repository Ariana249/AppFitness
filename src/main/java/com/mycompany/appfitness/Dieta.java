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
 * @author martin
 */
public class Dieta implements GEA<Dieta> {

    Connection conn = ConeccionDB.connect();

    // Atributos 
    private int id;
    private String tipo; // desayuno, almuerzo, cena
    private Comida comida;
    private Usuario usr;

    // Constructores    
    public Dieta() {
    }

    public Dieta(int id, String tipo, Comida comida) {
        this.id = id;
        this.tipo = tipo;
        this.comida = comida;
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

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }
    
    
    // Metodos
    @Override
    public boolean guardar(Dieta c) {
        try {
            String sql = "INSERT INTO comida (nombreComida, cantProteina, calorias, grasas, tipo, id_login) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, c.getComida().getNombreComida());
            pr.setFloat(2, c.getComida().getCantProteina());
            pr.setFloat(3, c.getComida().getCalorias());
            pr.setFloat(4, c.getComida().getGrasas());
            pr.setString(5, c.getTipo());
            pr.setInt(6, c.getUsr().getIdLogin());

            pr.executeUpdate();
            pr.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean actualizar(Integer id, Dieta objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String nombre) {
        String sql = "DELETE FROM comida WHERE id_login = ? AND nombreComida = ?";
        try (PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql)) {
            pr.setInt(1, this.getUsr().getIdLogin());
            pr.setString(2, nombre);

            pr.executeUpdate();
            pr.close();

            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar comida " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return false;
    }
    
        public ArrayList<String> buscarCom(Integer id) {
        ArrayList<String> comidas = new ArrayList();
        String readQuery = "SELECT nombreComida FROM comida WHERE id_login = ?";

        try (PreparedStatement pr = conn.prepareStatement(readQuery)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                comidas.add(rs.getString("nombreComida"));
            }
            pr.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar comida: " + e.getMessage());
        }

        return comidas;
    }
    
}
