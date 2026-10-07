package com.salesianos.dam.libros.error;

public class LibroNotFoundException extends RuntimeException {

    public LibroNotFoundException() {
        super("Libros not found");
    }

    public LibroNotFoundException(Long id) {
        super("Libro not found with id " + id);
    }

}
