package com.metaphorce.tienda.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private boolean disponible;

    public Pelicula() {}

    public Pelicula(Integer id, String nombre, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
