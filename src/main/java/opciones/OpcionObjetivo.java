package opciones;

public enum OpcionObjetivo {
    Aumentar_Peso, Bajar_Peso;
    
    private OpcionObjetivo(){}
    
    public String value(){
        return name();
    }
    
    public static OpcionObjetivo fromvalue(String v){
        return valueOf(v);
    }
    
}
