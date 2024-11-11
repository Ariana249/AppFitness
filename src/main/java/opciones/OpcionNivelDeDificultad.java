package opciones;

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
