/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public abstract class ActividadFisica {
        //Atributos
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
