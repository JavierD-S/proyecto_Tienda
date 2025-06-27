package com.metaphorce.tienda.controllers;

import com.metaphorce.tienda.entidades.Pelicula;
import com.metaphorce.tienda.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiendaAPI/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public Pelicula agregarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.agregarPelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable int id) {
        peliculaService.eliminarPelicula(id);
    }

    @GetMapping
    public List<Pelicula> obtenerPeliculas() {
        return peliculaService.obtenerPeliculas();
    }

    @GetMapping("/disponibles")
    public List<Pelicula> obtenerPeliculasDisponibles() {
        return peliculaService.obtenerPeliculasDisponibles();
    }

    @GetMapping("/nodisponibles")
    public List<Pelicula> obtenerPeliculasNoDisponibles() {
        return peliculaService.obtenerPeliculasNoDisponibles();
    }

    @PutMapping("/marcarDisponible/{id}")
    public void marcarComoDisponible(@PathVariable int id) {
        peliculaService.marcarComoDisponible(id);
    }
}
