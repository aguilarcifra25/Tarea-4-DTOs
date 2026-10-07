package com.salesianos.dam.libros.service;

import com.salesianos.dam.libros.error.LibroNotFoundException;
import com.salesianos.dam.libros.model.Libro;
import com.salesianos.dam.libros.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public Libro addLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro getLibroById(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException(id));
    }

}
