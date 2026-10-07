package com.salesianos.dam.libros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nacionalidad;

    public String nombreAutor() {

        String resultado = "";

        if (nombre != null && !nombre.isBlank()) {
            resultado = resultado + " " + nombre.trim();
        }
        if (apellido1 != null && !apellido1.isBlank()) {
            resultado = resultado + " " + apellido1.trim();
        }
        if (apellido2 != null && !apellido2.isBlank()) {
            resultado = resultado + " " + apellido2.trim();
        }

        return resultado.trim();
    }
}
