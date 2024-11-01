/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author brook
 */
public class Calistenia extends ActividadFisica{
    private String ejercicio;
    private String grupoMuscular;
    
    public Calistenia() {
    }

    public Calistenia(String ejercicio, String grupoMuscular, int series, int repeticiones, float caloriasAQuemar) {
        super(series, repeticiones, caloriasAQuemar);
        this.ejercicio = ejercicio;
        this.grupoMuscular = grupoMuscular;
    }    

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
    
    
}
