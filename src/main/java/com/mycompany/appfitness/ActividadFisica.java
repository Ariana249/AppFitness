package com.mycompany.appfitness;

public abstract class ActividadFisica {
    //Atributos
    private int id;
    private String nivelDeDificultad; //principiante, intermedio, avanzado
    private String nombre;

    //Constructor
    public ActividadFisica() {
    }

    public ActividadFisica(String nivelDeDificultad, String nombre) {
        this.nivelDeDificultad = nivelDeDificultad;
        this.nombre = nombre;
    }

    //Getters & Setters
    public String getNivelDeDificultad() {
        return nivelDeDificultad;
    }

    public void setNivelDeDificultad(String nivelDeDificultad) {
        this.nivelDeDificultad = nivelDeDificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
