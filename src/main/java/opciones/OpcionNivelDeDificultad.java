/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opciones;

/**
 *
 * @author brook
 */
public enum OpcionNivelDeDificultad {
    Principiante,Intermedio,Avanzado;
    
    private OpcionNivelDeDificultad(){}
    
    public String value(){
        return name();
    }
    
    public static OpcionNivelDeDificultad fromvalue(String v){
        return valueOf(v);
    }
}
