package com.metaphorce.tienda.services;

import com.metaphorce.tienda.entidades.Pelicula;
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
        Pelicula pelicula = repository.findById(id).orElse(null);
        if (pelicula != null) {
            pelicula.setDisponible(true);
            repository.save(pelicula);
        }
    }
}
