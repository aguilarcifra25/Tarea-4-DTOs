package com.salesianos.dam.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    private Long id;

    private String codigo;
    private Integer numeroNoches;
    private Cliente cliente;
    private Habitacion habitacion;


    public double calcularPrecioReserva() {

        if (numeroNoches == null || habitacion == null || habitacion.getPrecioNoche() == null) {

            return 0.0;

        }

        return numeroNoches * habitacion.getPrecioNoche();

    }

}
