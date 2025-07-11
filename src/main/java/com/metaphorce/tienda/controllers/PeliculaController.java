package com.metaphorce.tienda.controllers;

import com.metaphorce.tienda.entidades.Pelicula;
import com.metaphorce.tienda.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tiendaAPI/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public Pelicula agregarPelicula(@Valid @RequestBody Pelicula pelicula) {
        System.out.println("Agregando película: " + pelicula.getNombre());
        return peliculaService.agregarPelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable int id) {
        System.out.println("Borrando película con ID: " + id);
        peliculaService.eliminarPelicula(id);
    }

    @GetMapping
    public List<Pelicula> obtenerPeliculas() {
        System.out.println("Obteniendo todas las películas");
        return peliculaService.obtenerPeliculas();
    }

    @GetMapping("/disponibles")
    public List<Pelicula> obtenerPeliculasDisponibles() {
        System.out.println("Obteniendo el listado de películas disponibles");
        return peliculaService.obtenerPeliculasDisponibles();
    }

    @GetMapping("/nodisponibles")
    public List<Pelicula> obtenerPeliculasNoDisponibles() {
        System.out.println("Obteniendo el listado de películas no disponibles");
        return peliculaService.obtenerPeliculasNoDisponibles();
    }

    @PutMapping("/marcarDisponible/{id}")
    public void marcarComoDisponible(@PathVariable int id) {
        System.out.println("Marcando como disponible la película con ID: " + id);
        peliculaService.marcarComoDisponible(id);
    }
}
