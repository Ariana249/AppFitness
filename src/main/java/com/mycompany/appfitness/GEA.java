package com.mycompany.appfitness;

public interface GEA {
    //Metodo para agregar un ejercicio a la rutina
    void guardar(String id);

    // Método para eliminar un ejercicio a la rutina
    void eliminar(String id);

    // Método para mostrar la rutina completa
    void actualizar(String id);
}
