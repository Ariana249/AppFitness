package com.mycompany.appfitness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import src.ConeccionDB;

public class Rutina {
    //Atributos
    private int cantDias;
    private String objetivo;
    private Pesas pesas;
    private Calistenia calistenia;
    
    
    //Constructor

    public Rutina(int cantDias, String objetivo, Pesas pesas, Calistenia calistenia) {
        this.cantDias = cantDias;
        this.objetivo = objetivo;
        this.pesas = pesas;
        this.calistenia = calistenia;
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

   
    
}
