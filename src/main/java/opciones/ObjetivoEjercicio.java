package opciones;

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
