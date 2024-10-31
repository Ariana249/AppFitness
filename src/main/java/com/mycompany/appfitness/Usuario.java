package com.mycompany.appfitness;

public class Usuario {
    //Atributos
    private String nombre;
    private int edad;
    private float peso;
    private float altura;
    private float imc;
    private String objetivo;
    
    //Constructor
    public Usuario() {
    }

    public Usuario(String nombre, int edad, float peso, float altura, float imc, String objetivo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.objetivo = objetivo;
    }
    
    //Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    //Metodos
    
    public void caloriasDiarias(){
        
    }
    
    public void opcionPremium(){
        
    }
    
    public void cambiarObjetivos(){
        
    }
    
    public void mostrarEstadisticas(){
        
    }
    
    public void cambiarPlan(){
        //if para cambiarse y mostrar el actual
    }
}
