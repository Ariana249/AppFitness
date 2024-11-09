package opciones;

public enum PartesCuerpo {
    Bíceps, Tríceps, Hombros, Espalda, Pecho, Piernas, Glúteos;
    
    private PartesCuerpo(){}
    
    public String value(){
        return name();
    }
    
    public static PartesCuerpo fromvalue(String v){
        return valueOf(v);
    }
    
}
