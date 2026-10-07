package com.salesianos.dam.libros.repository;

import com.salesianos.dam.libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
