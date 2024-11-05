package com.mycompany.appfitness;

public class Rutina {
    //Atributos
    private int cantDias;
    private String objetivo;
    private Ejercicio calistenia;
    
    
    //Constructor

    public Rutina(int cantDias, String objetivo, Ejercicio calistenia) {
        this.cantDias = cantDias;
        this.objetivo = objetivo;
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
    

}
