package com.salesianos.dam.libros.repository;

import com.salesianos.dam.libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Long> {
}
