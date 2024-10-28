/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

import java.util.ArrayList;

/**
 *
 * @author martin
 */
public class Dieta {
    private ArrayList<Comida> lunes;
    private ArrayList<Comida> martes;
    private ArrayList<Comida> miercoles;
    private ArrayList<Comida> jueves;
    private ArrayList<Comida> viernes;
    private ArrayList<Comida> sabado;
    private ArrayList<Comida> domingo;
    private float caloriasDiarias;
    private boolean completado;
    
    public Dieta() {
    }

    public Dieta(ArrayList<Comida> lunes, ArrayList<Comida> martes, ArrayList<Comida> miercoles, ArrayList<Comida> jueves, ArrayList<Comida> viernes, ArrayList<Comida> sabado, ArrayList<Comida> domingo, float caloriasDiarias, boolean completado) {
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
        this.caloriasDiarias = caloriasDiarias;
        this.completado = completado;
    }

    public ArrayList<Comida> getLunes() {
        return lunes;
    }

    public void setLunes(ArrayList<Comida> lunes) {
        this.lunes = lunes;
    }

    public ArrayList<Comida> getMartes() {
        return martes;
    }

    public void setMartes(ArrayList<Comida> martes) {
        this.martes = martes;
    }

    public ArrayList<Comida> getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(ArrayList<Comida> miercoles) {
        this.miercoles = miercoles;
    }

    public ArrayList<Comida> getJueves() {
        return jueves;
    }

    public void setJueves(ArrayList<Comida> jueves) {
        this.jueves = jueves;
    }

    public ArrayList<Comida> getViernes() {
        return viernes;
    }

    public void setViernes(ArrayList<Comida> viernes) {
        this.viernes = viernes;
    }

    public ArrayList<Comida> getSabado() {
        return sabado;
    }

    public void setSabado(ArrayList<Comida> sabado) {
        this.sabado = sabado;
    }

    public ArrayList<Comida> getDomingo() {
        return domingo;
    }

    public void setDomingo(ArrayList<Comida> domingo) {
        this.domingo = domingo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    public float getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(int caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }
    
    
    //Metodos
    public void dietaCompletada(){
        this.completado = true;
    }
}
