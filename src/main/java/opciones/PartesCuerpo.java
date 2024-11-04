package opciones;

public enum PartesCuerpo {
    Torso, Pierna;
    
    private PartesCuerpo(){}
    
    public String value(){
        return name();
    }
    
    public static PartesCuerpo fromvalue(String v){
        return valueOf(v);
    }
    
}
