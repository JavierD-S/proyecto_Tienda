package com.metaphorce.tienda.services;

import com.metaphorce.tienda.entidades.Pelicula;
import com.metaphorce.tienda.excepciones.PeliculaNoEncontradaException;
import com.metaphorce.tienda.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    @Override
    public Pelicula agregarPelicula(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @Override
    public void eliminarPelicula(int id) {
        if (!repository.existsById(id)) {
            throw new PeliculaNoEncontradaException("Película con id " + id + " no encontrada.");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Pelicula> obtenerPeliculas() {
        return repository.findAll();
    }

    @Override
    public List<Pelicula> obtenerPeliculasDisponibles() {
        return repository.findByDisponible(true);
    }

    @Override
    public List<Pelicula> obtenerPeliculasNoDisponibles() {
        return repository.findByDisponible(false);
    }

    @Override
    public void marcarComoDisponible(int id) {
        Pelicula pelicula = repository.findById(id)
                .orElseThrow(() -> new PeliculaNoEncontradaException("Película con id " + id + " no encontrada."));
        pelicula.setDisponible(true);
        repository.save(pelicula);
    }
}
