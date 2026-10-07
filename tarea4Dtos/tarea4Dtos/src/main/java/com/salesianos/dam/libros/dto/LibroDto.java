package com.salesianos.dam.libros.dto;

import com.salesianos.dam.libros.model.Libro;

public record LibroDto (

        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion

) {

    public static LibroDto of(Libro l) {

        if (l == null) {

            return null;

        }

        String autor = "Autor desconocido";

        if (l.getAutor() != null) {

            autor = l.getAutor().nombreAutor();

        }

        return new LibroDto(l.getTitulo(), l.getIsbn(), autor, l.getAnioPublicacion());

    }

}