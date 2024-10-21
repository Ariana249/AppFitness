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
public class Login {
    //Atributos
    private String nombreUsuario;
    private String clave;
    
    //Constructor
    public Login(String nombreUsuario, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    public Login() {
    }
    
    
    //Getters & Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    //Metodos
    public void crearUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre Usuario: "); setNombreUsuario(sc.nextLine());
        sc.nextLine();
        System.out.println("Clave: "); setClave(sc.nextLine());
        // hacer un bucle en donde el nombre de usuario no este tomado
    }
    
    
    public void ingresar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");setNombreUsuario(sc.nextLine());
        sc.nextLine();
        setClave(sc.nextLine());
        //verificar()
        //reintentar()
        //crear bucle do while verificar()
    }
    
    public void verificarUsuario(String nombreUsuario){
        
        //verificar nombre de usuario ingresado con los de la base de datos
        //hacer un if (nombreUsuarioIngresado == nombreUsuarioBaseDatos) = VERDADERO? en caso de ser falso reintentar()
    }
    
    public void verifiacrClave(String clave){
        //verificar clave ingresado con los de la base de datos
        //hacer un if (claveIngresado == claveBaseDatos) = VERDADERO?
    }
    
}
