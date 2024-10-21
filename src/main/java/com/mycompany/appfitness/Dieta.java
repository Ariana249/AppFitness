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
    private ArrayList diasSemana;
    private int caloriasDiarias;

    public Dieta() {
    }

    public Dieta(ArrayList diasSemana, int caloriasDiarias) {
        this.diasSemana = diasSemana;
        this.caloriasDiarias = caloriasDiarias;
    }

    public ArrayList getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(ArrayList diasSemana) {
        this.diasSemana = diasSemana;
    }

    public int getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(int caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }
    
    //Metodos
    public void completado(){
        //boolean
    }
}
