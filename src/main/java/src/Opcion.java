package src;

public enum Opcion {
    Aumentar_Peso, Bajar_Peso;
    
    private Opcion(){}
    
    public String value(){
        return name();
    }
    
    public static Opcion fromvalue(String v){
        return valueOf(v);
    }
    
}
