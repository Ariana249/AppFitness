package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.ConeccionDB;

public class Usuario implements GEA<Usuario> {

    //Atributos   
    Connection conn = ConeccionDB.connect();

    private int id;
    private String nombre;
    private String apellido;
    private float peso;
    private float altura;
    private float imc;
    private String objetivo;
    private int idLogin;

    //Constructor
    public Usuario() {
    }

    public Usuario(String nombre, String apellido, float peso, float altura, String objetivo, int idLogin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.objetivo = objetivo;
        this.idLogin = idLogin;
    }

    public Usuario(String nombre, String apellido, float peso, float altura, String objetivo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    //Metodos    
    public void cambiarObjetivos() {

    }

    public void cambiarPlan() {
        //if para cambiarse y mostrar el actual
    }

    @Override
    public boolean guardar(Usuario usr) {
        String sql = "INSERT INTO usuario (nombre, apellido, peso, altura, objetivo,id_login) VALUES (?, ?, ?, ?, ?,?)";

        PreparedStatement pr;
        try {
            pr = conn.prepareStatement(sql);
            pr.setString(1, usr.getNombre());
            pr.setString(2, usr.getApellido());
            pr.setFloat(3, usr.getPeso());
            pr.setFloat(4, usr.getAltura());
            pr.setString(5, usr.getObjetivo());
            pr.setInt(6, usr.getIdLogin());

            pr.executeUpdate();
            pr.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean actualizar(Integer id, Usuario usr) {
        
        String updateQuery = "UPDATE usuario SET nombre = ?, apellido = ?, peso = ?, altura = ?, objetivo = ? WHERE id_login = ?";

        try (PreparedStatement pr = conn.prepareStatement(updateQuery)) {
            pr.setString(1, usr.getNombre());
            pr.setString(2, usr.getApellido());
            pr.setFloat(3, usr.getPeso());
            pr.setFloat(4, usr.getAltura());
            pr.setString(5, usr.getObjetivo());
            pr.setInt(6, id);

            int affectedRows = pr.executeUpdate();
            pr.close();
            if (affectedRows > 0) {
                System.out.println("Datos actualizados correctamente.");
                return true;
            } else {
                System.out.println("No se pudo actualizar los datos.");
            }

            
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar datos: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Usuario buscarUsr(Integer id) {
        String readQuery = "SELECT * FROM usuario WHERE id_login = ?";
        Usuario usr = null;

        try (PreparedStatement pr = conn.prepareStatement(readQuery)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                usr = new Usuario(rs.getString("nombre"), rs.getString("apellido"), rs.getFloat("peso"), rs.getFloat("altura"), rs.getString("objetivo"));
            }
            pr.close();
        } catch (SQLException e) {
            System.err.println("Error al buscar el usuario: " + e.getMessage());
        }

        return usr;
    }
    
    
}
