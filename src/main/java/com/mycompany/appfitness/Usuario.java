package com.mycompany.appfitness;
import java.util.Scanner;

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
    
    public void cambiarObjetivos(){
        
    }

    public void cambiarPlan(){
        //if para cambiarse y mostrar el actual
    }

//    @Override
//    public void crearUsuario() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nombre Usuario: "); setNombreUsuario(sc.nextLine());
//        sc.nextLine();
//        System.out.println("Clave: "); setClave(sc.nextLine());
//    }
//
//    @Override
//    public void ingresar() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("");setNombreUsuario(sc.nextLine());
//        sc.nextLine();
//        setClave(sc.nextLine());    
//    }
//
//    @Override
//    public void verifiacrClave(String clave) {
//        //verificar clave ingresado con los de la base de datos
//        //hacer un if (claveIngresado == claveBaseDatos) = VERDADERO?
//    }
//
//    @Override
//    public void verificarUsuario(String nombreUsuario) {
//        //verificar nombre de usuario ingresado con los de la base de datos
//        //hacer un if (nombreUsuarioIngresado == nombreUsuarioBaseDatos) = VERDADERO? en caso de ser falso reintentar()
//    }
      
}
