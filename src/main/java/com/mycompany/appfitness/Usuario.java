package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import src.ConeccionDB;

public class Usuario implements GEA<Usuario> {

    //Atributos   
    Connection conn = ConeccionDB.connect();

    private int id;
    private String nombre;
    private int edad;
    private float peso;
    private float altura;
    private float imc;
    private String objetivo;

    //Constructor
    public Usuario() {
    }

    public Usuario(int id, String nombre, float peso, float altura, String objetivo) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.objetivo = objetivo;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    //Metodos    
    public void cambiarObjetivos() {

    }

    public void cambiarPlan() {
        //if para cambiarse y mostrar el actual
    }

    @Override
    public void guardar(Usuario usr) {

    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Integer id, Usuario usr) {

        String updateQuery = "UPDATE usuario SET nombre = ?, peso = ?, altura = ?, objetivo = ? WHERE id = '" + id + "'";

        try (PreparedStatement pr = conn.prepareStatement(updateQuery)) {
            pr.setString(1, usr.getNombre());
            pr.setFloat(2, usr.getPeso());
            pr.setFloat(3, usr.getAltura());
            pr.setString(4, usr.getObjetivo());

            int affectedRows = pr.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Datos actualizados correctamente.");
            } else {
                System.out.println("No se pudo actualizar los datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar datos: " + e.getMessage());
        }
    }

    public Usuario buscarUsr(String nombreUsuario) {
        String readQuery = "SELECT * FROM usuario WHERE nombre = ?";
        Usuario usr = null;

        try (PreparedStatement pr = conn.prepareStatement(readQuery)) {
            pr.setString(1, nombreUsuario);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                usr = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("peso"), rs.getFloat("altura"), rs.getString("objetivo"));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar el usuario: " + e.getMessage());
        }

        return usr;
    }
}
