/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public class Pesas extends Calistenia{
    private String tipoPesas;
    private Float peso;    

    public Pesas() {
    }

    public Pesas(String tipoPesas, Float peso, String ejercicio, String grupoMuscular, int series, int repeticiones) {
        super(ejercicio, grupoMuscular, series, repeticiones);
        this.tipoPesas = tipoPesas;
        this.peso = peso;
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


    @Override
    public void eliminar(Integer id) {
        super.eliminar(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public void guardarPesas(Pesas p){
        
    }
    
    

    

    
    
}