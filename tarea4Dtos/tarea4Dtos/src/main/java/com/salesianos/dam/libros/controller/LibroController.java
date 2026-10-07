package com.salesianos.dam.libros.controller;

import com.salesianos.dam.libros.dto.LibroDto;
import com.salesianos.dam.libros.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/libro")
public class LibroController {

    private final LibroService libroService;

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> getLibroById(@PathVariable Long id) {

        return ResponseEntity.ok(LibroDto.of(libroService.getLibroById(id)));

    }

}
