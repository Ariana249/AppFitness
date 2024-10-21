/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public class Pesas extends ActividadFisica {
    private String tipoPesas;
    private Float peso;
    private String ejercicio;
    private String grupoMuscular;

    public Pesas() {
    }

    public Pesas(String tipoPesas, Float peso, String ejercicio, String grupoMuscular, int series, int repeticiones) {
        super(series, repeticiones);
        this.tipoPesas = tipoPesas;
        this.peso = peso;
        this.ejercicio = ejercicio;
        this.grupoMuscular = grupoMuscular;
    }

    public String getTipoPesas() {
        return tipoPesas;
    }

    public void setTipoPesas(String tipoPesas) {
        this.tipoPesas = tipoPesas;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
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
