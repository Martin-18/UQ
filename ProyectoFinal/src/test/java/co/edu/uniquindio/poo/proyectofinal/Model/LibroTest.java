package co.edu.uniquindio.poo.proyectofinal.Model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    private Libro libro;


    @Test
    void testValidarRangoId() {
        libro = new Libro("El Quijote", "Miguel de Cervantes", "Novela", 1605, false);

        assertDoesNotThrow(() -> libro.validarRangoId(1));
        assertDoesNotThrow(() -> libro.validarRangoId(9999));

        IllegalArgumentException exception1 = assertThrows(
                IllegalArgumentException.class,
                () -> libro.validarRangoId(0)
        );
        assertEquals("El ID debe estar entre 1 y 9999", exception1.getMessage());
    }

}