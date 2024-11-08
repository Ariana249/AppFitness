package com.mycompany.appfitness;

public class Rutina extends ActividadFisica{

    //Atributos
    private String objetivo; //fuerza o volumen
    private int frecuencia; //veces por semana
    
    //Constructor

    
    public Rutina() {
    }
  
    
    public Rutina(String objetivo, int frecuencia, String nivelDeDificultad, String nombre) {
        super(nivelDeDificultad, nombre);
        this.objetivo = objetivo;
        this.frecuencia = frecuencia;
    }

    
    //Getters & Setters 

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    

}
