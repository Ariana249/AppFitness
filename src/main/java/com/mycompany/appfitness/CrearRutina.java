package com.mycompany.appfitness;

public interface CrearRutina {
    //Metodo para agregar un ejercicio a la rutina
    void agregarEjercicio(String nombre, int repeticiones, int series, String parteCuerpo);

    // Método para eliminar un ejercicio a la rutina
    void eliminarEjercicio(String nombre);

    // Método para mostrar la rutina completa
    void mostrarRutina();
}
