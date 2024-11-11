package opciones;

public enum OpcionesComida {
    Desayuno,Almuerzo,Cena;
    
    private OpcionesComida(){}
    
    public String value(){
        return name();
    }
    
    public static OpcionesComida fromvalue(String v){
        return valueOf(v);
    }
}
