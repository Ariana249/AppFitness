package com.mycompany.appfitness;

public interface GEA<T> {
    //Metodo para guardar en base de datos
    boolean guardar(T objeto);

    // Método para eliminar de base de datos
    boolean eliminar(String nombre);

    // Método para actualizar en base de datos
    boolean actualizar(Integer id, T objeto);
   
}
