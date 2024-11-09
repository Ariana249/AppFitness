/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appfitness;

import java.util.Scanner;

/**
 *
 * @author martin
 */
public class Comida {
    private int id;
    private String nombreComida;
    private float cantProteina;
    private float calorias;
    private float grasas;    

    public Comida() {
    }

    public Comida(String nombreComida, float cantProteina, float calorias, float grasas) {
        this.nombreComida = nombreComida;
        this.cantProteina = cantProteina;
        this.calorias = calorias;
        this.grasas = grasas;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public float getCantProteina() {
        return cantProteina;
    }

    public void setCantProteina(int cantProteina) {
        this.cantProteina = cantProteina;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public float getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }
    
    //Metodos

}
