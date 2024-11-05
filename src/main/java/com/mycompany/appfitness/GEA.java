package com.mycompany.appfitness;

public interface GEA<T> {
    //Metodo para guardar en base de datos
    void guardar(T objeto);

    // Método para eliminar de base de datos
    void eliminar(Integer id);

    // Método para actualizar en base de datos
    void actualizar(Integer id, T objeto);
}
