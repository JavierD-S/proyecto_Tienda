package com.metaphorce.tienda.services;

import com.metaphorce.tienda.entidades.Pelicula;
import java.util.List;

public interface PeliculaService {
    Pelicula agregarPelicula(Pelicula pelicula);
    void eliminarPelicula(int id);
    List<Pelicula> obtenerPeliculas();
    List<Pelicula> obtenerPeliculasDisponibles();
    List<Pelicula> obtenerPeliculasNoDisponibles();
    void marcarComoDisponible(int id);
}
