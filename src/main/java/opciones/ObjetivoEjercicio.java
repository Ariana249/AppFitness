/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opciones;

/**
 *
 * @author brook
 */
public enum ObjetivoEjercicio {
    Volumen,Fuerza;
    
    private ObjetivoEjercicio(){}
    
    public String value(){
        return name();
    }
    
    public static ObjetivoEjercicio fromvalue(String v){
        return valueOf(v);
    }
}
