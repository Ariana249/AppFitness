package com.mycompany.appfitness;

public interface CrearRutina {
    // Método para definir una rutina
    void agregarEjercicio(String nombre, int repeticiones, int series, String parteCuerpo);

    // Método para eliminar un ejercicio de la rutina
    void eliminarEjercicio(String nombre);

    // Método para mostrar la rutina completa
    void mostrarRutina();
}
