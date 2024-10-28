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
    private int series;
    private int repeticiones;
    private boolean completado;
    private float caloriasAQuemar;
    //Constructor

    public ActividadFisica(int series, int repeticiones, float caloriasAQuemar) {
        this.series = series;
        this.repeticiones = repeticiones;
        this.completado = false;
        this.caloriasAQuemar = caloriasAQuemar;
    }

    public ActividadFisica() {
    }
    
    //Getters & Setters 
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    //Metodos
    public void caloriasQuemadas(){
         
    }
    public void inicializarEntrenamiento(){
        
    }
    public void finalizarEntrenamiento(){
        
    }
    public void actFisiscaCompletada(){
        this.completado = true;
    }
    
    
}
