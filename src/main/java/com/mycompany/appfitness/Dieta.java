package com.mycompany.appfitness;

import database.ConeccionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class Dieta {

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

    //Metodos
    public Comida mostrarDieta(int idLogin, String tipo) {
        Comida c = new Comida();
        return c;
    }

}
