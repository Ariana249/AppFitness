/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import src.ConeccionDB;

/**
 *
 * @author martin
 */
public class Dieta implements GEA<Dieta> {

    private int id;
    private String tipo; // desayuno, almuerzo, cena
    private Comida comida;
    private Usuario usr;

    Connection conn = ConeccionDB.connect();

    public Dieta() {
    }

    public Dieta(int id, String tipo, Comida comida) {
        this.id = id;
        this.tipo = tipo;
        this.comida = comida;
    }    
    
    
    //Metodos
    @Override
    public boolean guardar(Dieta objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Integer id, Dieta objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Dieta buscarDieta(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Comida> mostrarDieta(int id, String tipo) {
        ArrayList<Comida> comidas = new ArrayList<>();
        String sql = "SELECT nombreComida, cantProteina, calorias, grasas FROM comida WHERE id_login = ? AND tipo = ?";

        try (PreparedStatement pr = conn.prepareStatement(sql)) {
            pr.setInt(1, id);
            pr.setString(2, tipo);
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

}
