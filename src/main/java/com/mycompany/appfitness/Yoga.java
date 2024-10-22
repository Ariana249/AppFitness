/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public class Yoga extends ActividadFisica {
    private String poses;
    private int tiempo;

    public Yoga(String poses, int tiempo, int series, int repeticiones, float caloriasAQuemar) {
        super(series, repeticiones, caloriasAQuemar);
        this.poses = poses;
        this.tiempo = tiempo;
    }

    public Yoga() {
    }

    public String getPoses() {
        return poses;
    }

    public void setPoses(String poses) {
        this.poses = poses;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    
}
