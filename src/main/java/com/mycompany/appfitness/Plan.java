/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

/**
 *
 * @author martin
 */
public class Plan {
    //Atributos
    private int cantDias;
    private String objetivo;
    private Dieta dieta;
    private Pesas pesas;
    private Yoga yoga;
    private Cardio cardio;
    
    //Constructor

    public Plan(int cantDias, String objetivo) {
        this.cantDias = cantDias;
        this.objetivo = objetivo;
    }
    
    //Getters & Setters

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
      
    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Pesas getPesas() {
        return pesas;
    }

    public void setPesas(Pesas pesas) {
        this.pesas = pesas;
    }

    public Yoga getYoga() {
        return yoga;
    }

    public void setYoga(Yoga yoga) {
        this.yoga = yoga;
    }

    public Cardio getCardio() {
        return cardio;
    }

    public void setCardio(Cardio cardio) {
        this.cardio = cardio;
    }
    
}
