package com.salesianos.dam.libros.service;

import com.salesianos.dam.libros.model.Autor;
import com.salesianos.dam.libros.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public Autor addAutor(Autor autor) {
        return autorRepository.save(autor);
    }

}
