package com.salesianos.dam.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    @Id @GeneratedValue
    private Long id;

    private String numero;
    private String tipo;
    private Double precioNoche;
    private Integer planta;


    public String datosHabitacion () {

        return numero + " - " + tipo;

    }

}
