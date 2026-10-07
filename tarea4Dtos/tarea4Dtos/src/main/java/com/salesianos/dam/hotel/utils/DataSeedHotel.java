package com.salesianos.dam.hotel.utils;

import com.salesianos.dam.hotel.dto.ReservaDto;
import com.salesianos.dam.hotel.model.Cliente;
import com.salesianos.dam.hotel.model.Habitacion;
import com.salesianos.dam.hotel.model.Reserva;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataSeedHotel {

    @PostConstruct
    public void initData() {

        Cliente cliente = Cliente.builder()
                .id(1L)
                .nombre("Ana")
                .apellidos("López Ruiz")
                .email("ana@correo.com")
                .telefono("600000000")
                .build();

        Habitacion habitacion = Habitacion.builder()
                .id(1L)
                .numero("101")
                .tipo("Doble")
                .precioNoche(50.0)
                .planta(1)
                .build();

        // 1. Reserva completa
        Reserva r1 = Reserva.builder()
                .id(1L)
                .codigo("R-001")
                .numeroNoches(3)
                .cliente(cliente)
                .habitacion(habitacion)
                .build();

        // 2. Sin cliente
        Reserva r2 = Reserva.builder()
                .id(2L)
                .codigo("R-002")
                .numeroNoches(2)
                .habitacion(habitacion)
                .build();

        // 3. Sin habitación
        Reserva r3 = Reserva.builder()
                .id(3L)
                .codigo("R-003")
                .numeroNoches(2)
                .cliente(cliente)
                .build();

        // 4. Sin número de noches
        Reserva r4 = Reserva.builder()
                .id(4L)
                .codigo("R-004")
                .cliente(cliente)
                .habitacion(habitacion)
                .build();

        // 5. Habitación sin precio por noche
        Reserva r5 = Reserva.builder()
                .id(5L)
                .codigo("R-005")
                .numeroNoches(4)
                .cliente(cliente)
                .habitacion(Habitacion.builder()
                        .numero("102")
                        .tipo("Individual")
                        .build())
                .build();

        // 6. Cliente sin apellidos y habitación sin tipo
        Reserva r6 = Reserva.builder()
                .id(6L)
                .codigo("R-006")
                .numeroNoches(1)
                .cliente(Cliente.builder().nombre("Luis").build())
                .habitacion(Habitacion.builder().numero("103").precioNoche(40.0).build())
                .build();

        // 7. Reserva vacía
        Reserva r7 = new Reserva();

        System.out.println("1 completa:          " + ReservaDto.of(r1));
        System.out.println("2 sin cliente:       " + ReservaDto.of(r2));
        System.out.println("3 sin habitación:    " + ReservaDto.of(r3));
        System.out.println("4 sin noches:        " + ReservaDto.of(r4));
        System.out.println("5 sin precio noche:  " + ReservaDto.of(r5));
        System.out.println("6 datos parciales:   " + ReservaDto.of(r6));
        System.out.println("7 reserva vacía:     " + ReservaDto.of(r7));
        System.out.println("8 reserva null:      " + ReservaDto.of(null));

    }

}