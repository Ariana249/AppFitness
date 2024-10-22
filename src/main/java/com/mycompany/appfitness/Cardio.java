/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public class Cardio extends ActividadFisica {
    private String tipo;
    private float distancia;
    private int tiempo;

    public Cardio(String tipo, float distancia, int tiempo, int series, int repeticiones, float caloriasAQuemar) {
        super(series, repeticiones,caloriasAQuemar);
        this.tipo = tipo;
        this.distancia = distancia;
        this.tiempo = tiempo;
        
    }

    public Cardio() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    //Metodos
    public void calcularRendimiento(){
        
    }
}
