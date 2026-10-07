package com.salesianos.dam.libros.dto;

import com.salesianos.dam.libros.model.Autor;
import com.salesianos.dam.libros.model.Libro;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LibroDtoTest {

    @Test
    void libroNullDevuelveNull() {
        assertThat(LibroDto.of(null)).isNull();
    }

    @Test
    void autorConDosApellidos() {
        Autor a = Autor.builder().nombre("Gabriel").apellido1("García").apellido2("Márquez").build();
        Libro l = Libro.builder().titulo("Cien años de soledad").isbn("111")
                .anioPublicacion(1967).numeroPaginas(471).autor(a).build();

        LibroDto dto = LibroDto.of(l);

        assertThat(dto.autor()).isEqualTo("Gabriel García Márquez");
        assertThat(dto.titulo()).isEqualTo("Cien años de soledad");
        assertThat(dto.isbn()).isEqualTo("111");
        assertThat(dto.anioPublicacion()).isEqualTo(1967);
    }

    @Test
    void autorSinSegundoApellido() {
        Autor a = Autor.builder().nombre("Isaac").apellido1("Asimov").build();
        Libro l = Libro.builder().titulo("Fundación").isbn("222").anioPublicacion(1951).autor(a).build();

        assertThat(LibroDto.of(l).autor()).isEqualTo("Isaac Asimov");
    }

    @Test
    void segundoApellidoEnBlanco() {
        Autor a = Autor.builder().nombre("Isaac").apellido1("Asimov").apellido2("   ").build();
        Libro l = Libro.builder().titulo("Yo, robot").autor(a).build();

        assertThat(LibroDto.of(l).autor()).isEqualTo("Isaac Asimov");
    }

    @Test
    void libroSinAutor() {
        Libro l = Libro.builder().titulo("Anónimo").isbn("333").anioPublicacion(1500).build();

        LibroDto dto = LibroDto.of(l);

        assertThat(dto).isNotNull();
        assertThat(dto.autor()).isNull();
        assertThat(dto.titulo()).isEqualTo("Anónimo");
    }

    @Test
    void autorSinNingunDatoDeNombre() {
        Libro l = Libro.builder().titulo("Raro").autor(new Autor()).build();

        assertThat(LibroDto.of(l).autor()).isNull();
    }

    @Test
    void nuncaApareceLaPalabraNull() {
        Autor a = Autor.builder().nombre("Homero").build();
        Libro l = Libro.builder().titulo("La Ilíada").autor(a).build();

        assertThat(LibroDto.of(l).autor()).isEqualTo("Homero").doesNotContain("null");
    }
}
