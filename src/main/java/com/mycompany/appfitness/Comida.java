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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.ConeccionDB;

/**
 *
 * @author martin
 */
public class Comida implements GEA<Comida> {

    
    private String nombreComida;
    private float cantProteina;
    private float calorias;
    private float grasas;
    private String tipo;
    
    private int idLogin;
    Connection conn = ConeccionDB.connect();

    public Comida() {
    }

    public Comida(String nombreComida, float cantProteina, float calorias, float grasas, String tipo, int idLogin) {
        this.nombreComida = nombreComida;
        this.cantProteina = cantProteina;
        this.calorias = calorias;
        this.grasas = grasas;
        this.tipo = tipo;
        this.idLogin = idLogin;
    }
    
    
    
    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public float getCantProteina() {
        return cantProteina;
    }

    public void setCantProteina(int cantProteina) {
        this.cantProteina = cantProteina;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public float getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Metodos
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

    @Override
    public boolean eliminar(String nombre) {
        String sql = "DELETE FROM comida WHERE id_login = ? AND nombreComida = ?";
        try (PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql)) {
            pr.setInt(1, getIdLogin());
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

    @Override
    public boolean guardar(Comida c) {
        try {
            String sql = "INSERT INTO comida (nombreComida, cantProteina, calorias, grasas, tipo, id_login) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
            pr.setString(1, c.getNombreComida());
            pr.setFloat(2, c.getCantProteina());
            pr.setFloat(3, c.getCalorias());
            pr.setFloat(4, c.getGrasas());
            pr.setString(5, c.getTipo());
            pr.setInt(6, c.getIdLogin());

            pr.executeUpdate();
            pr.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     @Override
    public boolean actualizar(Integer id, Comida objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
    
