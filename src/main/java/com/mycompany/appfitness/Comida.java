/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public class Comida {
    private String nombre;
    private String opciones;
    
    public Comida() {
    }

    public Comida(String nombre, String opciones) {
        this.nombre = nombre;
        this.opciones = opciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }
    
    //Metodos
    public float caloriasGanadas(){
        float calGanadas = 0;
        return calGanadas;
        
    }
    
    
}
