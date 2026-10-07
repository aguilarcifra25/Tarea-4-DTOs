package com.salesianos.dam.hotel.dto;

import com.salesianos.dam.hotel.model.Reserva;

public record ReservaDto(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {

    public static ReservaDto of(Reserva r) {

        String cliente = "Sin cliente asociado";
        String habitacion = "Sin habitacion asociada";

        if (r == null) {

            return null;

        }

        if (r.getCliente() != null) {

            cliente = r.getCliente().nombreCliente();

        }


        if (r.getHabitacion() != null) {

            habitacion = r.getHabitacion().datosHabitacion();

        }

        return new ReservaDto(
                r.getCodigo(),
                cliente,
                habitacion,
                r.getNumeroNoches(),
                r.calcularPrecioReserva()
        );

    }

}
