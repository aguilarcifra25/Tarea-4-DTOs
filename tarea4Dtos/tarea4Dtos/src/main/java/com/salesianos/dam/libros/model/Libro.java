package com.salesianos.dam.libros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    @Id @GeneratedValue
    private Long id;

    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private Integer numeroPaginas;

    @ManyToOne
    private Autor autor;

}
