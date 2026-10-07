package com.salesianos.dam.libros.utils;

import com.salesianos.dam.libros.model.Autor;
import com.salesianos.dam.libros.model.Libro;
import com.salesianos.dam.libros.service.AutorService;
import com.salesianos.dam.libros.service.LibroService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeedLibros {

    private final AutorService autorService;
    private final LibroService libroService;

    @PostConstruct
    public void initData() {

        // Autor con nombre y dos apellidos
        Autor garciaMarquez = autorService.addAutor(Autor.builder()
                .nombre("Gabriel")
                .apellido1("García")
                .apellido2("Márquez")
                .nacionalidad("Colombiana")
                .build());

        // Autor sin segundo apellido
        Autor asimov = autorService.addAutor(Autor.builder()
                .nombre("Isaac")
                .apellido1("Asimov")
                .nacionalidad("Estadounidense")
                .build());

        // Autor con un solo nombre
        Autor homero = autorService.addAutor(Autor.builder()
                .nombre("Homero")
                .nacionalidad("Griega")
                .build());

        libroService.addLibro(Libro.builder()
                .titulo("Cien años de soledad").isbn("978-84-376-0494-7")
                .anioPublicacion(1967).numeroPaginas(471).autor(garciaMarquez).build());

        libroService.addLibro(Libro.builder()
                .titulo("Fundación").isbn("978-84-9759-040-5")
                .anioPublicacion(1951).numeroPaginas(255).autor(asimov).build());

        libroService.addLibro(Libro.builder()
                .titulo("La Ilíada").isbn("978-84-206-3392-0")
                .anioPublicacion(-750).numeroPaginas(560).autor(homero).build());

        // Libro SIN autor
        libroService.addLibro(Libro.builder()
                .titulo("Libro anónimo").isbn("000-00-0000-000-0")
                .anioPublicacion(1500).numeroPaginas(100).build());

    }
}
